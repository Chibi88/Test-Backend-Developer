package com.mobydigital.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "experiencia")
@Getter
@Setter
@ToString

public class Experience {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tecnologia_id", nullable = false)
    private Technology technology;

    @ManyToOne
    @JoinColumn(name = "candidato_id", nullable = false)
    private Candidate candidate;

    private Integer experienceYears;

}
