package com.todoproject.dao;

import com.todoproject.model.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    Item save(Item entity);

    Optional<Item> findById(Long id);

    void deleteById(Long id);

}
