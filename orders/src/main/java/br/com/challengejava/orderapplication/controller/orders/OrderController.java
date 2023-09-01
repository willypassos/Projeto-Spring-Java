package br.com.challengejava.orderapplication.controller.orders;

import br.com.challengejava.orderapplication.dto.orders.OrderDTO;
import br.com.challengejava.orderapplication.dto.orders.StatusDto;
import br.com.challengejava.orderapplication.service.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/")
    public Page<OrderDTO> getAllOrders(@PageableDefault(size = 10) Pageable pagination)  {
        return service.getAllOrders(pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getById(@PathVariable @NotNull UUID id) {
        OrderDTO dto = service.getOrderById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<OrderDTO> create(@RequestBody @Valid OrderDTO dto, UriComponentsBuilder uriBuilder) {
        OrderDTO orderCreated = service.createOrder(dto);

        URI uri = uriBuilder.path("/orders/{id}").buildAndExpand(orderCreated.getId()).toUri();

        return ResponseEntity.created(uri).body(orderCreated);

    }
    @PutMapping("/{id}/status")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable UUID id, @RequestBody  StatusDto status) {
        OrderDTO update = service.updateOrder(id, status);
        return ResponseEntity.ok(update);
    }
}


