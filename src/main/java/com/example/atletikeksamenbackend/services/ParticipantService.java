package com.example.atletikeksamenbackend.services;

import com.example.atletikeksamenbackend.DTOs.request.ParticipantRequestDTO;
import com.example.atletikeksamenbackend.DTOs.response.ParticipantResponseDTO;
import com.example.atletikeksamenbackend.models.Club;
import com.example.atletikeksamenbackend.models.Participant;
import com.example.atletikeksamenbackend.repositories.ClubRepository;
import com.example.atletikeksamenbackend.repositories.ParticipantRepository;
import com.example.atletikeksamenbackend.repositories.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final ClubRepository clubRepository;
    private final ResultRepository resultRepository;


    public ParticipantService(ParticipantRepository participantRepository, ClubRepository clubRepository, ResultRepository resultRepository) {
        this.participantRepository = participantRepository;
        this.clubRepository = clubRepository;
        this.resultRepository = resultRepository;
    }

    public ParticipantResponseDTO toDTO(Participant participant) {
        return new ParticipantResponseDTO(participant.getId(), participant.getName(), participant.getAge(), participant.getClub().getName(), participant.getGender().toString(),  participant.getAgeGroup().toString());
    }

    public Participant fromDTO(ParticipantRequestDTO participantRequestDTO) {
        Club club = clubRepository.findByName(participantRequestDTO.clubName())
                .orElseThrow(() -> new IllegalArgumentException("Club not found with name: " + participantRequestDTO.clubName()));

        return new Participant(participantRequestDTO.name(), participantRequestDTO.age(), participantRequestDTO.gender(), club);
    }

    public List<ParticipantResponseDTO> getAllParticipants() {
        List<Participant> participants = participantRepository.findAll();
        return participants.stream().map(this::toDTO).toList();
    }

    public ParticipantResponseDTO getParticipantById(int id) {
        Participant participant = participantRepository.findById(id).orElseThrow();
        return toDTO(participant);
    }

    public ParticipantResponseDTO createParticipant(ParticipantRequestDTO requestDTO) {
        Participant participant = fromDTO(requestDTO);
        return toDTO(participantRepository.save(participant));
    }



    public ParticipantResponseDTO updateParticipant(int id, ParticipantRequestDTO participantRequestDTO) {
        // Retrieve participant by id
        Participant participantToUpdate = participantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Participant not found with id: " + id));

        // Update participant fields
        participantToUpdate.setName(participantRequestDTO.name());
        participantToUpdate.setAge(participantRequestDTO.age());
        participantToUpdate.setGender(participantRequestDTO.gender());

        // Update club association if clubName is provided in the DTO
        if (participantRequestDTO.clubName() != null) {
            Club club = clubRepository.findByName(participantRequestDTO.clubName())
                    .orElseThrow(() -> new IllegalArgumentException("Club not found with name: " + participantRequestDTO.clubName()));
            participantToUpdate.setClub(club);
        }

        // Save updated participant and return as DTO
        return toDTO(participantRepository.save(participantToUpdate));
    }

    public void deleteParticipant(int id) {
        // Check if the participant exists
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Participant not found with id: " + id));

        // Check if the participant has any results
        boolean hasResults = !resultRepository.findAllByParticipant(participant).isEmpty();
        if (hasResults) {
            throw new IllegalArgumentException("Participant has results, cannot delete");
        }

        // Delete the participant
        participantRepository.deleteById(id);
    }


    public Optional<ParticipantResponseDTO> getParticipantByName(String name) {
        return participantRepository.findByName(name).map(this::toDTO);
    }
}
