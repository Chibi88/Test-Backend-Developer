package com.mobydigital.model.entities;

import com.mobydigital.model.enums.IdType;
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

public class Candidate {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private IdType idType;
    private String idNumber;
    private Date birthDate;

    @OneToMany (mappedBy = "candidate")
    @ToString.Exclude
    private Experience experience;




}
