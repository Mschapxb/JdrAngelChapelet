package com.example.fantasyrpg.repository;

import com.example.fantasyrpg.model.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Long> {

    Personnage findTopByOrderByIdDesc();
}
