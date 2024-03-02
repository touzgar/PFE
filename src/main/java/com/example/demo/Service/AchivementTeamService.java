package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.AchivementsTeam;

public interface AchivementTeamService {
	AchivementsTeam saveAchivementsTeam(AchivementsTeam achivement);
	AchivementsTeam UpdateAchivementsTeam(AchivementsTeam achivement);
	void deleteAchivementsTeam(AchivementsTeam achivement);
	void deleteAchivementsTeamById(Long idachivement);
	AchivementsTeam getAchivementsTeam(Long idachivement);
	List<AchivementsTeam> getAllAchivementsTeams();
	
}