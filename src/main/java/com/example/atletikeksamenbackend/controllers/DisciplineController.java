package com.example.atletikeksamenbackend.controllers;

import com.example.atletikeksamenbackend.DTOs.response.DisciplineResponseDTO;
import com.example.atletikeksamenbackend.models.Discipline;
import com.example.atletikeksamenbackend.services.DisciplineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {

    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public List<DisciplineResponseDTO> getAllDisciplines() {
        return disciplineService.getAllDisciplines();
    }

    @GetMapping("/{id}")
    public DisciplineResponseDTO getDisciplineById(@PathVariable int id) {
        return disciplineService.getDisciplineById(id);

    }





}
