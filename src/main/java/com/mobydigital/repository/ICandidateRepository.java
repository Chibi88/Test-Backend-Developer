package com.mobydigital.repository;

import com.mobydigital.model.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICandidateRepository extends JpaRepository<Candidate, Long> {

}
