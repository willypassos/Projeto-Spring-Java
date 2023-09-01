package br.com.challengejava.orderapplication.repository.orders;
import br.com.challengejava.orderapplication.enums.Status;
import br.com.challengejava.orderapplication.model.orders.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Order p set p.status = :status where p = :order")
    void updateStatus(Status status, Order order);

    @Query(value = "SELECT p from Order p LEFT JOIN FETCH p.items where p.id = :id")
    Order byIdPerItems(UUID id);

}
