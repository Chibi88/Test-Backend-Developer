package com.mobydigital.controller;


import com.mobydigital.model.entities.Experience;
import com.mobydigital.model.views.ExperienceDTO;
import com.mobydigital.service.IExperienceService;
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


@RestController
@RequestMapping("/experience")
public class ExperienceController {

    private static final Logger logger = Logger.getLogger("Logs experiencia");

    @Autowired
    IExperienceService experienceService;

    @PostMapping("/add")
    public ResponseEntity<?> createExperience(@RequestBody Experience experience) {
        experienceService.createExperience(experience);
        logger.debug("Experiencia cargada");
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ExperienceDTO readExperience(@PathVariable Long id) throws Exception {
        logger.debug("Consultando experiencia");
        return experienceService.readExperience(id);
    }

    @PutMapping("/update")
    public ResponseEntity<ExperienceDTO> updateExperience(@RequestBody ExperienceDTO experience) {
        ResponseEntity<Experience> response = null;
        if (experience.getId() != null) {
            logger.debug("Modificando experiencia");
            experienceService.updateExperience(experience);
            return ResponseEntity.ok(experience);
        }
        logger.error("Falló la petición o experiencia no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeExperience(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        experienceService.deleteExperience(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Experiencia eliminada");
        return response;
    }







}
