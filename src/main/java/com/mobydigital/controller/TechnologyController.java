package com.mobydigital.controller;


import com.mobydigital.model.entities.Technology;
import com.mobydigital.model.views.TechnologyDTO;
import com.mobydigital.service.ITechnologyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping ("/technology")
public class TechnologyController {

    private Logger logger = Logger.getLogger("logs Tecnologías");

    @Autowired
    ITechnologyService technologyService;

    @PostMapping("/add")
    public ResponseEntity<?> addTechnology(@RequestBody @Valid Technology technology) {
        technologyService.createTechnology(technology);
        logger.debug("Tecnología agregada");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TechnologyDTO getTechnology(@PathVariable Long id) throws Exception {
        logger.debug("Consultando tecnología existente");
        return technologyService.readTechnology(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Technology> updateTechnology(@RequestBody @Valid Technology technology) {
        ResponseEntity<Technology> response = null;

        if (technology.getId() != null){
            logger.debug("Se editó la tecnología");
            technologyService.createTechnology(technology);
            return ResponseEntity.ok(technology);
        }
        logger.error("Falló la petición o la tecnología no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeTechnology(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        technologyService.deleteTechnology(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }


}
