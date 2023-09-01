package br.com.challengejava.orderapplication.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdressUserDto {

    private String street;
    private Integer number;
    private String city;
    private String zipcode;
}
