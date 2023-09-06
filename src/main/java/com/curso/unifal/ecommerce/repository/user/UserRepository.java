package com.curso.unifal.ecommerce.repository.user;

import com.curso.unifal.ecommerce.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<List<User>> getUsersByFirstName(String firstName);

}
