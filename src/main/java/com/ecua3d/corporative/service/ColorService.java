package com.ecua3d.corporative.service;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.exception.EntityNoExistsException;
import com.ecua3d.corporative.model.ColorEntity;
import com.ecua3d.corporative.repository.IColorRepository;
import com.ecua3d.corporative.vo.ColorDTO;
import com.ecua3d.corporative.vo.ColorResponse;
import com.ecua3d.corporative.vo.ColorUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ColorService implements IColorService {

    @Autowired
    private IColorRepository iColorRepository;
    @Override
    public List<ColorResponse> findAll() {
        List<ColorEntity> colorEntities = (List<ColorEntity>) iColorRepository.findAll();
        return colorEntities.stream().map(this::convertToColorResponse).collect(Collectors.toList());
    }

    @Override
    public ColorResponse convertToColorResponse(ColorEntity colorEntity) {
        return ColorResponse.builder()
                .colorId(colorEntity.getColorId())
                .nameColor(colorEntity.getNameColor())
                .hexadecimal(colorEntity.getHexadecimal())
                .build();
    }
    @Override
    public ColorResponse saveNewColor(ColorDTO colorDTO) throws EntityExistsException {
        Boolean ifExists=iColorRepository.existsByNameColor(colorDTO.getNameColor());
        if (ifExists) throw new EntityExistsException(HttpStatus.BAD_REQUEST,"Ya existe: " +colorDTO.getNameColor());
        ColorEntity newEntity = new ColorEntity();
        newEntity.setNameColor(colorDTO.getNameColor());
        newEntity.setHexadecimal(colorDTO.getHexadecimal());
        iColorRepository.save(newEntity);
        return convertToColorResponse(newEntity);
    }

    @Override
    public ColorEntity findByColorId(Integer colorId) throws EntityNoExistsException {
        return iColorRepository.findByColorId(colorId)
                .orElseThrow(() -> new EntityNoExistsException(HttpStatus.BAD_REQUEST,"No existe"));
    }

    @Override
    public ColorResponse updateColor(Integer colorId, ColorUpdateDTO colorUpdateDTO) throws EntityNoExistsException {
       ColorEntity updatableEntity = findByColorId(colorId);
       updatableEntity.setNameColor(colorUpdateDTO.getNameColor());
       updatableEntity.setHexadecimal(colorUpdateDTO.getHexadecimal());
       iColorRepository.save(updatableEntity);
       return convertToColorResponse(updatableEntity);
    }

    @Override
    public List<ColorResponse> findByColorName(String colorName) throws EntityNoExistsException {
        List<ColorEntity> colorEntities = (List<ColorEntity>) iColorRepository.findByNameColor(colorName);
        return colorEntities.stream().map(this::convertToColorResponse).collect(Collectors.toList());
    }
}
