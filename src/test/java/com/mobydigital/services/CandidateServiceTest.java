package com.mobydigital.services;


import com.mobydigital.exception.CandidateNotFoundException;
import com.mobydigital.model.views.CandidateDTO;
import com.mobydigital.repository.ICandidateRepository;
import com.mobydigital.service.imp.CandidateService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import java.util.Optional;
import static com.mobydigital.testUtils.TestEntityFactory.getCandidate;
import static com.mobydigital.testUtils.TestEntityFactory.getCandidateDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CandidateServiceTest.class)
class CandidateServiceTest {

    @InjectMocks
    CandidateService candidateService;

    @Mock
    ICandidateRepository candidateRepository;


    @Test
    @WithMockUser
    void readCandidateTest() throws CandidateNotFoundException {


       when(candidateRepository.findById(getCandidateDTO().getId())).thenReturn(Optional.of(getCandidate()));

       CandidateDTO candidate = candidateService.readCandidate(getCandidateDTO().getId());

        assertEquals(getCandidateDTO().toString(), candidate.toString());

    }

    //createCandidate
    //readCandidate
    //updateCandidate
    //deleteCandidate



}
