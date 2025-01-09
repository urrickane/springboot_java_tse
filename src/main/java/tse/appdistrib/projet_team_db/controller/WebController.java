package tse.appdistrib.projet_team_db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tse.appdistrib.projet_team_db.repository.TeamRepository;

@Controller
public class WebController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/teams")
    public String getTeams(Model model) {
        //model.addAttribute("teams", teamRepository.findAll());
        return "teams";
    }
}
