package com.mobydigital.service;

import com.mobydigital.model.entities.Experience;
import com.mobydigital.model.entities.Technology;
import com.mobydigital.model.views.ExperienceDTO;
import com.mobydigital.model.views.TechnologyDTO;

public interface IExperienceService {

    void createExperience(Experience experience);
    ExperienceDTO readExperience(Long id) throws Exception;
    void updateExperience(ExperienceDTO experienceDTO);
    void deleteExperience(Long id);

}
