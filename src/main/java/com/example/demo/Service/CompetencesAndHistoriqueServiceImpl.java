package com.example.demo.Service;

import com.example.demo.Model.CompetencesAndHistorique;
import com.example.demo.Repository.CompetencesAndHistoriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompetencesAndHistoriqueServiceImpl implements CompetencesAndHistoriqueService {

    @Autowired
    private CompetencesAndHistoriqueRepository repository;

    @Override
    public CompetencesAndHistorique saveCompetenceAndHistorique(CompetencesAndHistorique competencesAndHistorique) {
        return repository.save(competencesAndHistorique);
    }

    @Override
    public CompetencesAndHistorique updateCompetenceAndHistorique(CompetencesAndHistorique competencesAndHistorique) {
        return repository.save(competencesAndHistorique);
    }

    @Override
    public void deleteCompetenceAndHistoriqueById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CompetencesAndHistorique getCompetenceAndHistoriqueById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<CompetencesAndHistorique> getAllCompetencesAndHistoriques() {
        return repository.findAll();
    }
}
