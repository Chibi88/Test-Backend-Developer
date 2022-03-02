package com.mobydigital.backend.test.model.views;

import com.mobydigital.backend.test.model.entities.Candidato;
import com.mobydigital.backend.test.model.entities.Tecnologia;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ExperienciaDTO {

    private Long id;
    private Tecnologia tecnologia;
    private Candidato candidato;
    private Integer experience;

}
