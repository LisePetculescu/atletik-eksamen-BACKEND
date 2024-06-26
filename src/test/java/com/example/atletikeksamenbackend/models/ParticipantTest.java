package com.example.atletikeksamenbackend.models;

import com.example.atletikeksamenbackend.ENUMs.Gender;
import com.example.atletikeksamenbackend.ENUMs.ResultType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {


    @Test
    void getAgeGroup() {
        // Arrange
        Set<Discipline> initialDisciplines = new HashSet<>(Arrays.asList(new Discipline("Running", ResultType.TIME), new Discipline("Swimming", ResultType.DISTANCE)));
        Participant participant = new Participant("John Doe", 7, Gender.MALE, new Club("ClubName"), initialDisciplines);
//        Participant participant = new Participant( "John Doe", 7, Gender.BINARY, null, null);

        // Act
        String result = participant.getAgeGroup().toString();

        // Assert
        assertEquals("CHILD", result);
        System.out.println("Age group: " + result);
    }



    @Test
    void setWrongAgeGroup() {
        // Arrange
        Set<Discipline> initialDisciplines = new HashSet<>(Arrays.asList(new Discipline("Running", ResultType.TIME), new Discipline("Swimming", ResultType.DISTANCE)));
        Participant participant = new Participant("John Doe", 2, Gender.MALE, new Club("ClubName"), initialDisciplines);
//        Participant participant = new Participant("John Doe", 20, Gender.BINARY, null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, participant::getAgeGroup);
//        String result = participant.getAgeGroup().toString();




    }

    @Test
    void testAgeOutOfRange() {
        // Arrange
        int invalidAge = 2; // An age that does not fit in any AgeGroup
        Set<Discipline> initialDisciplines = new HashSet<>(Arrays.asList(new Discipline("Running", ResultType.TIME), new Discipline("Swimming", ResultType.DISTANCE)));
        Participant participant = new Participant("John Doe", invalidAge, Gender.MALE, new Club("ClubName"), initialDisciplines);

//        Participant participant = new Participant("John Doe", invalidAge, Gender.BINARY, null);

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, participant::getAgeGroup);

        // Assert
        assertEquals("Age out of range", exception.getMessage());
        System.out.println(exception.getMessage());
    }


}