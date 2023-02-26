package ir.brandomi.fullstack.springboot.jwt.repository;


import ir.brandomi.fullstack.springboot.jwt.model.ERole;
import ir.brandomi.fullstack.springboot.jwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
