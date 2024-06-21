package com.example.atletikeksamenbackend.models;

import com.example.atletikeksamenbackend.ENUMs.AgeGroup;
import com.example.atletikeksamenbackend.ENUMs.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
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

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Result> results = new ArrayList<>();


    @Transient
    public AgeGroup getAgeGroup() {
        return AgeGroup.fromAge(this.age);
    }

    public Participant(String name, int age, Gender gender, Club club) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.club = club;
    }

    public void addResult(Result result) {
        if (results == null) {
            results = new ArrayList<>();
        }
        results.add(result);
    }

}


//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//public class Participant {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String name;
//    private int age;
//
//    @Enumerated(EnumType.STRING)
//    private Gender gender;
//
//    @ManyToOne
//    private Club club;
//
////    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////    private List<Result> results;
//
//
//    @Transient
//    public AgeGroup getAgeGroup() {
//        return AgeGroup.fromAge(this.age);
//    }
//
//    public AgeGroup setAgeGroup(int age) {
//        return AgeGroup.fromAge(this.age);
//    }
//
//    public Participant(String name, int age, Gender gender, Club club) {
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.club = club;
//    }
//}
//
