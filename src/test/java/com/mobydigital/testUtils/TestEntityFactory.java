package com.mobydigital.testUtils;

import com.mobydigital.model.entities.Candidate;
import com.mobydigital.model.entities.Experience;
import com.mobydigital.model.entities.Technology;
import com.mobydigital.model.enums.IdType;
import com.mobydigital.model.views.CandidateDTO;
import com.mobydigital.model.views.ExperienceDTO;
import com.mobydigital.model.views.TechnologyDTO;

import java.util.Date;

public class TestEntityFactory {

    public static final Long ID_CANDIDATE = 1L;
    public static final IdType ID_TYPE = IdType.DNI;
    public static final Long ID_TECHNOLOGY = 2L;
    public static final String TECH_NAME = "Java";
    public static final String TECH_VERSION = "EE";
    public static final Long ID_EXPERIENCE = 3L;

    public static Candidate getCandidate() {
        return Candidate.builder()
                .id(ID_CANDIDATE)
                .name("Silvina")
                .lastName("Colonia")
                .idType(ID_TYPE)
                .idNumber("34092530")
                .birthDate(new Date())
                .build();
    }

    public static Candidate getCandidateNoDate() {
        return Candidate.builder()
                .id(ID_CANDIDATE)
                .name("Silvina")
                .lastName("Colonia")
                .idType(ID_TYPE)
                .idNumber("34092530")
                .build();
    }

    public static CandidateDTO getCandidateDTO() {
        return CandidateDTO.builder()
                .id(ID_CANDIDATE)
                .name("Silvina")
                .lastName("Colonia")
                .idType(ID_TYPE)
                .idNumber("34092530")
                .birthDate(new Date())
                .build();
    }

}
