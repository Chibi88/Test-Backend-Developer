package com.mobydigital.service;

import com.mobydigital.model.entities.Candidate;
import com.mobydigital.model.entities.Experience;
import com.mobydigital.model.views.CandidateDTO;
import com.mobydigital.model.views.ExperienceDTO;

import java.util.List;

public interface ICandidateService {

    void createCandidate(Candidate candidate);
    CandidateDTO readCandidate(Long id) throws Exception;
    void updateCandidate(CandidateDTO candidateDTO);
    void deleteCandidate(Long id);
    List<ExperienceDTO> getExperienceByTechnology();

}
