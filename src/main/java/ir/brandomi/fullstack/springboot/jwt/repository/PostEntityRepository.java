package ir.brandomi.fullstack.springboot.jwt.repository;

import ir.brandomi.fullstack.springboot.jwt.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity,Integer> {
}
