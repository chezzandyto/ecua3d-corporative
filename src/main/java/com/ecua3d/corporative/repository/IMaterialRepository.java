package com.ecua3d.corporative.repository;

import com.ecua3d.corporative.model.ColorEntity;
import com.ecua3d.corporative.model.MaterialEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMaterialRepository extends CrudRepository<MaterialEntity, Integer> {
        List<MaterialEntity> findAll();
        Boolean existsByNameMaterial(String nameMaterial);
        Optional<MaterialEntity> findByMaterialId(Integer materialId);
}
