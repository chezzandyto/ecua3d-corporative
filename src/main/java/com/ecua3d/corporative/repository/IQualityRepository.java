package com.ecua3d.corporative.repository;

import com.ecua3d.corporative.model.MaterialEntity;
import com.ecua3d.corporative.model.QualityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IQualityRepository extends CrudRepository <QualityEntity, Integer> {
        List<QualityEntity> findAll();
        Optional<QualityEntity> findByQualityId(Integer qualityId);
}
