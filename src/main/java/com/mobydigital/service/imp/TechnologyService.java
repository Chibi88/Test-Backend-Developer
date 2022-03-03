package com.mobydigital.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobydigital.exception.TechnologyNotFoundException;
import com.mobydigital.model.entities.Technology;
import com.mobydigital.model.views.TechnologyDTO;
import com.mobydigital.repository.ITechnologyRepository;
import com.mobydigital.service.ITechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TechnologyService implements ITechnologyService {

    @Autowired
    ITechnologyRepository technologyRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void createTechnology(Technology technology) {

        technologyRepository.save(technology);
    }

    @Override
    @Transactional(readOnly = true)
    public TechnologyDTO readTechnology(Long id) throws TechnologyNotFoundException {
        Optional<Technology> found = technologyRepository.findById(id);
        if(found.isPresent()) {
            return mapper.convertValue(found, TechnologyDTO.class);
        }else {
            throw new TechnologyNotFoundException("Tecnología no encontrada no encontrado");
        }
    }

    @Override
    @Transactional
    public void updateTechnology(TechnologyDTO technologyDTO) {

        if(technologyRepository.findById(technologyDTO.getId()).isPresent()){
            Technology technology = mapper.convertValue(technologyDTO, Technology.class);
            technologyRepository.save(technology);
        }
    }

    @Override
    public void deleteTechnology(Long id) {
        technologyRepository.deleteById(id);
    }


}
