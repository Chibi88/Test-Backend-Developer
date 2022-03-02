package com.mobydigital.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table (name = "candidatos")
@Getter
@Setter
@ToString

public class Candidato {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private TipoDeDocumento tipoDeDocumento;
    private String numeroDocumento;
    private Date fechaNacimiento;

    @OneToMany (mappedBy = "candidato")
    @ToString.Exclude
    private Experiencia experiencia;




}
