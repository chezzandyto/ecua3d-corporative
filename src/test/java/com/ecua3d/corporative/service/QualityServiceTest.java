package com.ecua3d.corporative.service;

import com.ecua3d.corporative.model.QualityEntity;
import com.ecua3d.corporative.repository.IQualityRepository;
import com.ecua3d.corporative.vo.QualityResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QualityServiceTest {

    @Mock
    private IQualityRepository iQualityRepository;
    @InjectMocks
    private QualityService qualityService;
    @Test
    void findAll() {
        when(iQualityRepository.findAll()).thenReturn(List.of(new QualityEntity()));

        List<QualityResponse> response  = qualityService.findAll();

        assertInstanceOf(QualityResponse.class,response.get(0));
    }

    @Test
    void convertToQualityResponse() {
        Integer id = 1;
        String name = "name";

        QualityResponse response = qualityService.convertToQualityResponse(new QualityEntity(id, name));
        assertEquals(id,response.getQualityId());
        assertEquals(name,response.getNameQuality());
    }
}