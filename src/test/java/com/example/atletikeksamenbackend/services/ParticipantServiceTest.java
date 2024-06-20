package com.example.atletikeksamenbackend.services;

import com.example.atletikeksamenbackend.DTOs.request.ParticipantRequestDTO;
import com.example.atletikeksamenbackend.DTOs.response.ParticipantResponseDTO;
import com.example.atletikeksamenbackend.ENUMs.AgeGroup;
import com.example.atletikeksamenbackend.ENUMs.Gender;
import com.example.atletikeksamenbackend.models.Club;
import com.example.atletikeksamenbackend.models.Participant;
import com.example.atletikeksamenbackend.models.Result;
import com.example.atletikeksamenbackend.repositories.ClubRepository;
import com.example.atletikeksamenbackend.repositories.ParticipantRepository;
import com.example.atletikeksamenbackend.repositories.ResultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ParticipantServiceTest {

    @Mock
    private ParticipantRepository participantRepository;

    @Mock
    private ClubRepository clubRepository;

    @Mock
    private ResultRepository resultRepository;

    @InjectMocks
    private ParticipantService participantService;

    @BeforeEach
    void setUp() {
        // Initialize clubRepository mock
        clubRepository = Mockito.mock(ClubRepository.class);
        participantService = new ParticipantService(participantRepository, clubRepository, resultRepository);
    }




    @Test
    void createParticipant() {
        // Arrange
        ParticipantRequestDTO requestDTO = new ParticipantRequestDTO("John Doe", 45, "ClubName", Gender.BINARY);
        Club club = new Club("ClubName");
        Participant participant = new Participant("John Doe", 45, Gender.BINARY, club);

        // Mock the clubRepository behavior
        when(clubRepository.findByName("ClubName")).thenReturn(Optional.of(club));

        // Mock the participantRepository behavior
        when(participantRepository.save(any(Participant.class))).thenReturn(participant);

        // Act
        ParticipantResponseDTO responseDTO = participantService.createParticipant(requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals("John Doe", responseDTO.name());
        assertEquals("BINARY", responseDTO.gender());
        assertEquals("SENIOR", responseDTO.ageGroup());
        assertEquals("ClubName", responseDTO.club());

        // Verify repository interactions
        verify(clubRepository).findByName("ClubName");
        verify(participantRepository).save(any(Participant.class));
    }


    @Test
    void updateParticipant() {
        // Arrange
        // Sample existing participant
        Participant existingParticipant = new Participant("John Doe", 30, Gender.MALE, new Club("ClubName"));
        existingParticipant.setId(1); // Assign an ID to mock an existing participant

        // Updated data in DTO
        ParticipantRequestDTO requestDTO = new ParticipantRequestDTO("John Doan Updated", 32, "New ClubName", Gender.MALE);

        // Mock repository behavior
        when(participantRepository.findById(1)).thenReturn(Optional.of(existingParticipant));
        when(clubRepository.findByName("New ClubName")).thenReturn(Optional.of(new Club("New ClubName")));
        when(participantRepository.save(any(Participant.class))).thenAnswer(invocation -> {
            Participant updatedParticipant = invocation.getArgument(0);
            updatedParticipant.setId(existingParticipant.getId()); // Ensure ID remains unchanged
            return updatedParticipant;
        });

        // Act
        ParticipantResponseDTO responseDTO = participantService.updateParticipant(1, requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals("John Doan Updated", responseDTO.name());
        assertEquals("MALE", responseDTO.gender()); // Ensure gender matches the updated requestDTO
        assertEquals("ADULT", responseDTO.ageGroup()); // Assuming "ADULT" is correct based on your implementation

        // Verify repository interactions
        verify(participantRepository).findById(1);
        verify(clubRepository).findByName("New ClubName");
        verify(participantRepository).save(any(Participant.class)); // Ensure save was called with any Participant
    }


    @Test
    void deleteParticipant_ParticipantExistsAndNoResults() {
        // Arrange
        Participant participant = new Participant("John Doe", 30, Gender.MALE, new Club("ClubName"));
        participant.setId(1);

        when(participantRepository.findById(1)).thenReturn(Optional.of(participant));
        when(resultRepository.findAllByParticipant(participant)).thenReturn(Collections.emptyList());

        // Act
        participantService.deleteParticipant(1);

        // Assert
        verify(participantRepository).findById(1);
        verify(resultRepository).findAllByParticipant(participant);
        verify(participantRepository).deleteById(1);
    }

    @Test
    void deleteParticipant_ParticipantDoesNotExist() {
        // Arrange
        when(participantRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> participantService.deleteParticipant(1), "Participant not found with id: 1");

        verify(participantRepository).findById(1);
        verify(participantRepository, never()).deleteById(anyInt());
        System.out.println("Participant not found with id: 1");
    }

    /*
 verify(...): This method is used to check if a specific method
              on a mock object was called during the test.

 never(): This is a verification mode in Mockito which asserts
          that the method in question was not called at all.
          It's a shorthand for times(0).

 deleteById(anyInt()): This is the specific method on the mock object
                      you are verifying. anyInt() is a matcher provided
                      by Mockito that matches any integer.

 Putting it all together, verify(participantRepository,
                        never()).deleteById(anyInt());
                        asserts that the deleteById method on
                        the participantRepository mock was never called
                        with any integer as an argument during the test.

     */



    @Test
    void deleteParticipant_ParticipantHasResults() {
        // Arrange
        Participant participant = new Participant("John Doe", 30, Gender.MALE, new Club("ClubName"));
        participant.setId(1);
        List<Result> results = Collections.singletonList(new Result());
        when(participantRepository.findById(1)).thenReturn(Optional.of(participant));
        when(resultRepository.findAllByParticipant(any())).thenReturn(results);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> participantService.deleteParticipant(1));
        assertEquals("Participant has results, cannot delete", exception.getMessage());

        verify(participantRepository).findById(1);
        verify(resultRepository).findAllByParticipant(participant);
        verify(participantRepository, never()).deleteById(anyInt());
    }

}