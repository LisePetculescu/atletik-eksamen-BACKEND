package com.example.atletikeksamenbackend.DTOs.response;

import com.example.atletikeksamenbackend.ENUMs.ResultType;

//public record DisciplineResponseDTO(String name, ResultType resultType, Set<Participant> participants, Set<Result> results) {
//    public DisciplineResponseDTO(String name, ResultType resultType) {
//        this(name, resultType, null, null);
//    }
//}

public record DisciplineResponseDTO(int id, String name, ResultType resultType) {}
