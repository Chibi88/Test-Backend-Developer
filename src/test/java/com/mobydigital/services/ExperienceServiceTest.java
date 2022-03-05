package com.mobydigital.services;

import com.mobydigital.model.entities.Candidate;
import com.mobydigital.model.entities.Experience;
import com.mobydigital.model.entities.Technology;
import com.mobydigital.model.enums.IdType;
import com.mobydigital.model.views.ExperienceDTO;
import com.mobydigital.service.ICandidateService;
import com.mobydigital.service.IExperienceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ExperienceServiceTest {

    @Autowired
    IExperienceService experienceService;
    @Autowired
    ICandidateService candidateService;

    @Test
    public void testGetExperienceByTechnologyLike(){

        Experience experience = new Experience();
        //experience.setTechnology(new Technology(1L, "Java", "EE"));
        //experience.setCandidate(new Candidate(1L, "Chibi", "Colonia", IdType.DNI, "123", new Date()));

        experience.setExperienceYears(3);

        experienceService.createExperience(experience);
        Set<ExperienceDTO> experienceDTOS = experienceService.getCandidatesByTechnology("Java");

        boolean resultado = experienceDTOS.size() > 0;

        assertTrue(resultado);

        }



}
