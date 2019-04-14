package it.aldi.app.security;

import it.aldi.app.domain.BimbelUser;
import it.aldi.app.service.domain.BimbelUserService;
import lombok.NonNull;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Component
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BimbelUserAuthenticationProvider implements AuthenticationProvider {

    @NonNull
    private PasswordEncoder passwordEncoder;

    @NonNull
    private BimbelUserService bimbelUserService;

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        BimbelUser bimbelUser = bimbelUserService.findByUsername(username);
        return passwordEncoder.matches(passwordEncoder.encode(password),
            bimbelUser.getPassword())
            ? new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authentication.getAuthorities())
            : null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
