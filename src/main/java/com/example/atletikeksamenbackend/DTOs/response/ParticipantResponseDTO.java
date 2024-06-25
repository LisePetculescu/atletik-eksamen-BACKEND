package com.example.atletikeksamenbackend.DTOs.response;


import com.example.atletikeksamenbackend.ENUMs.AgeGroup;
import com.example.atletikeksamenbackend.ENUMs.Gender;
import com.example.atletikeksamenbackend.models.Result;

import java.util.List;

//public record ParticipantResponseDTO(int id, String name, int age, String clubName, String gender, String ageGroup) {}
//
public record ParticipantResponseDTO(
        int id,
        String name,
        int age,
        String clubName,
        Gender gender,
        AgeGroup ageGroup,
        List<DisciplineResponseDTO> disciplines,
        List<Result> results

) {}
