package com.mobydigital.repository;
import com.mobydigital.model.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface IExperienceRepository extends JpaRepository<Experience, Long> {

    @Query(value = "SELECT  e.id, e.candidato_id, e.tecnologia_id, e.experience_years"
            + " FROM experiencia e "
            + " INNER JOIN tecnologia t ON e.tecnologia_id = t.id"
            + " WHERE t.name like ?1", nativeQuery = true)

      Set<Experience> getCandidatesByTechnology(@Param("technology") String technology);


}