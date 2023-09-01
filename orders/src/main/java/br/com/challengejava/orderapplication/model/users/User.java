package br.com.challengejava.orderapplication.model.users;

import br.com.challengejava.orderapplication.model.orders.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String email;

    @NotNull
    private String user_name;
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String phone_number;

    @JsonIgnore
    @OneToMany(mappedBy = "user_id")
    private List<Order> orders = new ArrayList<>();
}
