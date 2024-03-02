package com.example.demo.Controller;

import com.example.demo.Model.CompetencesAndHistorique;
import com.example.demo.Service.CompetencesAndHistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencesAndHistorique")
public class CompetencesAndHistoriqueController {

    @Autowired
    private CompetencesAndHistoriqueService service;

    @PostMapping("/add")
    public CompetencesAndHistorique addCompetenceAndHistorique(@RequestBody CompetencesAndHistorique competencesAndHistorique) {
        return service.saveCompetenceAndHistorique(competencesAndHistorique);
    }

    @GetMapping("/getAll")
    public List<CompetencesAndHistorique> getAllCompetencesAndHistoriques() {
        return service.getAllCompetencesAndHistoriques();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CompetencesAndHistorique> getCompetenceAndHistoriqueById(@PathVariable Long id) {
        CompetencesAndHistorique found = service.getCompetenceAndHistoriqueById(id);
        return found != null ? ResponseEntity.ok(found) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CompetencesAndHistorique> updateCompetenceAndHistorique(@PathVariable Long id, @RequestBody CompetencesAndHistorique competencesAndHistoriqueDetails) {
        CompetencesAndHistorique existingCompetencesAndHistorique = service.getCompetenceAndHistoriqueById(id);
        if (existingCompetencesAndHistorique != null) {
            // Update fields from competencesAndHistoriqueDetails to existingCompetencesAndHistorique
            existingCompetencesAndHistorique.setCompetence(competencesAndHistoriqueDetails.getCompetence());
            existingCompetencesAndHistorique.setHistoriquePerformence(competencesAndHistoriqueDetails.getHistoriquePerformence());
            existingCompetencesAndHistorique.setKdRiot(competencesAndHistoriqueDetails.getKdRiot());
            existingCompetencesAndHistorique.setWinPorsontage(competencesAndHistoriqueDetails.getWinPorsontage());
            existingCompetencesAndHistorique.setPlayerName(competencesAndHistoriqueDetails.getPlayerName());
            
            // Save the updated entity
            CompetencesAndHistorique updatedCompetencesAndHistorique = service.updateCompetenceAndHistorique(existingCompetencesAndHistorique);
            return ResponseEntity.ok(updatedCompetencesAndHistorique);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCompetenceAndHistorique(@PathVariable Long id) {
        service.deleteCompetenceAndHistoriqueById(id);
        return ResponseEntity.ok().build();
    }
}
