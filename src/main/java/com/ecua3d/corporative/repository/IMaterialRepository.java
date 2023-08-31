package com.ecua3d.corporative.repository;

import com.ecua3d.corporative.model.MaterialEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMaterialRepository extends CrudRepository <MaterialEntity, Integer> {
        List<MaterialEntity> findAll();
        Boolean existsByNameMaterial(String nameMaterial);
}
