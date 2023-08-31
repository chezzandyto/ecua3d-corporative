package com.ecua3d.corporative.service;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.model.ColorEntity;
import com.ecua3d.corporative.model.MaterialEntity;
import com.ecua3d.corporative.vo.ColorDTO;
import com.ecua3d.corporative.vo.ColorResponse;
import com.ecua3d.corporative.vo.MaterialDTO;
import com.ecua3d.corporative.vo.MaterialResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IColorService {
    List<ColorResponse> findAll();
    ColorResponse convertToColorResponse(ColorEntity colorEntity);
    ColorResponse saveNewColor(ColorDTO colorDTO) throws EntityExistsException;
}
