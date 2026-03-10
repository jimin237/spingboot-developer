package me.scpark.springdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRespository extends JpaRepository<Member, Long> {
}
