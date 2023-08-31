package com.ecua3d.corporative.service;

import com.ecua3d.corporative.model.QualityEntity;
import com.ecua3d.corporative.vo.QualityResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IQualityService {
    List<QualityResponse> findAll();
    QualityResponse convertToQualityResponse(QualityEntity qualityEntity);
}
