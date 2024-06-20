package com.example.atletikeksamenbackend.DTOs.response;

import com.example.atletikeksamenbackend.ENUMs.ResultType;
import com.example.atletikeksamenbackend.models.Participant;
import com.example.atletikeksamenbackend.models.Result;

import java.util.Set;

public record DisciplineResponseDTO(String name, ResultType resultType, Set<Participant> participants, Set<Result> results) {
    public DisciplineResponseDTO(String name, ResultType resultType) {
        this(name, resultType, null, null);
    }
}