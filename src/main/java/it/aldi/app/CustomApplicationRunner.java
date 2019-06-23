package it.aldi.app;

import it.aldi.app.controller.dto.BimbelUserDto;
import it.aldi.app.repository.BimbelUserRepository;
import it.aldi.app.service.register.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public final class CustomApplicationRunner implements ApplicationRunner {

    private final RegisterService registerService;

    private final BimbelUserRepository bimbelUserRepository;

    @Autowired
    private CustomApplicationRunner(RegisterService registerService, BimbelUserRepository bimbelUserRepository) {
        this.registerService = registerService;
        this.bimbelUserRepository = bimbelUserRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) {
        if (bimbelUserRepository.count() < 1) {
            insertInitialUser();
        }
    }

    private void insertInitialUser() {
        List<BimbelUserDto> bimbelUserDtos = new ArrayList<>();
        bimbelUserDtos.add(BimbelUserDto.builder()
            .email("rivaldi.saputra@jurnal.id")
            .username("rivaldi.saputra")
            .password("aldi123")
            .name("Rivaldi Saputra")
            .roles("OWNER")
            .build());

        for (BimbelUserDto bimbelUserDto : bimbelUserDtos) {
            registerService.registerUser(bimbelUserDto);
        }
    }
}
