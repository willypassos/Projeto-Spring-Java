package br.com.challengejava.orderapplication.repository;

import br.com.challengejava.orderapplication.model.Order;
import br.com.challengejava.orderapplication.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query("update Pedido p set p.status = :status where p = :pedido")
//    void atualizaStatus(Status status, Order pedido);
//
//    @Query(value = "SELECT p from Pedido p LEFT JOIN FETCH p.itens where p.id = :id")
//    Order porIdComItens(Long id);


}
