package com.example.atletikeksamenbackend.DTOs.request;

import com.example.atletikeksamenbackend.models.Discipline;
import com.example.atletikeksamenbackend.models.Participant;

import java.time.LocalDate;

public record ResultRequestDTO(LocalDate date, double resultValue, String participantName, String disciplineName) {
}
