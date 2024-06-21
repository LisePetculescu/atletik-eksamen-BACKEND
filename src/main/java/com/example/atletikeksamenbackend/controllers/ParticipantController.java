package com.example.atletikeksamenbackend.controllers;

import com.example.atletikeksamenbackend.DTOs.request.ParticipantRequestDTO;
import com.example.atletikeksamenbackend.DTOs.response.ParticipantResponseDTO;
import com.example.atletikeksamenbackend.services.ParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/participant")
@CrossOrigin(origins = "http://localhost:5173")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping
    public List<ParticipantResponseDTO> getAllParticipants() {
        return participantService.getAllParticipants();
    }

    @GetMapping("/{id}")
    public ParticipantResponseDTO getParticipantById(@PathVariable int id) {
        return participantService.getParticipantById(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ParticipantResponseDTO> getParticipantByName(@PathVariable String name) {
        Optional<ParticipantResponseDTO> participant = participantService.getParticipantByName(name);

        return participant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ParticipantResponseDTO> createParticipant(@RequestBody ParticipantRequestDTO requestDTO) {
        try {
            // Create a participant using the service
            var participantResponse = participantService.createParticipant(requestDTO);

            // Return the created participant as a response
            return ResponseEntity.ok(participantResponse);

        } catch (IllegalArgumentException e) {
            // Handle invalid input error
            return ResponseEntity.badRequest().build();        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipantResponseDTO> updateParticipant(@PathVariable int id, @RequestBody ParticipantRequestDTO participant) {
        try {
            // Update a participant using the service
            ParticipantResponseDTO updatedParticipant = participantService.updateParticipant(id, participant);
            // Return the updated participant as a response
            return ResponseEntity.ok(updatedParticipant);
        } catch (IllegalArgumentException e) {
            // Handle invalid input error
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParticipant(@PathVariable int id) {
        try {
            // Delete a participant using the service
            participantService.deleteParticipant(id);
            // Return a response
            return ResponseEntity.ok("Participant deleted");
        } catch (IllegalArgumentException e) {
            // Handle invalid input error
            return ResponseEntity.notFound().build();
        }
    }

}
