package it.aldi.app.security.util;

import it.aldi.app.controller.Routes;
import it.aldi.app.domain.Role;
import it.aldi.app.util.RoleConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

@Slf4j
public final class SecurityUtil {

    private SecurityUtil() {
    }

    public static String getTargetUrlBasedOnRole(Set<GrantedAuthority> authorities) {
        log.debug("user role is: {}", authorities);

        if (authorities.contains(new SimpleGrantedAuthority(RoleConstant.owner()))) {
            return Routes.OWNER_HOME;
        }
        if (authorities.contains(new SimpleGrantedAuthority(RoleConstant.tutor()))) {
            return Routes.TUTOR_HOME;
        }
        if (authorities.contains(new SimpleGrantedAuthority(RoleConstant.student()))) {
            return Routes.STUDENT_HOME;
        }

        return Routes.HOME;
    }

    public static boolean isOwner(Set<Role> roles) {
        return roles.contains(Role.owner());
    }

    public static boolean isTutor(Set<Role> roles) {
        return roles.contains(Role.tutor());
    }

    public static boolean isStudent(Set<Role> roles) {
        return roles.contains(Role.student());
    }
}
