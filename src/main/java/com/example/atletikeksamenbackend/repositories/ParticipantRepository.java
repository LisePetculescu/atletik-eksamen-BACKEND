package com.example.atletikeksamenbackend.repositories;

import com.example.atletikeksamenbackend.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

}
