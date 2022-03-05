package com.mobydigital.service;

import com.mobydigital.exception.CandidateNotFoundException;
import com.mobydigital.model.entities.Candidate;
import com.mobydigital.model.views.CandidateDTO;


public interface ICandidateService {

    Candidate createCandidate(Candidate candidate);
    CandidateDTO readCandidate(Long id) throws CandidateNotFoundException;
    void updateCandidate(CandidateDTO candidateDTO);
    void deleteCandidate(Long id);

}
