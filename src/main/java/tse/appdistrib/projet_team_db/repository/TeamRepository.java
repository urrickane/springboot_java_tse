package tse.appdistrib.projet_team_db.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tse.appdistrib.projet_team_db.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
	
}
