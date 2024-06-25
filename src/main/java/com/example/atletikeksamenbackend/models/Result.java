package com.example.atletikeksamenbackend.models;

import com.example.atletikeksamenbackend.ENUMs.ResultType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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

//    @ManyToOne
////    @JsonBackReference
//    private Participant participant;

    @ManyToOne
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

    public String getResult() {
        if (discipline.getResultType().equals(ResultType.TIME)) {
            int TotalSeconds = (int) resultValue;
            int Hours = TotalSeconds / 3600;
            int Minutes = (TotalSeconds % 3600) / 60;
            int Seconds = TotalSeconds % 60;
            int Milliseconds = (int) ((resultValue - (int) resultValue) * 1000);
            if (Hours == 0) {
                if (Minutes == 0) {
                    return String.format("%02d:%03d", Seconds, Milliseconds);
                }
                return String.format("%02d:%02d:%03d", Minutes, Seconds, Milliseconds);
            }  else {
                return String.format("%02d:%02d:%02d:%03d", Hours, Minutes, Seconds, Milliseconds);
            }


        } else {
            return String.format("%.0f", resultValue);
        }
    }
}

