package com.mobydigital.service;

import com.mobydigital.model.entities.Experience;
import com.mobydigital.model.views.ExperienceDTO;


import java.util.Set;

public interface IExperienceService {

    void createExperience(Experience experience);
    ExperienceDTO readExperience(Long id) throws Exception;
    void updateExperience(ExperienceDTO experienceDTO);
    void deleteExperience(Long id);
    Set<ExperienceDTO> getCandidatesByTechnology(String technology);

}
