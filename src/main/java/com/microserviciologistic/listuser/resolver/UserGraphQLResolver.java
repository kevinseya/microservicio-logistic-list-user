package com.microserviciologistic.listuser.resolver;

import com.microserviciologistic.listuser.model.User;
import com.microserviciologistic.listuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class UserGraphQLResolver {

    private final UserService userService;

    @Autowired
    public UserGraphQLResolver(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping(name = "users")
    public List<User> users() {
        try {
            List<User> users = userService.getAllUsers();

            if (users.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found users");
            }

            return users;

        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error unexpected to recovering users: " + e.getMessage(), e
            );
        }
    }
}