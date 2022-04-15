package com.tutorial.onetomanyjpa.repository;

import com.tutorial.onetomanyjpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
