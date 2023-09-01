package br.com.challengejava.orderapplication.service.orders;

import br.com.challengejava.orderapplication.dto.orders.OrderDTO;
import br.com.challengejava.orderapplication.dto.orders.OrderItemDto;
import br.com.challengejava.orderapplication.dto.orders.StatusDto;
import br.com.challengejava.orderapplication.model.orders.Order;
import br.com.challengejava.orderapplication.enums.Status;
import br.com.challengejava.orderapplication.repository.orders.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<OrderDTO> getAllOrders(Pageable pagination) {
       return orderRepository
               .findAll(pagination)
               .map(order -> modelMapper.map(order, OrderDTO.class));
    }

    public OrderDTO getOrderById(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(order,OrderDTO.class);
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO, Order.class);
        order.setStatus(Status.CREATED);
        order.getItems().forEach(item -> item.setOrder(order));
        orderRepository.save(order);

        return modelMapper.map(order,OrderDTO.class);
    }

    public OrderDTO updateOrder(UUID id, StatusDto dto) {

        Order order = orderRepository.byIdPerItems(id);

        if (order == null) {
            throw new EntityNotFoundException();
        }

        order.setStatus(dto.getStatus());
        orderRepository.updateStatus(dto.getStatus(), order);
        return modelMapper.map(order, OrderDTO.class);
    }


    // Método para calcular a quantidade total de produtos no pedido
    public int calculateTotalQuantity(OrderDTO orderDTO) {
        int totalQuantity = 0;
        for (OrderItemDto itemDTO : orderDTO.getItems()) {
            totalQuantity += itemDTO.getAmount();
        }
        return totalQuantity;
    }

    // Método para calcular o total dos itens do pedido
    public BigDecimal calculateTotalAmount(OrderDTO orderDTO) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (OrderItemDto itemDTO : orderDTO.getItems()) {
            totalAmount = totalAmount.add(itemDTO.getPartialAmount());
        }
        return totalAmount;
    }

}

