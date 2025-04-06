package org.example.Repositories;


import org.example.Cat;
import org.example.CatColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
    List<Cat> findByOwnerId(int ownerId);
    List<Cat> findByColor(CatColor color);
}