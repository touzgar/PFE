package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Team;

import com.example.demo.Service.TeamService;

@RestController
@RequestMapping("/api/team")
@CrossOrigin("*")

public class TeamController {
	@Autowired
	TeamService teamService;
	
	 @GetMapping("/getAll")
	List<Team> getAllTeams(){
		return teamService.getAllTeams();
	}
	 @GetMapping("/get/{id}")
	public Team getTeamById(@PathVariable("id") Long id) {
		return teamService.getTeam(id);
	}
	  @PostMapping("/add")
	    public Team createTeam(@RequestBody Map<String, Object> payload) {
	        String teamName = (String) payload.get("teamName");
	        String description = (String) payload.get("description");
	        String clubName = (String) payload.get("clubName");
	        String coachName = (String) payload.get("coachName"); // Extract coachName from the payload

	        Team team = new Team();
	        team.setTeamName(teamName);
	        team.setDescription(description);
	        // Set other fields as necessary

	        // First, save the team with its club name to set the relationship with the club
	        team = teamService.saveTeamWithClubName(team, clubName);

	        // Then, update the team with the coach name to set the relationship with the coach
	        // This assumes saveTeamWithCoachName does both: saving the team if not already saved, and setting the coach
	        return teamService.saveTeamWithCoachName(team, coachName);
	    }	
	 @PutMapping("/update/{id}")
	public Team updateClub(@RequestBody Team team) {
	    return teamService.UpdateTeam(team);
	}
	 @DeleteMapping("/delete/{id}")
	public void deleteclub(@PathVariable("id") Long id) {
		teamService.deleteTeamById(id);
	}
	 @RequestMapping(value = "/search", method = RequestMethod.GET)
	    public List<Team> searchTeams(@RequestParam("name") String teamName) {
	        return teamService.searchByTeamName(teamName);
	    }
	 @GetMapping("/tournaments/{teamName}")
	    public List<String> getTournamentsByTeamName(@PathVariable String teamName) {
	        return teamService.findParticipatingTournamentsByTeamName(teamName);
	    }
}
