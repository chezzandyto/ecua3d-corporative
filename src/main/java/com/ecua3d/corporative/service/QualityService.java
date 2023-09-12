package com.ecua3d.corporative.service;

import com.ecua3d.corporative.model.QualityEntity;
import com.ecua3d.corporative.repository.IQualityRepository;
import com.ecua3d.corporative.vo.QualityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QualityService implements IQualityService {

    @Autowired
    private IQualityRepository iQualityRepository;
    @Override
    public List<QualityResponse> findAll() {
        List<QualityEntity> qualityEntities = (List<QualityEntity>) iQualityRepository.findAll();
        return qualityEntities.stream().map(this::convertToQualityResponse).collect(Collectors.toList());
    }

    @Override
    public QualityResponse convertToQualityResponse(QualityEntity qualityEntity) {
        return QualityResponse.builder()
                .qualityId(qualityEntity.getQualityId())
                .nameQuality(qualityEntity.getNameQuality())
                .build();
    }

}
