package com.mobydigital.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobydigital.exception.CandidateNotFoundException;
import com.mobydigital.model.entities.Candidate;
import com.mobydigital.model.views.CandidateDTO;
import com.mobydigital.model.views.ExperienceDTO;
import com.mobydigital.repository.ICandidateRepository;
import com.mobydigital.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {

    @Autowired
    ICandidateRepository candidateRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Candidate createCandidate(Candidate candidate){

       return candidateRepository.save(candidate);
    }

    @Override
    @Transactional(readOnly = true)
    public CandidateDTO readCandidate(Long id) throws CandidateNotFoundException {

        Optional<Candidate> found = candidateRepository.findById(id);
        if(found.isPresent())
            return buildCandidateDTO(found.get());
        else
            throw new CandidateNotFoundException("Candidato no encontrado");
    }

    @Override
    @Transactional
    public void updateCandidate(CandidateDTO candidateDTO) {

        if (candidateRepository.findById(candidateDTO.getId()).isPresent()){
            Candidate candidate = mapper.convertValue(candidateDTO, Candidate.class);
            candidateRepository.save(candidate);
        }
    }

    @Override
    public void deleteCandidate(Long id) {

        candidateRepository.deleteById(id);

    }

    private CandidateDTO buildCandidateDTO(Candidate candidate){
        return CandidateDTO.builder()
                .id(candidate.getId())
                .name(candidate.getName())
                .lastName(candidate.getLastName())
                .idType(candidate.getIdType())
                .idNumber(candidate.getIdNumber())
                .birthDate(candidate.getBirthDate())
                .build();
    }


}
