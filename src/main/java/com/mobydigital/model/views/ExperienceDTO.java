package com.mobydigital.model.views;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Getter
@Setter
@Builder
public class ExperienceDTO implements Serializable {

    private Long id;
    private TechnologyDTO technology;
    private CandidateDTO candidate;
    private Integer experienceYears;

}
