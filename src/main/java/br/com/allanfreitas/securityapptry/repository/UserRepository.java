package br.com.allanfreitas.securityapptry.repository;

import br.com.allanfreitas.securityapptry.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
