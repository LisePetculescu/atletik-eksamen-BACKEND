package com.example.atletikeksamenbackend.repositories;

import com.example.atletikeksamenbackend.models.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {
}
