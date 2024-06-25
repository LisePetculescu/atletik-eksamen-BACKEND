package com.example.atletikeksamenbackend.DTOs.response;


import com.example.atletikeksamenbackend.ENUMs.AgeGroup;
import com.example.atletikeksamenbackend.ENUMs.Gender;

import java.util.List;
import java.util.Set;

//public record ParticipantResponseDTO(int id, String name, int age, String clubName, String gender, String ageGroup) {}
//
public record ParticipantResponseDTO(
        int id,
        String name,
        int age,
        String clubName,
        Gender gender,
        AgeGroup ageGroup,
        List<DisciplineResponseDTO> disciplines
) {}
