package br.com.challengejava.orderapplication.controller.users;

import br.com.challengejava.orderapplication.dto.users.UserDTO;
import br.com.challengejava.orderapplication.service.users.UserService;
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
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserService service;

    @GetMapping("/")
    public List<UserDTO> getAllUsers()  {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable @NotNull Long id) {
        UserDTO dto = service.getUserById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<UserDTO> addUser(@RequestBody @Valid UserDTO userDto, UriComponentsBuilder uriBuilder) {
        UserDTO user = service.addUser(userDto);

        URI uri = uriBuilder.path("/orders/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable @NotNull Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDto) {
        UserDTO update = service.updateUser(id, userDto);
        return ResponseEntity.ok(update);
    }
}