package com.todoproject.dao;

import com.todoproject.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User save(User entity);

    Optional<User> findById(Long id);

    void deleteById(Long id);

    boolean existsById(Long id);

}
