package br.com.challengejava.orderapplication.repository.users;

import br.com.challengejava.orderapplication.model.orders.Order;
import br.com.challengejava.orderapplication.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
}
