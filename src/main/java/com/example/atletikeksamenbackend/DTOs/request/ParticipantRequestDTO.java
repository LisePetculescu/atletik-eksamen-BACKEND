package com.example.atletikeksamenbackend.DTOs.request;

import com.example.atletikeksamenbackend.ENUMs.Gender;
import com.example.atletikeksamenbackend.models.Club;

public record ParticipantRequestDTO(String name, int age, String clubName, Gender gender) {

}
