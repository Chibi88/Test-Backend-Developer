package com.mobydigital.repository;

import com.mobydigital.model.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechnologyRepository extends JpaRepository<Technology, Long> {

}
