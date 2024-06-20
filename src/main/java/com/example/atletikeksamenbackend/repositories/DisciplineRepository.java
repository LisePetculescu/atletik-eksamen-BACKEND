package com.example.atletikeksamenbackend.repositories;

import com.example.atletikeksamenbackend.models.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {
    Optional<Discipline> findByName(String name);
}
