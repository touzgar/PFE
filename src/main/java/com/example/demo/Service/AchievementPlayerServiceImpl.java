package com.example.demo.Service;

import com.example.demo.Model.AchievementPlayer;
import com.example.demo.Repository.AchievementPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AchievementPlayerServiceImpl implements AchievementPlayerService {

    @Autowired
    private AchievementPlayerRepository repository;

    @Override
    public AchievementPlayer saveAchievementPlayer(AchievementPlayer achievementPlayer) {
        return repository.save(achievementPlayer);
    }

    @Override
    public AchievementPlayer updateAchievementPlayer(AchievementPlayer achievementPlayer) {
        return repository.save(achievementPlayer);
    }

    @Override
    public void deleteAchievementPlayerById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public AchievementPlayer getAchievementPlayerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<AchievementPlayer> getAllAchievementPlayers() {
        return repository.findAll();
    }
}
