package com.microserviciologistic.listuser.service;

import com.microserviciologistic.listuser.model.User;
import com.microserviciologistic.listuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        try {
            List<User> users = userRepository.findAll();
            if (users.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontraron usuarios");
            }
            return users;
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error de conexión a la base de datos: " + e.getMessage(), e);
        }
    }

}
