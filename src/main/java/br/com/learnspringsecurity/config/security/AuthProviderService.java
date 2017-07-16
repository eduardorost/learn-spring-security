package br.com.learnspringsecurity.config.security;

import br.com.learnspringsecurity.entities.UserEntity;
import br.com.learnspringsecurity.models.User;
import br.com.learnspringsecurity.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class AuthProviderService implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String login = auth.getName();
        String password = auth.getCredentials().toString();

        Optional<UserEntity> usuarioOptional = userRepository.findFirstByLoginAndPassword(login, password);

        if (!usuarioOptional.isPresent())
            throw new UsernameNotFoundException("Invalid user or password.");

        UserEntity userEntity = usuarioOptional.get();
        if (!userEntity.getEnable())
            throw new BadCredentialsException("User disabled.");

        Collection<? extends GrantedAuthority> authorities = userEntity.getRoles();
        return new UsernamePasswordAuthenticationToken(new ModelMapper().map(userEntity, User.class), password, authorities);
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}