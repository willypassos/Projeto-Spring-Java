package br.com.challengejava.orderapplication.service.users;


import br.com.challengejava.orderapplication.dto.users.UserDTO;
import br.com.challengejava.orderapplication.model.users.User;

import br.com.challengejava.orderapplication.repository.users.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers( ) {
        return userRepository.findAll().stream()
                .map(p -> modelMapper.map(p, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(user,UserDTO.class);
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO,User.class);
        userRepository.save(user);

        return modelMapper.map(user,UserDTO.class);
    }

    public UserDTO updateUser(Long id,UserDTO userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setId(id);
        user  = userRepository.save(user );

        return modelMapper.map(user,UserDTO.class);
    }

    public void deleteUser(Long Id) {
        userRepository.deleteById(Id);
    }

}