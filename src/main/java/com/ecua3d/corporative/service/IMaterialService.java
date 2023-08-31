package com.ecua3d.corporative.service;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.model.MaterialEntity;
import com.ecua3d.corporative.vo.MaterialDTO;
import com.ecua3d.corporative.vo.MaterialResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMaterialService {
    List<MaterialResponse> findAll();
    MaterialResponse convertToMaterialResponse(MaterialEntity materialEntity);
    MaterialResponse saveNewMaterial(MaterialDTO materialDTO) throws EntityExistsException;

}
