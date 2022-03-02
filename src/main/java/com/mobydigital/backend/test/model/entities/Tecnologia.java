package com.mobydigital.backend.test.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tecnologia")
@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class Tecnologia {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String version;

    @OneToMany(mappedBy = "tecnologia") //agregar cascade
    @JsonIgnore
    @ToString.Exclude
    private Experiencia experiencia;


}
