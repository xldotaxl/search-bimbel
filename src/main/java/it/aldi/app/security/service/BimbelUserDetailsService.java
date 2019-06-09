package it.aldi.app.security.service;

import it.aldi.app.repository.BimbelUserRepository;
import it.aldi.app.security.model.BimbelUserPrincipal;
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

    private @NonNull BimbelUserRepository bimbelUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return bimbelUserRepository.findByUsernameWithEagerRelationships(username)
            .map(BimbelUserPrincipal::of)
            .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
