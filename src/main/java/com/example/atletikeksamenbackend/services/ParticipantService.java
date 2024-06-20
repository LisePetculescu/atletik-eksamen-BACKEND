package com.example.atletikeksamenbackend.services;

import com.example.atletikeksamenbackend.DTOs.request.ParticipantRequestDTO;
import com.example.atletikeksamenbackend.DTOs.response.ParticipantResponseDTO;
import com.example.atletikeksamenbackend.models.Participant;
import com.example.atletikeksamenbackend.repositories.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;


    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public ParticipantResponseDTO toDTO(Participant participant) {
        return new ParticipantResponseDTO(participant.getId(), participant.getName(), participant.getClub().getName(), participant.getGender().toString(),  participant.getAgeGroup().toString(), participant.getDisciplines(), participant.getResults());
    }

    public Participant fromDTO(ParticipantRequestDTO participantRequestDTO) {
        return new Participant(participantRequestDTO.name(), participantRequestDTO.age(), participantRequestDTO.gender(), participantRequestDTO.club());
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

    public ParticipantResponseDTO updateParticipant(int id, ParticipantRequestDTO participant) {
        Participant participantToUpdate = participantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Participant not found with id: " + id));

        participantToUpdate.setName(participant.name());
        participantToUpdate.setAge(participant.age());
        participantToUpdate.setGender(participant.gender());
        participantToUpdate.setClub(participant.club());

        return toDTO(participantRepository.save(participantToUpdate));
    }


    public void deleteParticipant(int id) {
        // Check if the participant exists
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Participant not found with id: " + id));


        // check if the participant has any results
        boolean hasResults = participant.getResults().isEmpty();
        if (!hasResults) {
            throw new IllegalArgumentException("Participant has results, cannot delete");
        }

        // delete the participant
        participantRepository.deleteById(id);
    }
}
