package ru.job4j.template.web;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.template.domain.Role;
import ru.job4j.template.domain.User;
import ru.job4j.template.repository.RoleRepository;
import ru.job4j.template.repository.UserRepository;
import ru.job4j.template.service.UserService;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserService users;

    @Autowired
    private RoleRepository roles;

    @Test
    public void whenGetUserThenReturnUserRoles() throws Exception {
       User user = this.users.save(
                new User("Petr Arsentev",
                        Collections.singletonList(
                                this.roles.save(new Role("ADMIN"))
                        )
                )
        );
        ObjectMapper mapper =  new ObjectMapper();
        assertThat(
                mapper.writeValueAsString(
                    this.users.findById(user.getId())
                ),
                is("{\"id\":0,\"name\":\"Petr Arsentev\",\"roles\":[{\"id\":0,\"name\":\"ADMIN\",\"users\":null}]}")
        );
    }
}