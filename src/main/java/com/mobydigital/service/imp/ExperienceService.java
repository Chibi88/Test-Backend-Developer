package com.mobydigital.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobydigital.model.entities.Experience;
import com.mobydigital.model.views.ExperienceDTO;
import com.mobydigital.repository.IExperienceRepository;
import com.mobydigital.service.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ExperienceService implements IExperienceService {

    @Autowired
    IExperienceRepository experienceRepository;


    @Autowired
    ObjectMapper mapper;

    @Override
    public void createExperience(Experience experience) {
         experienceRepository.save(experience);
    }

    @Override
    public ExperienceDTO readExperience(Long id) throws Exception {
        Optional<Experience> found = experienceRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, ExperienceDTO.class);
        else
            throw new Exception("Experiencia no encontrada"); //revisar
    }

    @Override
    @Transactional
    public void updateExperience(ExperienceDTO experienceDTO) {

        if (experienceRepository.findById(experienceDTO.getId()).isPresent()){
            Experience experience = mapper.convertValue(experienceDTO, Experience.class);
            experienceRepository.save(experience);
        }
    }

    @Override
    public void deleteExperience(Long id) {

        experienceRepository.deleteById(id);
    }
}
