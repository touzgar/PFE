package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.AchivementsTeam;
import com.example.demo.Service.AchivementTeamService;
@RestController
@RequestMapping("/api/achivementTeam")
@CrossOrigin("*")

public class AchivementTeamController {
	@Autowired
	private AchivementTeamService achievementTeamService;
	
	@GetMapping("/getAll")
	List<AchivementsTeam> getAllAchievementTeams(){
		return achievementTeamService.getAllAchivementsTeams();
	}
	
	 @GetMapping("/get/{id}")
	public AchivementsTeam getAchivementsTeamById(@PathVariable("id") Long id) {
		return achievementTeamService.getAchivementsTeam(id);
	}
	 @PostMapping("/add")
	public AchivementsTeam createAchivementsTeam(@RequestBody AchivementsTeam achivementTeam) {
		return achievementTeamService.saveAchivementsTeam(achivementTeam);
	}
	 @PutMapping("/update/{id}")
	public AchivementsTeam updateAchivementsTeam(@RequestBody AchivementsTeam achivementTeam) {
	    return achievementTeamService.UpdateAchivementsTeam(achivementTeam);
	}
	  @DeleteMapping("/delete/{id}")
	public void deleteAchivementsTeam(@PathVariable("id") Long id) {
		achievementTeamService.deleteAchivementsTeamById(id);
	}

}