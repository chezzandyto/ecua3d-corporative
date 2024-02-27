package com.ecua3d.corporative.service;

import com.ecua3d.corporative.exception.EntityNoExistsException;
import com.ecua3d.corporative.model.ColorEntity;
import com.ecua3d.corporative.model.QualityEntity;
import com.ecua3d.corporative.vo.MaterialResponse;
import com.ecua3d.corporative.vo.MaterialUpdateDTO;
import com.ecua3d.corporative.vo.QualityResponse;
import com.ecua3d.corporative.vo.QualityUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IQualityService {
    List<QualityResponse> findAll();
    QualityResponse convertToQualityResponse(QualityEntity qualityEntity);
    QualityEntity findByQualityId(Integer qualityId) throws EntityNoExistsException;
    QualityResponse updateQuality(Integer qualityId, QualityUpdateDTO qualityUpdateDTO) throws EntityNoExistsException;
}
