package it.aldi.app.service.register;

import it.aldi.app.controller.dto.BimbelUserDto;
import it.aldi.app.domain.BimbelUser;
import it.aldi.app.domain.Role;

import java.util.List;

public interface RegisterService {
    BimbelUser registerUser(BimbelUserDto bimbelUserDto);

    List<Role> getRolesList();

    String verifyExistingData(BimbelUserDto bimbelUserDto);
}
