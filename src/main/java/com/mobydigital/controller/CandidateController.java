package com.mobydigital.controller;

import com.mobydigital.model.entities.Candidate;
import com.mobydigital.model.views.CandidateDTO;
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

@RestController
@RequestMapping("/candidatos")
public class CandidateController {

    private Logger logger = Logger.getLogger("Logueos");

    @Autowired
    ICandidateService candidateService;

    @PostMapping()
    public ResponseEntity<?> addCandidate(@RequestBody Candidate candidate) {
        candidateService.createCandidate(candidate);
        logger.info("Registrando un candidato nuevo");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public CandidateDTO getCandidate(@PathVariable Long id) throws Exception {
        logger.debug("Consultando candidato existente");
        return candidateService.readCandidate(id);
    }

    @PutMapping()
    public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate) {
        ResponseEntity<Candidate> response = null;

        if (candidate.getId() != null){
            logger.debug("Modificando candidato existente");
            candidateService.createCandidate(candidate);
            return ResponseEntity.ok(candidate);
        }
        logger.error("Falló la petición o el candidato no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeCandidate(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        logger.debug("Eliminando candidato..");
        candidateService.deleteCandidate(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

}
