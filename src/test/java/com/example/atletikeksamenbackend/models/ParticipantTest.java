package com.example.atletikeksamenbackend.models;

import com.example.atletikeksamenbackend.ENUMs.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {


    @Test
    void getAgeGroup() {
        // Arrange
        Participant participant = new Participant( "John Doe", 7, Gender.BINARY, null);

        // Act
        String result = participant.getAgeGroup().toString();

        // Assert
        assertEquals("CHILD", result);
        System.out.println("Age group: " + result);
    }

    @Test
    void setWrongAgeGroup() {
        // Arrange
        Participant participant = new Participant("John Doe", 2, Gender.BINARY, null);

        // Act
        String result = participant.getAgeGroup().toString();

        // Assert
        // check illegalArgumentException
    }

    @Test
    void testAgeOutOfRange() {
        // Arrange
        int invalidAge = 2; // An age that does not fit in any AgeGroup
        Participant participant = new Participant("John Doe", invalidAge, Gender.BINARY, null);

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, participant::getAgeGroup);

        // Assert
        assertEquals("Age out of range", exception.getMessage());
        System.out.println(exception.getMessage());
    }


}