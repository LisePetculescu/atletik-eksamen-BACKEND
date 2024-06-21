package com.example.atletikeksamenbackend.DTOs.response;


import java.util.List;

//public record ParticipantResponseDTO(int id, String name, int age, String clubName, String gender, String ageGroup) {}
//
public record ParticipantResponseDTO(
        int id,
        String name,
        int age,
        String clubName,
        String gender,
        String ageGroup,
        List<DisciplineResponseDTO> disciplines
) {}
