package it.aldi.app.security;

import it.aldi.app.controller.Routes;
import it.aldi.app.util.RoleConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Set<GrantedAuthority> authorities = new HashSet<>(authentication.getAuthorities());
        String targetUrl = getTargetUrlBasedOnRole(authorities);

        log.debug("targetUrl is: {}", targetUrl);

        setDefaultTargetUrl(targetUrl);
        super.onAuthenticationSuccess(request, response, authentication);
    }

    private String getTargetUrlBasedOnRole(Set<GrantedAuthority> authorities) {
        for (GrantedAuthority grantedAuthority : authorities) {
            if (RoleConstant.owner().equals(grantedAuthority.getAuthority())) {
                return Routes.OWNER_HOME;
            }
            if (RoleConstant.tutor().equals(grantedAuthority.getAuthority())) {
                return Routes.TUTOR_HOME;
            }
            if (RoleConstant.student().equals(grantedAuthority.getAuthority())) {
                return Routes.STUDENT_HOME;
            }
        }

        return Routes.INDEX;
    }
}
