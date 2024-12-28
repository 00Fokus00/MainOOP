package ru.vsu.L8.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.L8.db.Template;

@Repository
public interface UserRepository extends JpaRepository<Template, Integer> {
}
