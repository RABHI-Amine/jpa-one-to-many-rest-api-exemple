package com.tutorial.onetomanyjpa.repository;

import com.tutorial.onetomanyjpa.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

}
