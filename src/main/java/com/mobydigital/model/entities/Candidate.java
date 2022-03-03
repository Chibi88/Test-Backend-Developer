package com.mobydigital.model.entities;

import com.mobydigital.model.enums.IdType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table (name = "candidatos")
@Getter
@Setter
@ToString

public class Candidate {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty (message = "Ingresar nombre")
    private String name;

    @NotEmpty (message = "Ingresar apellido")
    private String lastName;

    @NotNull (message = "Seleccionar Tipo de documento")
    private IdType idType;

    @NotEmpty (message = "Ingresar numero de documento")
    private String idNumber;

    @NotNull (message = "Ingresar fecha de nacimiento")
    private Date birthDate;


}
