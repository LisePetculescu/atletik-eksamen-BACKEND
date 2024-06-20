package com.example.atletikeksamenbackend.DTOs.response;

import java.time.LocalDate;

public record ResultResponseDTO(LocalDate date, double resultValue, String participantName, String disciplineName, String resultType) {
}
