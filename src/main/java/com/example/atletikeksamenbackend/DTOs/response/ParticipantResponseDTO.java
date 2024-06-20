package com.example.atletikeksamenbackend.DTOs.response;


import com.example.atletikeksamenbackend.models.Discipline;
import com.example.atletikeksamenbackend.models.Result;

import java.util.List;
import java.util.Set;

public record ParticipantResponseDTO(int id, String name, String club, String gender, String ageGroup, Set<Discipline> disciplines, List<Result> results) {

    public ParticipantResponseDTO(int id, String name, String Club, String gender, String ageGroup) {
        this(id, name, Club, gender, ageGroup, null, null);

    }


}
