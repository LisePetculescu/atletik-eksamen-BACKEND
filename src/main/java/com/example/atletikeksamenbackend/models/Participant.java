package com.example.atletikeksamenbackend.models;

import com.example.atletikeksamenbackend.ENUMs.AgeGroup;
import com.example.atletikeksamenbackend.ENUMs.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private Club club;

    /* Transient field to get the age group of the participant based on the age.

       Transient fields are not persisted in the database but can be used in the
       code as if they were persisted fields in the database they're not persisted
       because they are calculated fields that can be calculated from other persisted
       fields in the database. */
    @Transient
    private AgeGroup getAgeGroup() {
        return AgeGroup.fromAge(this.age);
    }

    public Participant(String name, int age, Gender gender, Club club) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.club = club;
    }


}
