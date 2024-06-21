package com.example.atletikeksamenbackend.services;

import com.example.atletikeksamenbackend.DTOs.response.DisciplineResponseDTO;
import com.example.atletikeksamenbackend.models.Discipline;
import com.example.atletikeksamenbackend.repositories.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public DisciplineResponseDTO toDTO(Discipline discipline) {
        return new DisciplineResponseDTO(discipline.getId(), discipline.getName(), discipline.getResultType().toString());
    }

//    public Discipline fromDTO(DisciplineResponseDTO disciplineResponseDTO) {
//        return new Discipline(disciplineResponseDTO.name(), disciplineResponseDTO.resultType());
//    }

    public List<DisciplineResponseDTO> getAllDisciplines() {
        List<Discipline> disciplines = disciplineRepository.findAll();
        return disciplines.stream().map(this::toDTO).toList();
    }

    public DisciplineResponseDTO getDisciplineById(int id) {
        Discipline discipline = disciplineRepository.findById(id).orElseThrow();
        return toDTO(discipline);
    }

}




