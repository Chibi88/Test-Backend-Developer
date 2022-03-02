package com.mobydigital.model.views;

import com.mobydigital.model.entities.Experience;
import com.mobydigital.model.enums.IdType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
public class CandidateDTO implements Serializable {

    private Long id;
    private String name;
    private String lastName;
    private IdType idType;
    private String idNumber;
    private Date birthDate;
    private Experience experience;

}
