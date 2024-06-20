package com.example.atletikeksamenbackend.repositories;

import com.example.atletikeksamenbackend.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    Optional<Participant> findByName(String name);
}
