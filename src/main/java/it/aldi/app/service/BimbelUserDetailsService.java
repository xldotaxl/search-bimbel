package it.aldi.app.service;

import it.aldi.app.domain.BimbelUserPrincipal;
import it.aldi.app.repository.BimbelUserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BimbelUserDetailsService implements UserDetailsService {

    @NonNull
    private BimbelUserRepository bimbelUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return bimbelUserRepository.findByUsername(username)
            .map(BimbelUserPrincipal::of)
            .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
