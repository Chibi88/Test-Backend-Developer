package com.mobydigital.model.views;


import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

@Data
@Builder

public class TechnologyDTO implements Serializable {

    private Long id;
    private String name;
    private String version;

}
