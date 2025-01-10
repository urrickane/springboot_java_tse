package tse.appdistrib.projet_team_db.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import tse.appdistrib.projet_team_db.model.Team;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    private Team team;

    @BeforeEach
    void setUp() {
        // Prépare une équipe pour les tests
        team = new Team();
        team.setName("Test Team");
        team.setCity("Test City");
    }

    @Test
    void testAddTeam() {
        // Sauvegarde une équipe
        Team savedTeam = teamRepository.save(team);

        // Vérifie si l'équipe a un ID généré
        assertNotNull(savedTeam.getId());
        assertEquals("Test Team", savedTeam.getName());
        assertEquals("Test City", savedTeam.getCity());
    }

    @Test
    void testUpdateTeam() {
        // Sauvegarde une équipe
        Team savedTeam = teamRepository.save(team);

        // Modifie les détails de l'équipe
        savedTeam.setName("Updated Team");
        savedTeam.setCity("Updated City");
        Team updatedTeam = teamRepository.save(savedTeam);

        // Vérifie si les modifications sont prises en compte
        assertEquals("Updated Team", updatedTeam.getName());
        assertEquals("Updated City", updatedTeam.getCity());
    }

    @Test
    void testDeleteTeam() {
        // Sauvegarde une équipe
        Team savedTeam = teamRepository.save(team);

        // Supprime l'équipe
        teamRepository.deleteById(savedTeam.getId());

        // Vérifie si l'équipe n'existe plus
        Optional<Team> deletedTeam = teamRepository.findById(savedTeam.getId());
        assertFalse(deletedTeam.isPresent());
    }

    @Test
    void testFindTeamById() {
        // Sauvegarde une équipe
        Team savedTeam = teamRepository.save(team);

        // Récupère l'équipe par son ID
        Optional<Team> foundTeam = teamRepository.findById(savedTeam.getId());

        // Vérifie si l'équipe est correctement récupérée
        assertTrue(foundTeam.isPresent());
        assertEquals("Test Team", foundTeam.get().getName());
        assertEquals("Test City", foundTeam.get().getCity());
    }
}
