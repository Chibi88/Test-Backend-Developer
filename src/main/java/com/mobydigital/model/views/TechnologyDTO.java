package com.mobydigital.model.views;

import com.mobydigital.model.entities.Experience;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@Builder
public class TechnologyDTO implements Serializable {

    private Long id;
    private String name;
    private String version;
    private Experience experience;

}
