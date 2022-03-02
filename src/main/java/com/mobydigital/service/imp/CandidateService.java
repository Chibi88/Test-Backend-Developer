package com.mobydigital.service.imp;

import com.mobydigital.model.entities.Candidate;
import com.mobydigital.model.views.CandidateDTO;
import com.mobydigital.service.ICandidateService;
import org.springframework.stereotype.Service;

@Service
public class CandidateService implements ICandidateService {

    @Override
    public void createCandidate(Candidate candidate) {

    }

    @Override
    public CandidateDTO readCandidate(Long id) throws Exception {
        return null;
    }

    @Override
    public void updateCandidate(CandidateDTO candidateDTO) {

    }

    @Override
    public void deleteCandidate(Long id) {

    }
}
