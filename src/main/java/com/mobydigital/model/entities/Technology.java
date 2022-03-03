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
import javax.validation.constraints.NotEmpty;
import java.util.Set;


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

    @NotEmpty(message = "Ingresar tecnología")
    private String name;
    private String version;


}
