package com.mobydigital.model.views;
import com.mobydigital.model.entities.Experiencia;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TecnologiaDTO {

    private Long id;
    private String nombre;
    private String version;
    private Experiencia experiencia;

}
