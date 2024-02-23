package com.ecua3d.corporative.repository;


import com.ecua3d.corporative.model.FilamentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFilamentRepository extends CrudRepository<FilamentEntity, Integer> {
        List<FilamentEntity> findAll();
       // Boolean existsByNameFilament(String nameFilament);
       // Optional<FilamentEntity> findByFilamentId(Integer filamentId);
}
