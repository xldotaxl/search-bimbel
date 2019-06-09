package it.aldi.app.security.model;

import it.aldi.app.domain.BimbelUser;
import it.aldi.app.domain.Role;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Value(staticConstructor = "of")
public class BimbelUserPrincipal implements UserDetails {

    private final BimbelUser bimbelUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : bimbelUser.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return bimbelUser.getPassword();
    }

    @Override
    public String getUsername() {
        return bimbelUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
