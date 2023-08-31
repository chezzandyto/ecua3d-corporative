package com.ecua3d.corporative.repository;

import com.ecua3d.corporative.model.QualityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQualityRepository extends CrudRepository <QualityEntity, Integer> {
        List<QualityEntity> findAll();
}
