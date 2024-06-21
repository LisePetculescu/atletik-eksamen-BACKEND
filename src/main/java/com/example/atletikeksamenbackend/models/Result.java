package com.example.atletikeksamenbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;
    private double resultValue;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;



    public Result(LocalDate date, double resultValue, Participant participant, Discipline discipline) {
        this.date = date;
        this.resultValue = resultValue;
        this.participant = participant;
        this.discipline = discipline;
    }

    public String getResultType() {
        return discipline.getResultType().toString();
    }
}

