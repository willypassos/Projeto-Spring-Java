package br.com.challengejava.orderapplication.model.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "adress_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdressUser {

    @NotNull
    private String street;

    @NotNull
    private Integer number;

    @NotNull
    private String city;

    @NotNull
    private String zipcode;

}
