package com.ecua3d.corporative.service;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.exception.EntityNoExistsException;
import com.ecua3d.corporative.model.ColorEntity;
import com.ecua3d.corporative.model.MaterialEntity;
import com.ecua3d.corporative.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMaterialService {
    List<MaterialResponse> findAll();
    MaterialResponse convertToMaterialResponse(MaterialEntity materialEntity);
    MaterialResponse saveNewMaterial(MaterialDTO materialDTO) throws EntityExistsException;
    MaterialEntity findByMaterialId(Integer materialId) throws EntityNoExistsException;
    MaterialResponse updateMaterial(Integer materialId, MaterialUpdateDTO materialUpdateDTO) throws EntityNoExistsException;

}
