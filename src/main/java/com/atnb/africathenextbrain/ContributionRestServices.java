package com.atnb.africathenextbrain;

import com.atnb.africathenextbrain.dao.ContributionRepository;
import com.atnb.africathenextbrain.entities.Contribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class ContributionRestServices {
    @Autowired
    private ContributionRepository contributionRepository;
    String secteur;
    //liste contribution
    @GetMapping(value = "/listContributions")
    public Page<Contribution> listContribution(Pageable pageable){
        return contributionRepository.findAll(pageable);
    }

    //liste contribution by domaine
    @GetMapping(value = "/listContributionsByDomaine")
    public Page<Contribution> listContributionsByDomaine(@Param("mc") String mc, Pageable pageable){
        return contributionRepository.findByDomaineContains(mc, pageable);
    }

    //liste contribution by domaine
    @GetMapping(value = "/listContributionsByUser")
    public Page<Contribution> listContributionsByUser(@Param("mc") String mc, Pageable pageable){
        return contributionRepository.findByIdUserContains(mc, pageable);
    }

    //details contribution
    @GetMapping(value = "/listContributions/{id}")
    public Contribution listContribution(@PathVariable(name="id") Long id){

        return contributionRepository.findById(id).get();
    }

    //update
    @PutMapping(value = "/updateContributions/{id}")
    public Contribution update(@PathVariable(name="id") Long id,@RequestBody Contribution c){
        c.setId(id);
        return contributionRepository.save(c);
    }

    //enregistrer une contribution
    @PostMapping(value = "/listContributions")
    public Contribution save(@RequestBody Contribution c){
        return contributionRepository.save(c);
    }

    @DeleteMapping (value = "/deleteContribution/{id}")
    public void delete(@PathVariable(name="id") Long id){
        contributionRepository.deleteById(id);
    }

}
