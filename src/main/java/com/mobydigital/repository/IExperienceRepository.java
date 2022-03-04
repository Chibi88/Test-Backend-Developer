package com.mobydigital.repository;

import com.mobydigital.model.entities.Candidate;
import com.mobydigital.model.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface IExperienceRepository extends JpaRepository<Experience, Long> {

    @Query(value = "SELECT  tecnologia.NAME, candidatos.NAME, candidatos.LAST_NAME, experiencia.EXPERIENCE_YEARS,"
            + " FROM ((experiencia "
            + " INNER JOIN candidatos ON experiencia.CANDIDATO_ID = candidatos.ID)"
            + " INNER JOIN tecnologia ON experiencia.TECNOLOGIA_ID = tecnologia.ID)"
            + " WHERE tecnologia.name like '%:technology%'", nativeQuery = true)

      Set<Experience> getCandidatesByTechnology(@Param("technology") String technology);




}
