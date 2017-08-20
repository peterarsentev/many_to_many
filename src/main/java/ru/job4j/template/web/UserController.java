package ru.job4j.template.web;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.job4j.template.domain.User;
import ru.job4j.template.repository.UserRepository;
import ru.job4j.template.service.UserService;

import java.util.List;

/**
 * @author parsentev
 * @since 26.09.2016
 */
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService users;

    @Autowired
    public UserController(final UserService users) {
        this.users = users;
    }

    @GetMapping("/")
    public List<User> findAll() {
        return this.users.findAll();
    }
}
