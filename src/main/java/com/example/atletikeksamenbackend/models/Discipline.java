package com.example.atletikeksamenbackend.models;

import com.example.atletikeksamenbackend.ENUMs.ResultType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
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

//    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Result> results;

    public Discipline(String name, ResultType resultType) {
        this.name = name;
        this.resultType = resultType;
    }
}
