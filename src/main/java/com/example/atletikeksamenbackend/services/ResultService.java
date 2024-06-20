package com.example.atletikeksamenbackend.services;

import com.example.atletikeksamenbackend.DTOs.request.ResultRequestDTO;
import com.example.atletikeksamenbackend.DTOs.response.ResultResponseDTO;
import com.example.atletikeksamenbackend.models.Discipline;
import com.example.atletikeksamenbackend.models.Participant;
import com.example.atletikeksamenbackend.models.Result;
import com.example.atletikeksamenbackend.repositories.DisciplineRepository;
import com.example.atletikeksamenbackend.repositories.ParticipantRepository;
import com.example.atletikeksamenbackend.repositories.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;
    private final ParticipantRepository participantRepository;
    private final DisciplineRepository disciplineRepository;

    public ResultService(ResultRepository resultRepository, ParticipantRepository participantRepository, DisciplineRepository disciplineRepository) {
        this.resultRepository = resultRepository;
        this.participantRepository = participantRepository;
        this.disciplineRepository = disciplineRepository;
    }

    public ResultResponseDTO toDTO(Result result) {
        return new ResultResponseDTO(result.getId(), result.getDate(), result.getResultValue(), result.getDiscipline().getName(), result.getResultType());
    }

    public Result fromDTO(ResultRequestDTO resultRequestDTO) {
        Participant participant = participantRepository.findByName(resultRequestDTO.participantName())
                .orElseThrow(() -> new IllegalArgumentException("Participant not found with name: " + resultRequestDTO.participantName()));
        Discipline discipline = disciplineRepository.findByName(resultRequestDTO.disciplineName())
                .orElseThrow(() -> new IllegalArgumentException("Discipline not found with name: " + resultRequestDTO.disciplineName()));
        return new Result(resultRequestDTO.date(), resultRequestDTO.resultValue(), participant, discipline);
    }

    public List<ResultResponseDTO> getAllResults() {
        List<Result> results = resultRepository.findAll();
        return results.stream().map(this::toDTO).toList();
    }

    public ResultResponseDTO getResultById(int id) {
        Result result = resultRepository.findById(id).orElseThrow();
        return toDTO(result);
    }

    public ResultResponseDTO createResult(ResultRequestDTO requestDTO) {
        Result result = fromDTO(requestDTO);
        return toDTO(resultRepository.save(result));
    }

    public ResultResponseDTO updateResult(int id, ResultRequestDTO result) {
        Result resultToUpdate = resultRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Result not found with id: " + id));

        resultToUpdate.setDate(result.date());
        resultToUpdate.setResultValue(result.resultValue());
        resultToUpdate.setParticipant(participantRepository.findByName(result.participantName())
                .orElseThrow(() -> new IllegalArgumentException("Participant not found with name: " + result.participantName())));
        resultToUpdate.setDiscipline(disciplineRepository.findByName(result.disciplineName())
                .orElseThrow(() -> new IllegalArgumentException("Discipline not found with name: " + result.disciplineName())));

        return toDTO(resultRepository.save(resultToUpdate));
    }

    public void deleteResult(int id) {
        // Check if the result exists
        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Result not found with id: " + id));

        // delete the result
        resultRepository.delete(result);
    }
}
