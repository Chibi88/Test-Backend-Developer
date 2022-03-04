package com.mobydigital.service;

import com.mobydigital.exception.TechnologyNotFoundException;
import com.mobydigital.model.entities.Technology;
import com.mobydigital.model.views.TechnologyDTO;

public interface ITechnologyService {

    void createTechnology(Technology technology);
    TechnologyDTO readTechnology(Long id) throws TechnologyNotFoundException;
    void updateTechnology(TechnologyDTO technologyDTO);
    void deleteTechnology(Long id);

}
