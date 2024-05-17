package com.ecua3d.corporative.service;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.model.MaterialEntity;
import com.ecua3d.corporative.repository.IMaterialRepository;
import com.ecua3d.corporative.vo.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class MaterialServiceTest {
    @Mock
    private IMaterialRepository iMaterialRepository;
    @InjectMocks
    private MaterialService materialService;
    @Test
    void findAll() {
        when(iMaterialRepository.findAll()).thenReturn(List.of(new MaterialEntity()));

        List<MaterialResponse> response  = materialService.findAll();

        assertInstanceOf(MaterialResponse.class,response.get(0));
        verify(iMaterialRepository, times(1)).findAll();
        verifyNoMoreInteractions(iMaterialRepository);
    }

    @Test
    void convertToMaterialResponse() {
        Integer id = 1;
        String name = "name";

        MaterialResponse response = materialService.convertToMaterialResponse(new MaterialEntity(id, name));
        assertEquals(id,response.getMaterialId());
        assertEquals(name,response.getNameMaterial());
    }

    @Test
    void saveNewMaterialShouldThrowException() {
        when(iMaterialRepository.existsByNameMaterial(any())).thenReturn(true);
        assertThrows(EntityExistsException.class, ()-> materialService.saveNewMaterial(new MaterialDTO()));
    }
    @Test
    void saveNewMaterial_NoExceptions() throws EntityExistsException {
        String materialName = "PLA";
        when(iMaterialRepository.existsByNameMaterial(any())).thenReturn(false);
        when(iMaterialRepository.save(any())).thenReturn(new MaterialEntity(1,materialName));

        MaterialResponse materialResponse = materialService.saveNewMaterial(new MaterialDTO(materialName));

        assertEquals(materialResponse.getNameMaterial(), materialName);
    }
}