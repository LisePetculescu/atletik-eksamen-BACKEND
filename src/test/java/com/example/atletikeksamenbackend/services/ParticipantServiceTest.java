package com.example.atletikeksamenbackend.services;

import com.example.atletikeksamenbackend.DTOs.request.ParticipantRequestDTO;
import com.example.atletikeksamenbackend.DTOs.response.ParticipantResponseDTO;
import com.example.atletikeksamenbackend.ENUMs.AgeGroup;
import com.example.atletikeksamenbackend.ENUMs.Gender;
import com.example.atletikeksamenbackend.models.Club;
import com.example.atletikeksamenbackend.models.Participant;
import com.example.atletikeksamenbackend.repositories.ParticipantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
class ParticipantServiceTest {

    @Mock
    private ParticipantRepository participantRepository;

    @InjectMocks
    private ParticipantService participantService;

    @Test
    void toDTO() {
    }

    @Test
    void fromDTO() {
    }

    @Test
    void getAllParticipants() {
    }

    @Test
    void getParticipantById() {
    }

//    @Test
//    void createParticipant() {
//        // create an integration test that tests creating a new participent and saving it to the database using mockito
//
//
//            // Arrange
//            Participant participant = new Participant("John Doe", 45, Gender.BINARY, null);
//            // Act
//        participantService.save(participant);
//            // Assert
//        verify(participantRepository).save(participant);
//
//
//    }


//@Test
//void createParticipant() {
//    // Arrange
//    ParticipantRequestDTO requestDTO = new ParticipantRequestDTO("John Doe", 45, null, Gender.BINARY);
//    Participant participant = new Participant("John Doe", 45, Gender.BINARY, new Club("ClubName"));
//
//
//
//    // Mock repository behavior
//    when(participantRepository.save(any(Participant.class))).thenReturn(participant);
//
//    // Act
//    ParticipantResponseDTO responseDTO = participantService.createParticipant(requestDTO);
//
//    // Assert
//    assertNotNull(responseDTO);
//    assertEquals("John Doe", responseDTO.name());
//    assertEquals("BINARY", responseDTO.gender()); // Ensure gender is asserted correctly based on ParticipantResponseDTO
//    assertEquals("SENIOR", responseDTO.ageGroup()); // Assuming ADULT is a valid age group based on ParticipantResponseDTO
//
//    verify(participantRepository).save(participant);
//}

    @Test
    void createParticipant() {
        // Arrange
        ParticipantRequestDTO requestDTO = new ParticipantRequestDTO("John Doe", 45, null, Gender.BINARY);
        Participant participant = new Participant("John Doe", 45, Gender.BINARY, new Club("ClubName"));

        // Mock repository behavior
        when(participantRepository.save(any(Participant.class))).thenReturn(participant);

        // Act
        ParticipantResponseDTO responseDTO = participantService.createParticipant(requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals("John Doe", responseDTO.name());
        assertEquals("BINARY", responseDTO.gender()); // Ensure gender is asserted correctly based on ParticipantResponseDTO
        assertEquals("SENIOR", responseDTO.ageGroup()); // Assuming ADULT is a valid age group based on ParticipantResponseDTO

        verify(participantRepository).save(any(Participant.class));
    }




    @Test
    void updateParticipant() {
    }

    @Test
    void deleteParticipant() {
    }
}