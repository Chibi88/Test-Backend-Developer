package com.mobydigital.backend.test.model.views;

import com.mobydigital.backend.test.model.entities.TipoDeDocumento;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder

public class CandidatoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private TipoDeDocumento tipoDeDocumento;
    private String numeroDocumento;
    private Date fechaNacimiento;


}
