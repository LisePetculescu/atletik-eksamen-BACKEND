package com.example.atletikeksamenbackend.DTOs.request;

import com.example.atletikeksamenbackend.ENUMs.Gender;
import com.example.atletikeksamenbackend.models.Result;

import java.util.List;

public record ParticipantRequestDTO(String name, int age, Gender gender, String clubName, List<Result> results) {

    public ParticipantRequestDTO(String name, int age, Gender gender, String clubName) {
        this(name, age, gender, clubName, null);
    }
}
