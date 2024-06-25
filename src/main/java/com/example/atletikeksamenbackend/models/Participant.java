package com.example.atletikeksamenbackend.models;

import com.example.atletikeksamenbackend.ENUMs.AgeGroup;
import com.example.atletikeksamenbackend.ENUMs.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter
@Setter
@NoArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private Club club;

    @JsonManagedReference
    @OneToMany(mappedBy = "participant")
    private List<Result> results;

//    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY)
////    @JsonManagedReference
//    private List<Result> results = new ArrayList<>();

    @ManyToMany()
    private Set<Discipline> disciplines = new HashSet<>();


    @Transient
    public AgeGroup getAgeGroup() {
        return AgeGroup.fromAge(this.age);
    }

    public Participant(String name, int age, Gender gender, Club club, Set<Discipline> disciplines) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.club = club;
        this.disciplines = disciplines;
    }

    public void addResult(Result result) {
        if (results == null) {
            results = new ArrayList<>();
        }
        results.add(result);
    }

}
