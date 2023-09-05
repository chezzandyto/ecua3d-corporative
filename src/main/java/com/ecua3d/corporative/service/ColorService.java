package com.ecua3d.corporative.service;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.model.ColorEntity;
import com.ecua3d.corporative.repository.IColorRepository;
import com.ecua3d.corporative.vo.ColorDTO;
import com.ecua3d.corporative.vo.ColorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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
                .build();
    }
    @Override
    public ColorResponse saveNewColor(ColorDTO colorDTO) throws EntityExistsException {
        Boolean ifExists=iColorRepository.existsByNameColor(colorDTO.getNameColor());
        if (ifExists) throw new EntityExistsException(HttpStatus.BAD_REQUEST,"Ya existe: " +colorDTO.getNameColor());
        ColorEntity newEntity = new ColorEntity();
        newEntity.setNameColor(colorDTO.getNameColor());
        iColorRepository.save(newEntity);
        return convertToColorResponse(newEntity);
    }
}
