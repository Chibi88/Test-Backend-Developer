package com.mobydigital.repository;

import com.mobydigital.model.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExperienceRepository extends JpaRepository<Experience, Long> {

}
