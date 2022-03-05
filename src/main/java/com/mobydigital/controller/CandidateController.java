package com.mobydigital.controller;

import com.mobydigital.model.entities.Candidate;
import com.mobydigital.model.views.CandidateDTO;
import com.mobydigital.model.views.ExperienceDTO;
import com.mobydigital.service.ICandidateService;
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
import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    private final Logger logger = Logger.getLogger("Logueos");

    @Autowired
    ICandidateService candidateService;

    @PostMapping("/add")
    public ResponseEntity<Candidate> addCandidate(@RequestBody @Valid Candidate candidate){
        candidateService.createCandidate(candidate);
        logger.debug("Registrando un candidato nuevo");
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public CandidateDTO getCandidate(@PathVariable Long id) throws Exception {
        logger.info("Consultando candidato existente");
        return candidateService.readCandidate(id);
    }

    @PutMapping("/update")
    public ResponseEntity<CandidateDTO> updateCandidate(@RequestBody @Valid CandidateDTO candidateDTO) {
        ResponseEntity<CandidateDTO> response = null;

        if (candidateDTO.getId() != null){
            logger.debug("Modificando candidato existente");
            candidateService.updateCandidate(candidateDTO);
            return ResponseEntity.ok(candidateDTO);
        }
        logger.error("Falló la petición o el candidato no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeCandidate(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        logger.debug("Eliminando candidato..");
        candidateService.deleteCandidate(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    //@GetMapping(value = "/candidateExperienceList/{Technology}")
    //public ResponseEntity<List<ExperienceDTO>> candidateExperienceList(@PathVariable String technologyName){
    //    return new ResponseEntity<>(candidateService.getExperienceByTechnology(technologyName), HttpStatus.OK);
    //}


}
