package com.atnb.africathenextbrain.controller;

import com.atnb.africathenextbrain.dao.ContributionRepository;
import com.atnb.africathenextbrain.entities.Contribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/atnb")
public class antbController {

    @Autowired
    private ContributionRepository contributionRepository;
/*
    @RequestMapping(method = RequestMethod.GET, path = "/contributionsol")
    List<Contribution> findAll() {
        return  contributionRepository.findAll();
    }
*/











}
