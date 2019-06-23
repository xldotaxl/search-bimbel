package it.aldi.app.security.util;

import it.aldi.app.domain.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@Slf4j
public class SecurityUtilTest {

    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    public void isOwner() {
        Role persistentOwner = Role.valueOf(1L, "OWNER");
        Role persistentStudent = Role.valueOf(2L, "STUDENT");
        Set<Role> roles = new HashSet<>(Arrays.asList(persistentOwner, persistentStudent));
        Role owner = Role.owner();

        assertEquals("Object should be equal", persistentOwner, owner);
        assertTrue("Set should contains OWNER", SecurityUtil.isOwner(roles));
    }

    @Test
    public void encodePassword() {
        String password = "aldi123";
        String encodedPassword = passwordEncoder.encode(password);

        log.info("encoded password: {}", encodedPassword);
        assertTrue("Password should be matched", passwordEncoder.matches(password, encodedPassword));
    }
}
