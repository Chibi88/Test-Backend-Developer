package com.mobydigital.model.views;

import lombok.Builder;
import lombok.Data;
import java.io.Serializable;


@Data
@Builder

public class ExperienceDTO implements Serializable {

    private Long id;
    private TechnologyDTO technology;
    private CandidateDTO candidate;
    private Integer experienceYears;

}
