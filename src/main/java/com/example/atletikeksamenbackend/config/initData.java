package com.example.atletikeksamenbackend.config;

import com.example.atletikeksamenbackend.ENUMs.Gender;
import com.example.atletikeksamenbackend.models.Club;
import com.example.atletikeksamenbackend.models.Participant;
import com.example.atletikeksamenbackend.repositories.ClubRepository;
import com.example.atletikeksamenbackend.repositories.ParticipantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class initData implements CommandLineRunner {

    private final ParticipantRepository participantRepository;
    private final ClubRepository clubRepository ;

    public initData(ParticipantRepository participantRepository, ClubRepository clubRepository) {
        this.participantRepository = participantRepository;
        this.clubRepository = clubRepository;
    }

    public void run(String... args) throws Exception {
        createClubs();
        System.out.println("Clubs are initialized");
        createParticipants();
        System.out.println("Participants are initialized");
    }

    private void createClubs() {
        List<Club> clubs = new ArrayList<>();

        // Create 10 clubs and add them to the list
        clubs.add(new Club("Københavns Atletik Forening"));
        clubs.add(new Club("Aarhus Atletik Forening"));
        clubs.add(new Club("Odense Atletik Forening"));
        clubs.add(new Club("Aalborg Atletik Forening"));
        clubs.add(new Club("Christianhavns Atletik Forening"));
        clubs.add(new Club("Roskilde Atletik Forening"));
        clubs.add(new Club("Køge Atletik Forening"));
        clubs.add(new Club("Horsens Atletik Forening"));
        clubs.add(new Club("Helsingør Atletik Forening"));
        clubs.add(new Club("Hillerød Atletik Forening"));

        // Save all clubs to the database
        clubRepository.saveAll(clubs);
    }

    private void createParticipants() {
        List<Participant> participants = new ArrayList<>();

        Club club = new Club("Sample Club");
        clubRepository.save(club);

        // Create 10 participants and add them to the list
        participants.add(new Participant("John Doe", 25, Gender.MALE, club));
        participants.add(new Participant("Jane Smith", 22, Gender.FEMALE, club));
        participants.add(new Participant("Michael Johnson", 27, Gender.TRANSfTm, club));
        participants.add(new Participant("Emily Brown", 24, Gender.FEMALE, club));
        participants.add(new Participant("David Williams", 26, Gender.MALE, club));
        participants.add(new Participant("Sarah Davis", 23, Gender.FEMALE, club));
        participants.add(new Participant("Robert Miller", 28, Gender.MALE, club));
        participants.add(new Participant("Jessica Wilson", 21, Gender.FEMALE, club));
        participants.add(new Participant("Matthew Moore", 29, Gender.BINARY, club));
        participants.add(new Participant("Olivia Taylor", 30, Gender.TRANSmTf, club));

        // Save all participants to the database
        participantRepository.saveAll(participants);
    }

}
