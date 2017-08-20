package ru.job4j.template.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.template.domain.Role;
import ru.job4j.template.domain.User;
import ru.job4j.template.repository.UserRepository;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
@Service
public class UserService {
    private final UserRepository users;

    @Autowired
    public UserService(final UserRepository users) {
        this.users = users;
    }

    @Transactional
    public List<User> findAll() {
        return Lists.newArrayList(this.users.findAll());
    }

    @Transactional
    public User save(User user) {
        return this.users.save(user);
    }

    public User findById(int id) {
        User user = this.users.findOne(id);
        return new User(user.getName(), user.getRoles().stream().map(
                r -> new Role(r.getName())
        ).collect(Collectors.toList()));
    }
}
