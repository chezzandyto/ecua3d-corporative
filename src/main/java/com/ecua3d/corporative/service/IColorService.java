package com.ecua3d.corporative.service;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.exception.EntityNoExistsException;
import com.ecua3d.corporative.model.ColorEntity;
import com.ecua3d.corporative.model.MaterialEntity;
import com.ecua3d.corporative.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IColorService {
    List<ColorResponse> findAll();
    ColorResponse convertToColorResponse(ColorEntity colorEntity);
    ColorResponse saveNewColor(ColorDTO colorDTO) throws EntityExistsException;
    ColorEntity findByColorId(Integer colorId) throws EntityNoExistsException;
    ColorResponse updateColor(Integer colorId, ColorUpdateDTO colorUpdateDTO) throws EntityNoExistsException;
    List<ColorResponse> findByColorName(String colorName) throws EntityNoExistsException;
}
