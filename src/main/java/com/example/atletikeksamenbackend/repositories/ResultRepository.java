package com.example.atletikeksamenbackend.repositories;

import com.example.atletikeksamenbackend.models.Participant;
import com.example.atletikeksamenbackend.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Integer> {
    List<Result> findAllByParticipant(Participant participant);
}

