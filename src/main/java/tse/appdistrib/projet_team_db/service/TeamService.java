package tse.appdistrib.projet_team_db.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import tse.appdistrib.projet_team_db.model.Team;
import tse.appdistrib.projet_team_db.repository.TeamRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    // Récupère toutes les équipes
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    // Ajoute une équipe
    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    // Supprime une équipe
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    // Met à jour une équipe
    public Team updateTeam(Long id, Team newTeam) {
        return teamRepository.findById(id).map(team -> {
            team.setName(newTeam.getName());
            team.setCity(newTeam.getCity());
            return teamRepository.save(team);
        }).orElseThrow(() -> new RuntimeException("Team not found with id " + id));
    }
}
