package it.aldi.app.service.register.impl;

import it.aldi.app.controller.dto.BimbelUserDto;
import it.aldi.app.domain.BimbelUser;
import it.aldi.app.domain.Role;
import it.aldi.app.service.domain.BimbelUserService;
import it.aldi.app.service.domain.RoleService;
import it.aldi.app.service.register.RegisterService;
import it.aldi.app.util.ErrorMsgConstant;
import it.aldi.app.util.RoleConstant;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RegisterServiceImpl implements RegisterService {
    private static final String SUPER_ADMIN = "SUPER_ADMIN";
    private static final String OWNER = "OWNER";

    private final ErrorMsgConstant errorMsgConstant;

    private final BimbelUserService bimbelUserService;

    private final RoleService roleService;

    public RegisterServiceImpl(ErrorMsgConstant errorMsgConstant, BimbelUserService bimbelUserService,
                               RoleService roleService) {
        this.errorMsgConstant = errorMsgConstant;
        this.bimbelUserService = bimbelUserService;
        this.roleService = roleService;
    }

    @Override
    public BimbelUser registerUser(BimbelUserDto bimbelUserDto) {
        Set<Role> assignedRoles = assignRoles(bimbelUserDto);
        BimbelUser bimbelUser = BimbelUser.register(bimbelUserDto, assignedRoles);
        return bimbelUserService.save(bimbelUser);
    }

    @Override
    public List<Role> getPublicRoles() {
        return roleService.findAll().stream()
            .filter(role -> !SUPER_ADMIN.equalsIgnoreCase(role.getName()))
            .collect(Collectors.toList());
    }

    @Override
    public String verifyExistingData(BimbelUserDto bimbelUserDto) {
        if (bimbelUserService.findByUsername(bimbelUserDto.getUsername()) != null) {
            return errorMsgConstant.getUsernameExists();
        }
        if (bimbelUserService.findByEmail(bimbelUserDto.getEmail()) != null) {
            return errorMsgConstant.getEmailExists();
        }
        return "";
    }

    private Set<Role> assignRoles(BimbelUserDto bimbelUserDto) {
        List<Role> availableRoles = roleService.findAll();
        switch (bimbelUserDto.getRoles()) {
            case SUPER_ADMIN:
                return everyRoles(availableRoles);
            case OWNER:
                return managementRoles(availableRoles);
            default:
                return singleRole(bimbelUserDto, availableRoles);
        }
    }

    private static Set<Role> singleRole(BimbelUserDto bimbelUserDto, List<Role> availableRoles) {
        return availableRoles.stream()
            .filter(role -> role.getName().equalsIgnoreCase(bimbelUserDto.getRoles()))
            .collect(Collectors.toSet());
    }

    private static Set<Role> managementRoles(List<Role> availableRoles) {
        return availableRoles.stream()
            .filter(RegisterServiceImpl::isManagementRole)
            .collect(Collectors.toSet());
    }

    private static boolean isManagementRole(Role role) {
        return role.getName().equalsIgnoreCase(RoleConstant.owner())
            || role.getName().equalsIgnoreCase(RoleConstant.tutor());
    }

    private static Set<Role> everyRoles(List<Role> availableRoles) {
        return new HashSet<>(availableRoles);
    }
}
