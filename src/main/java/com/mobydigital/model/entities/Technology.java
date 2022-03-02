package com.mobydigital.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tecnologia")
@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class Technology {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String version;

    @OneToMany(mappedBy = "technology") //agregar cascade
    @JsonIgnore
    @ToString.Exclude
    private Experience experience;


}
