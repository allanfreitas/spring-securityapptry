package br.com.allanfreitas.securityapptry.config;

import br.com.allanfreitas.securityapptry.model.User;
import br.com.allanfreitas.securityapptry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Qualifier("MyUserDetailsService")
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = repo.findByUsername(s);
        if (user == null)
            throw new UsernameNotFoundException("User not found");

        return new UserPrincipal(user);
    }
}
