package com.example.atletikeksamenbackend.models;

import com.example.atletikeksamenbackend.ENUMs.ResultType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ResultType resultType;

    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Result> results = new HashSet<>();

    public Discipline(String name, ResultType resultType) {
        this.name = name;
        this.resultType = resultType;
    }
}

//
//@Entity
//@NoArgsConstructor
//@Getter
//@Setter
//public class Discipline {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String name;
//
//    @Enumerated(EnumType.STRING)
//    private ResultType resultType;
//
//    @ManyToMany(mappedBy = "disciplines")
//    private Set<Participant> participants = new HashSet<>();
//
//    @OneToMany
//    private Set<Result> results = new HashSet<>();
//
//    public Discipline(String name, ResultType resultType) {
//        this.name = name;
//        this.resultType = resultType;
//    }
//
//    public Discipline(int id, String name, ResultType resultType, Set<Participant> participants, Set<Result> results) {
//        this.id = id;
//        this.name = name;
//        this.resultType = resultType;
//        this.participants = participants;
//        this.results = results;
//    }
//
//
//}
