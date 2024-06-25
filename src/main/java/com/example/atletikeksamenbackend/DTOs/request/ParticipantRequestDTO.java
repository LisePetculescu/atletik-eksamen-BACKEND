package com.example.atletikeksamenbackend.DTOs.request;

import com.example.atletikeksamenbackend.ENUMs.Gender;
import com.example.atletikeksamenbackend.models.Discipline;



import java.util.Set;

public record ParticipantRequestDTO(String name, int age, Gender gender, String clubName, Set<Discipline> disciplines) {

//    public ParticipantRequestDTO(String name, int age, Gender gender, String clubName) {
//        this(name, age, gender, clubName, null );
//    }

}
