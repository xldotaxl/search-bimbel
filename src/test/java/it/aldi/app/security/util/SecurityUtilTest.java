package it.aldi.app.security.util;

import it.aldi.app.domain.Role;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SecurityUtilTest {

    @Test
    public void isOwner() {
        Role persistentOwner = Role.valueOf(1L, "OWNER");
        Role persistentStudent = Role.valueOf(2L, "STUDENT");
        Set<Role> roles = new HashSet<>(Arrays.asList(persistentOwner, persistentStudent));
        Role owner = Role.owner();

        assertEquals("Object should be equal", persistentOwner, owner);
        assertTrue("Set should contains OWNER", SecurityUtil.isOwner(roles));
    }
}
