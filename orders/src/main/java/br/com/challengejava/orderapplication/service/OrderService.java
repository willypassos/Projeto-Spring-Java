package br.com.challengejava.orderapplication.service;

import br.com.challengejava.orderapplication.dto.OrderDTO;
import br.com.challengejava.orderapplication.dto.StatusDto;
import br.com.challengejava.orderapplication.model.Order;
import br.com.challengejava.orderapplication.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(UUID orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        return convertToDTO(order);
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = convertToEntity(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return convertToDTO(savedOrder);
    }

    public OrderDTO updateOrderStatus(UUID Id, StatusDto id) {
        Order order = convertToEntity(orderDTO);
        order.setId(Id);
        Order updatedOrder = orderRepository.save(order);
        return convertToDTO(updatedOrder);
    }

    public void deleteOrder(UUID orderId) {
        orderRepository.deleteById(orderId);
    }

    private OrderDTO convertToDTO(Order order) {
        // Implemente a conversÃ£o de Order para OrderDTO aqui
        // Certifique-se de definir todos os campos necessÃ¡rios
        return null; // Substitua isso pelo cÃ³digo de conversÃ£o
    }

    private Order convertToEntity(OrderDTO orderDTO) {
        // Implemente a conversÃ£o de OrderDTO para Order aqui
        // Certifique-se de definir todos os campos necessÃ¡rios
        return null; // Substitua isso pelo cÃ³digo de conversÃ£o
    }
}

//@Service
//@RequiredArgsConstructor
//public class OrderService {
//
//    @Autowired
//    private OrderRepository repository;
//
//    @Autowired
//    private final ModelMapper modelMapper;
//
//
//    public List<br.com.challengejava.orderapplication.dto.OrderDto> getAllOrderDTOs() {
//        return repository.findAll().stream()
//                .map(p -> modelMapper.map(p, br.com.challengejava.orderapplication.dto.OrderDto.class))
//                .collect(Collectors.toList());
//    }
//
//    public br.com.challengejava.orderapplication.dto.OrderDto getById(Long id) {
//        Order order = repository.findById(id)
//                .orElseThrow(EntityNotFoundException::new);
//
//        return modelMapper.map(order br.com.challengejava.orderapplication.dto.OrderDto.class);
//    }
//
//    public br.com.challengejava.orderapplication.dto.OrderDto createOrder(br.com.challengejava.orderapplication.dto.OrderDto dto) {
//        Order order = modelMapper.map(dto, Order.class);
//
//
//        order.setStatus(Status.CREATED);
//        order.getItems().forEach(item -> item.setOrder(order));
//        Order salvo = repository.save(order);
//
//        return modelMapper.map(order, br.com.challengejava.orderapplication.dto.OrderDto.class);
//    }
//
//    public br.com.challengejava.orderapplication.dto.OrderDto updateStatus(Long id, StatusDto dto) {
//
//        Order order = repository.porIdComItens(id);
//
//        if (order == null) {
//            throw new EntityNotFoundException();
//        }
//
//        order.setStatus(dto.getStatus());
//        repository.atualizaStatus(dto.getStatus(), order);
//        return modelMapper.map(order, br.com.challengejava.orderapplication.dto.OrderDto.class);
//    }
//}
