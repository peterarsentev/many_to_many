package ru.job4j.template.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.template.domain.Role;
import ru.job4j.template.domain.User;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
@Transactional
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
