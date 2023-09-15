package com.ecua3d.corporative.repository;

import com.ecua3d.corporative.model.ColorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IColorRepository extends CrudRepository<ColorEntity, Integer> {
        List<ColorEntity> findAll();
        Boolean existsByNameColor(String nameColor);
        Optional<ColorEntity> findByColorId(Integer colorId);
}
