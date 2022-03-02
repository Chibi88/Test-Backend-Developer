package com.mobydigital.model.views;

import com.mobydigital.model.entities.Candidate;
import com.mobydigital.model.entities.Technology;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Getter
@Setter
@Builder
public class ExperienceDTO implements Serializable {

    private Long id;
    private Technology technology;
    private Candidate candidate;
    private Integer experience;
    private Integer experienceYears;

}
