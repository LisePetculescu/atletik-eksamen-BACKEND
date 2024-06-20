package com.example.atletikeksamenbackend.config;

import com.example.atletikeksamenbackend.ENUMs.Gender;
import com.example.atletikeksamenbackend.ENUMs.ResultType;
import com.example.atletikeksamenbackend.models.Club;
import com.example.atletikeksamenbackend.models.Discipline;
import com.example.atletikeksamenbackend.models.Participant;
import com.example.atletikeksamenbackend.models.Result;
import com.example.atletikeksamenbackend.repositories.ClubRepository;
import com.example.atletikeksamenbackend.repositories.DisciplineRepository;
import com.example.atletikeksamenbackend.repositories.ParticipantRepository;
import com.example.atletikeksamenbackend.repositories.ResultRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class initData implements CommandLineRunner {

    private final ParticipantRepository participantRepository;
    private final ClubRepository clubRepository;
    private final DisciplineRepository disciplineRepository;
    private final ResultRepository resultRepository;

    public initData(ParticipantRepository participantRepository, ClubRepository clubRepository, DisciplineRepository disciplineRepository, ResultRepository resultRepository) {
        this.participantRepository = participantRepository;
        this.clubRepository = clubRepository;
        this.disciplineRepository = disciplineRepository;
        this.resultRepository = resultRepository;
    }

    public void run(String... args) throws Exception {
        createClubs();
        System.out.println("Clubs are initialized");

        createDisciplines();
        System.out.println("Disciplines are initialized");

        createParticipants();
        System.out.println("Participants are initialized");


        createResults();
        System.out.println("Results are initialized");
    }

    private void createClubs() {
        List<Club> clubs = new ArrayList<>();

        // Create clubs and add them to the list
//        Club club1 = new Club("Københavns Atletik Forening");
//        Club club2 = new Club("Aarhus Atletik Forening");
//        Club club3 = new Club("Odense Atletik Forening");
//        Club club4 = new Club("Aalborg Atletik Forening");
//        Club club5 = new Club("Christianhavns Atletik Forening");
//        Club club6 = new Club("Roskilde Atletik Forening");
//        Club club7 = new Club("Køge Atletik Forening");
//        Club club8 = new Club("Horsens Atletik Forening");
//        Club club9 = new Club("Helsingør Atletik Forening");
//        Club club10 = new Club("Hillerød Atletik Forening");

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


        // Create participants and add them to the list
        Club københavn = clubRepository.findByName("Københavns Atletik Forening").orElseThrow();
        Club aarhus = clubRepository.findByName("Aarhus Atletik Forening").orElseThrow();
        Club odense = clubRepository.findByName("Odense Atletik Forening").orElseThrow();
        Club aalborg = clubRepository.findByName("Aalborg Atletik Forening").orElseThrow();
        Club christianhavn = clubRepository.findByName("Christianhavns Atletik Forening").orElseThrow();
        Club roskilde = clubRepository.findByName("Roskilde Atletik Forening").orElseThrow();
        Club køge = clubRepository.findByName("Køge Atletik Forening").orElseThrow();
        Club horsens = clubRepository.findByName("Horsens Atletik Forening").orElseThrow();
        Club helsingør = clubRepository.findByName("Helsingør Atletik Forening").orElseThrow();
        Club hillerød = clubRepository.findByName("Hillerød Atletik Forening").orElseThrow();

        participants.add(new Participant("John Doe", 40, Gender.MALE, københavn));
        participants.add(new Participant("Jane Smith", 22, Gender.FEMALE, aarhus));
        participants.add(new Participant("Michael Johnson", 66, Gender.TRANSfTm, odense));
        participants.add(new Participant("Emily Brown", 7, Gender.BINARY, aalborg));
        participants.add(new Participant("David Williams", 26, Gender.MALE, christianhavn));
        participants.add(new Participant("Sarah Davis", 36, Gender.TRANSmTf, roskilde));
        participants.add(new Participant("Robert Miller", 10, Gender.BINARY, køge));
        participants.add(new Participant("Jessica Wilson", 16, Gender.FEMALE, horsens));
        participants.add(new Participant("Matthew Moore", 29, Gender.MALE, helsingør));
        participants.add(new Participant("Olivia Taylor", 30, Gender.TRANSmTf, hillerød));


//        participants.add(new Participant("John Doe", 25, Gender.MALE, sampleClub));
//        participants.add(new Participant("Jane Smith", 22, Gender.FEMALE, sampleClub));
//        participants.add(new Participant("Michael Johnson", 27, Gender.TRANSfTm, sampleClub));
//        participants.add(new Participant("Emily Brown", 24, Gender.FEMALE, sampleClub));
//        participants.add(new Participant("David Williams", 26, Gender.MALE, sampleClub));
//        participants.add(new Participant("Sarah Davis", 23, Gender.FEMALE, sampleClub));
//        participants.add(new Participant("Robert Miller", 28, Gender.MALE, sampleClub));
//        participants.add(new Participant("Jessica Wilson", 21, Gender.FEMALE, sampleClub));
//        participants.add(new Participant("Matthew Moore", 29, Gender.BINARY, sampleClub));
//        participants.add(new Participant("Olivia Taylor", 30, Gender.TRANSmTf, sampleClub);


        // Save all participants to the database
        participantRepository.saveAll(participants);
    }

    private void createDisciplines() {
        List<Discipline> disciplines = new ArrayList<>();

        disciplines.add(new Discipline("100m Sprint", ResultType.TIME));
        disciplines.add(new Discipline("200m Sprint", ResultType.TIME));
        disciplines.add(new Discipline("400m Sprint", ResultType.TIME));
        disciplines.add(new Discipline("800m Sprint", ResultType.TIME));
        disciplines.add(new Discipline("1500m Sprint", ResultType.TIME));
        disciplines.add(new Discipline("Marathon", ResultType.TIME));
        disciplines.add(new Discipline("Hækkeløb", ResultType.TIME));
        disciplines.add(new Discipline("Højdespring", ResultType.HEIGHT));
        disciplines.add(new Discipline("Stangspring", ResultType.HEIGHT));
        disciplines.add(new Discipline("Længdespring", ResultType.DISTANCE));
        disciplines.add(new Discipline("Trespring", ResultType.DISTANCE));
        disciplines.add(new Discipline("Kuglestød", ResultType.DISTANCE));
        disciplines.add(new Discipline("Diskoskast", ResultType.DISTANCE));
        disciplines.add(new Discipline("Spydkast", ResultType.DISTANCE));
        disciplines.add(new Discipline("Hammerkast", ResultType.DISTANCE));
        disciplines.add(new Discipline("Tikamp", ResultType.POINTS));
        disciplines.add(new Discipline("Syvkamp", ResultType.POINTS));

        // Save all disciplines to the database
        disciplineRepository.saveAll(disciplines);
    }

    private void createResults() {
        List<Result> results = new ArrayList<>();

        Participant johnDoe = participantRepository.findByName("John Doe").orElseThrow();
        Participant janeSmith = participantRepository.findByName("Jane Smith").orElseThrow();
        Participant michaelJohnson = participantRepository.findByName("Michael Johnson").orElseThrow();
        Participant emilyBrown = participantRepository.findByName("Emily Brown").orElseThrow();
        Participant davidWilliams = participantRepository.findByName("David Williams").orElseThrow();
        Participant sarahDavis = participantRepository.findByName("Sarah Davis").orElseThrow();
        Participant robertMiller = participantRepository.findByName("Robert Miller").orElseThrow();
        Participant jessicaWilson = participantRepository.findByName("Jessica Wilson").orElseThrow();
        Participant matthewMoore = participantRepository.findByName("Matthew Moore").orElseThrow();
        Participant oliviaTaylor = participantRepository.findByName("Olivia Taylor").orElseThrow();



        Discipline sprint100m = disciplineRepository.findByName("100m Sprint").orElseThrow();
        Discipline longJump = disciplineRepository.findByName("Længdespring").orElseThrow();
        Discipline highJump = disciplineRepository.findByName("Højdespring").orElseThrow();
        Discipline marathon = disciplineRepository.findByName("Marathon").orElseThrow();
        Discipline sprint200m = disciplineRepository.findByName("200m Sprint").orElseThrow();
        Discipline sprint400m = disciplineRepository.findByName("400m Sprint").orElseThrow();
        Discipline sprint800m = disciplineRepository.findByName("800m Sprint").orElseThrow();
        Discipline sprint1500m = disciplineRepository.findByName("1500m Sprint").orElseThrow();
        Discipline hurdles = disciplineRepository.findByName("Hækkeløb").orElseThrow();
        Discipline poleVault = disciplineRepository.findByName("Stangspring").orElseThrow();
        Discipline tripleJump = disciplineRepository.findByName("Trespring").orElseThrow();
        Discipline shotPut = disciplineRepository.findByName("Kuglestød").orElseThrow();
        Discipline discusThrow = disciplineRepository.findByName("Diskoskast").orElseThrow();
        Discipline javelinThrow = disciplineRepository.findByName("Spydkast").orElseThrow();
        Discipline hammerThrow = disciplineRepository.findByName("Hammerkast").orElseThrow();
        Discipline decathlon = disciplineRepository.findByName("Tikamp").orElseThrow();
        Discipline heptathlon = disciplineRepository.findByName("Syvkamp").orElseThrow();


        // Create results and add them to the list
        results.add(new Result(LocalDate.now(), 10.5, johnDoe, sprint100m)); // John Doe løber 100m sprint på 10.5 sekunder
        results.add(new Result(LocalDate.now(), 12.3, janeSmith, sprint100m)); // Jane Smith løber 100m sprint på 12.3 sekunder
        results.add(new Result(LocalDate.now(), 7.5, michaelJohnson, longJump)); // Michael Johnson springer 7.5 meter i længdespring
        results.add(new Result(LocalDate.now(), 1.9, emilyBrown, highJump)); // Emily Brown hopper 1.9 meter i højdespring
        results.add(new Result(LocalDate.now(), 7500, johnDoe, marathon)); // John Doe løber marathon på 7500 sekunder (2 timer, 5 minutter og 0 sekunder)
        results.add(new Result(LocalDate.now(), 7800, janeSmith, marathon)); // Jane Smith løber marathon på 7800 sekunder (2 timer, 10 minutter og 0 sekunder)
        results.add(new Result(LocalDate.now(), 7200, michaelJohnson, marathon)); // Michael Johnson løber marathon på 7200 sekunder (2 timer, 0 minutter og 0 sekunder)
        results.add(new Result(LocalDate.now(), 8100, emilyBrown, marathon)); // Emily Brown løber marathon på 8100 sekunder (2 timer, 15 minutter og 0 sekunder)
        results.add(new Result(LocalDate.now(), 7.2, johnDoe, longJump)); // John Doe springer 7.2 meter i længdespring
        results.add(new Result(LocalDate.now(), 1.8, janeSmith, highJump)); // Jane Smith hopper 1.8 meter i højdespring
        results.add(new Result(LocalDate.now(), 7.0, michaelJohnson, longJump)); // Michael Johnson springer 7.0 meter i længdespring
        results.add(new Result(LocalDate.now(), 1.7, emilyBrown, highJump)); // Emily Brown hopper 1.7 meter i højdespring
        results.add(new Result(LocalDate.now(), 10.0, johnDoe, sprint200m)); // John Doe løber 200m sprint på 10.0 sekunder
        results.add(new Result(LocalDate.now(), 11.5, janeSmith, sprint200m)); // Jane Smith løber 200m sprint på 11.5 sekunder
        results.add(new Result(LocalDate.now(), 20.0, johnDoe, sprint400m)); // John Doe løber 400m sprint på 20.0 sekunder
        results.add(new Result(LocalDate.now(), 23.5, janeSmith, sprint400m)); // Jane Smith løber 400m sprint på 23.5 sekunder
        results.add(new Result(LocalDate.now(), 40.0, davidWilliams, sprint800m)); // david williams løber 800m sprint på 40.0 sekunder
        results.add(new Result(LocalDate.now(), 47.5, sarahDavis, sprint800m)); // sarah davis løber 800m sprint på 47.5 sekunder
        results.add(new Result(LocalDate.now(), 75.0, robertMiller, sprint1500m)); // robert miller løber 1500m sprint på 75.0 sekunder
        results.add(new Result(LocalDate.now(), 87.5, jessicaWilson, sprint1500m)); // jessica wilson løber 1500m sprint på 87.5 sekunder
        results.add(new Result(LocalDate.now(), 15.0, matthewMoore, hurdles)); // matthew moore løber hækkeløb på 15.0 sekunder
        results.add(new Result(LocalDate.now(), 17.5, oliviaTaylor, hurdles)); // olivia taylor løber hækkeløb på 17.5 sekunder
        results.add(new Result(LocalDate.now(), 2.0, robertMiller, poleVault)); // robert miller springer 2.0 meter i stangspring
        results.add(new Result(LocalDate.now(), 2.5, jessicaWilson, poleVault)); // jessica wilson springer 2.5 meter i stangspring
        results.add(new Result(LocalDate.now(), 10.0, matthewMoore, tripleJump)); // matthew moore springer 10.0 meter i trespring
        results.add(new Result(LocalDate.now(), 12.5, oliviaTaylor, tripleJump)); // olivia taylor springer 12.5 meter i trespring
        results.add(new Result(LocalDate.now(), 10.0, robertMiller, shotPut)); // robert miller kaster kuglen 10.0 meter i kuglestød
        results.add(new Result(LocalDate.now(), 12.5, jessicaWilson, shotPut)); // jessica wilson kaster kuglen 12.5 meter i kuglestød
        results.add(new Result(LocalDate.now(), 10.0, matthewMoore, discusThrow)); // matthew moore kaster diskos 10.0 meter i diskoskast
        results.add(new Result(LocalDate.now(), 12.5, oliviaTaylor, discusThrow)); // olivia taylor kaster diskos 12.5 meter i diskoskast
        results.add(new Result(LocalDate.now(), 10.0, robertMiller, javelinThrow)); // robert miller kaster spyddet 10.0 meter i spydkast
        results.add(new Result(LocalDate.now(), 12.5, jessicaWilson, javelinThrow)); // jessica wilson kaster spyddet 12.5 meter i spydkast
        results.add(new Result(LocalDate.now(), 10.0, matthewMoore, hammerThrow)); // matthew moore kaster hammeren 10.0 meter i hammerkast
        results.add(new Result(LocalDate.now(), 12.5, oliviaTaylor, hammerThrow)); // olivia taylor kaster hammeren 12.5 meter i hammerkast
        results.add(new Result(LocalDate.now(), 5000, robertMiller, decathlon)); // robert miller får 5000 point i tikamp
        results.add(new Result(LocalDate.now(), 6000, jessicaWilson, decathlon)); // jessica wilson får 6000 point i tikamp
        results.add(new Result(LocalDate.now(), 5000, matthewMoore, heptathlon)); // matthew moore får 5000 point i syvkamp
        results.add(new Result(LocalDate.now(), 6000, oliviaTaylor, heptathlon)); // olivia taylor får 6000 point i syvkamp


        // Save all results to the database
        resultRepository.saveAll(results);
    }

}
