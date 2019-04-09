package it.aldi.app;

import it.aldi.app.domain.BimbelUser;
import it.aldi.app.repository.BimbelUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public final class CustomApplicationRunner implements ApplicationRunner {

    private final BimbelUserRepository bimbelUserRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private CustomApplicationRunner(BimbelUserRepository bimbelUserRepository) {
        this.bimbelUserRepository = bimbelUserRepository;
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void run(ApplicationArguments applicationArguments) {
        List<BimbelUser> bimbelUsers = new ArrayList<>();
        bimbelUsers.add(BimbelUser.builder()
            .id(1L)
            .username("rivaldi.saputra")
            .email("cbot59@gmail.com")
            .name("Rivaldi Saputra")
            .password(passwordEncoder.encode("jurnal123"))
            .build());
        bimbelUserRepository.save(bimbelUsers);
    }
}
