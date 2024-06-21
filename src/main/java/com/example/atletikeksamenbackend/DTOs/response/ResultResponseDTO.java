package com.example.atletikeksamenbackend.DTOs.response;

import java.time.LocalDate;

//public record ResultResponseDTO(LocalDate date, double resultValue, String participantName, String disciplineName, String resultType) {
//}

public record ResultResponseDTO(int id, LocalDate date, double resultValue, String participantName, String disciplineName, String resultType,
                                java.util.List<DisciplineResponseDTO> disciplines) {}
