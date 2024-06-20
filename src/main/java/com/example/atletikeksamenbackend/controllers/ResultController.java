package com.example.atletikeksamenbackend.controllers;

import com.example.atletikeksamenbackend.DTOs.request.ResultRequestDTO;
import com.example.atletikeksamenbackend.DTOs.response.ResultResponseDTO;
import com.example.atletikeksamenbackend.services.ResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
@CrossOrigin(origins = "http://localhost:5173")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public List<ResultResponseDTO> getAllResults() {
        return resultService.getAllResults();
    }

    @GetMapping("/{id}")
    public ResultResponseDTO getResultById(@PathVariable int id) {
        return resultService.getResultById(id);
    }

    @PostMapping
    public ResponseEntity<ResultResponseDTO> createResult(@RequestBody ResultRequestDTO requestDTO) {
        try {
            // Create a result using the service
            var resultResponse = resultService.createResult(requestDTO);

            // Return the created result as a response
            return  new ResponseEntity<>(resultResponse, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            // Handle invalid input error
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultResponseDTO> updateResult(@PathVariable int id, @RequestBody ResultRequestDTO result) {
        try {
            // Update a result using the service
            ResultResponseDTO updatedResult = resultService.updateResult(id, result);
            // Return the updated result as a response
            return new ResponseEntity<>(updatedResult, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Handle invalid input error
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable int id) {
        try {
            resultService.deleteResult(id);
            return ResponseEntity.ok("Result deleted");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
