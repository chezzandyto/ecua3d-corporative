package com.ecua3d.corporative.service;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.model.MaterialEntity;
import com.ecua3d.corporative.repository.IMaterialRepository;
import com.ecua3d.corporative.vo.MaterialDTO;
import com.ecua3d.corporative.vo.MaterialResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialService implements IMaterialService {

    @Autowired
    private IMaterialRepository iMaterialRepository;
    @Override
    public List<MaterialResponse> findAll() {
        List<MaterialEntity> materialEntities = (List<MaterialEntity>) iMaterialRepository.findAll();
        return materialEntities.stream().map(this::convertToMaterialResponse).collect(Collectors.toList());
    }

    @Override
    public MaterialResponse convertToMaterialResponse(MaterialEntity materialEntity) {
        return MaterialResponse.builder()
                .materialId(materialEntity.getMaterialId())
                .nameMaterial(materialEntity.getNameMaterial())
                .build();
    }

    @Override
    public MaterialResponse saveNewMaterial(MaterialDTO materialDTO) throws EntityExistsException {
        Boolean ifExists=iMaterialRepository.existsByNameMaterial(materialDTO.getNameMaterial());
        if (ifExists) throw new EntityExistsException(HttpStatus.BAD_REQUEST,"Ya existe: " +materialDTO.getNameMaterial());
        MaterialEntity newEntity = new MaterialEntity();
        newEntity.setNameMaterial(materialDTO.getNameMaterial());
        iMaterialRepository.save(newEntity);
        return convertToMaterialResponse(newEntity);
    }


}
