package com.mobydigital.model.views;


import com.mobydigital.model.enums.IdType;
import lombok.Builder;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;

@Data
@Builder

public class CandidateDTO implements Serializable {

    private Long id;
    private String name;
    private String lastName;
    private IdType idType;
    private String idNumber;
    private Date birthDate;

}
