package com.ecua3d.corporative.service;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.exception.EntityNoExistsException;
import com.ecua3d.corporative.model.ColorEntity;
import com.ecua3d.corporative.model.FilamentEntity;
import com.ecua3d.corporative.repository.IFilamentRepository;
import com.ecua3d.corporative.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilamentService implements IFilamentService {

    @Autowired
    private IColorService iColorService;

    @Autowired
    private IMaterialService iMaterialService;
    @Autowired
    private IFilamentRepository iFilamentRepository;
    @Override
    public List<FilamentResponse> findAll() {
        List<FilamentEntity> filamentEntities = (List<FilamentEntity>) iFilamentRepository.findAll();
        return filamentEntities.stream().map(this::convertToFilamentResponse).collect(Collectors.toList());
    }

    @Override
    public FilamentResponse convertToFilamentResponse(FilamentEntity filamentEntity) {
        return FilamentResponse.builder()
                .id(filamentEntity.getId())
                .color(iColorService.convertToColorResponse(filamentEntity.getColorEntity()))
                .material(iMaterialService.convertToMaterialResponse(filamentEntity.getMaterialEntity()))
                .brand(filamentEntity.getBrand())
                .diameter(filamentEntity.getDiameter())
                .weight(filamentEntity.getWeight())
                .temperature(filamentEntity.getTemperature())
                .cost(filamentEntity.getCost())
                .remaining(filamentEntity.getRemaining())
                .vendorId(filamentEntity.getVendorId())
                .build();
    }

    @Override
    public FilamentResponse saveNewFilament(FilamentDTO filamentDTO) throws EntityExistsException {
//        Boolean ifExists=iFilamentRepository.existsByNameFilament(filamentDTO..getNameColor());
//        if (ifExists) throw new EntityExistsException(HttpStatus.BAD_REQUEST,"Ya existe: " +colorDTO.getNameColor());
        FilamentEntity newEntity = new FilamentEntity();
        newEntity.setColorId(filamentDTO.getColorId());
        newEntity.setMaterialId(filamentDTO.getMaterialId());
        newEntity.setBrand(filamentDTO.getBrand());
        newEntity.setDiameter(filamentDTO.getDiameter());
        newEntity.setTemperature(filamentDTO.getTemperature());
        newEntity.setWeight(filamentDTO.getWeight());
        newEntity.setCost(filamentDTO.getCost());
        newEntity.setRemaining(filamentDTO.getRemaining());
        newEntity.setVendorId(filamentDTO.getVendorId());
        iFilamentRepository.save(newEntity);
        return convertToFilamentResponse(newEntity);
    }

    @Override
    public FilamentEntity findByFilamentId(Integer filamentId) throws EntityNoExistsException {
        return iFilamentRepository.findById(filamentId)
                .orElseThrow(() -> new EntityNoExistsException(HttpStatus.BAD_REQUEST,"No existe"));
    }

    @Override
    public FilamentResponse updateFilament(FilamentUpdateDTO filamentUpdateDTO) throws EntityNoExistsException {
        FilamentEntity updatableEntity = findByFilamentId(filamentUpdateDTO.getFilamentId());
        updatableEntity.setColorId(filamentUpdateDTO.getColorId());
        updatableEntity.setMaterialId(filamentUpdateDTO.getMaterialId());
        updatableEntity.setBrand(filamentUpdateDTO.getBrand());
        updatableEntity.setWeight(filamentUpdateDTO.getWeight());
        updatableEntity.setDiameter(filamentUpdateDTO.getDiameter());
        updatableEntity.setTemperature(filamentUpdateDTO.getTemperature());
        updatableEntity.setCost(filamentUpdateDTO.getCost());
        updatableEntity.setVendorId(filamentUpdateDTO.getVendorId());
        updatableEntity.setRemaining(filamentUpdateDTO.getRemaining());
        iFilamentRepository.save(updatableEntity);
        return convertToFilamentResponse(updatableEntity);
    }


}
