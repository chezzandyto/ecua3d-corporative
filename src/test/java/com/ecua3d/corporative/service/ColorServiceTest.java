package com.ecua3d.corporative.service;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.model.ColorEntity;
import com.ecua3d.corporative.repository.IColorRepository;
import com.ecua3d.corporative.vo.ColorDTO;
import com.ecua3d.corporative.vo.ColorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ColorServiceTest {
    @Mock
    private IColorRepository iColorRepository;
    @InjectMocks
    private ColorService colorService;
    @Test
    void findAll() {
        when(iColorRepository.findAll()).thenReturn(List.of(new ColorEntity()));
        List<ColorResponse> response  = colorService.findAll();
        assertInstanceOf(ColorResponse.class,response.get(0));
    }

    @Test
    void convertToColorResponse() {
        Integer id = 1;
        String name = "name";

        ColorResponse response = colorService.convertToColorResponse(new ColorEntity(id, name));
        assertEquals(id,response.getColorId());
        assertEquals(name,response.getNameColor());
    }

    @Test
    void saveNewColorShouldThrowException() {
       when(iColorRepository.existsByNameColor(any())).thenReturn(true);
       assertThrows(EntityExistsException.class, ()-> colorService.saveNewColor(new ColorDTO()));
    }


    @Test
    void saveNewColor_NoExceptions() throws EntityExistsException {
        String colorName = "blue";
        when(iColorRepository.existsByNameColor(any())).thenReturn(false);
        when(iColorRepository.save(any())).thenReturn(new ColorEntity(1,colorName));

        ColorResponse colorResponse = colorService.saveNewColor(new ColorDTO(colorName));

        assertEquals(colorResponse.getNameColor(), colorName);
    }
}