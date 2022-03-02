package com.mobydigital.service;

import com.mobydigital.model.entities.Candidate;
import com.mobydigital.model.views.CandidateDTO;

public interface ICandidateService {

    void createCandidate(Candidate candidate);
    CandidateDTO readCandidate(Long id) throws Exception;
    void updateCandidate(CandidateDTO candidateDTO);
    void deleteCandidate(Long id);

}
