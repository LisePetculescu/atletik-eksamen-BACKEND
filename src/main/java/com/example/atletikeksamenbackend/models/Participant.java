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

//    @JsonManagedReference
//    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Result> results = new ArrayList<>();

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
//    @ManyToMany
//    @JoinTable(
//            name = "participant_discipline",
//            joinColumns = @JoinColumn(name = "participant_id"),
//            inverseJoinColumns = @JoinColumn(name = "discipline_id")
//    )
//    private Set<Discipline> disciplines = new HashSet<>();
//
//    @OneToMany(mappedBy = "participant")
//    private List<Result> results = new ArrayList<>();
//
//
//    /* Transient field to get the age group of the participant based on the age.
//
//       Transient fields are not persisted in the database but can be used in the
//       code as if they were persisted fields in the database they're not persisted
//       because they are calculated fields that can be calculated from other persisted
//       fields in the database. */
//    @Transient
//    public AgeGroup getAgeGroup() {
//        return AgeGroup.fromAge(this.age);
//    }
//
//    public Participant(String name, int age, Gender gender, Club club) {
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.club = club;
//    }
//
//}
