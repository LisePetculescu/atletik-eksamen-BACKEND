package com.example.atletikeksamenbackend.repositories;

import com.example.atletikeksamenbackend.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Integer> {

    Optional<Club> findByName(String name);
}
