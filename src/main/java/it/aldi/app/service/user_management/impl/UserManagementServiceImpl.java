package it.aldi.app.service.user_management.impl;

import it.aldi.app.controller.rest.dto.response.TutorDto;
import it.aldi.app.domain.BimbelUser;
import it.aldi.app.service.domain.BimbelUserService;
import it.aldi.app.service.user_management.UserManagementService;
import it.aldi.app.util.RoleConstant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    private final BimbelUserService bimbelUserService;

    public UserManagementServiceImpl(BimbelUserService bimbelUserService) {
        this.bimbelUserService = bimbelUserService;
    }

    @Override
    public List<TutorDto> getTutors(Long organizationId) {
        List<BimbelUser> bimbelUsers = bimbelUserService.findAllByOrganizationAndRole(organizationId,
            RoleConstant.tutor()
        );

        return bimbelUsers.stream()
            .map(bimbelUser -> TutorDto.valueOf(bimbelUser.getName(), bimbelUser.getEmail()))
            .collect(Collectors.toList());
    }
}
