package com.ecua3d.corporative.service;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.exception.EntityNoExistsException;
import com.ecua3d.corporative.model.ColorEntity;
import com.ecua3d.corporative.model.FilamentEntity;
import com.ecua3d.corporative.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFilamentService {
    List<FilamentResponse> findAll();
    FilamentResponse convertToFilamentResponse(FilamentEntity filamentEntity);
    FilamentResponse saveNewFilament(FilamentDTO filamentDTO);
    FilamentEntity findByFilamentId(Integer filamentId) throws EntityNoExistsException;
    FilamentToQuoteResponse findByFilamentIdRestResponse(Integer filamentId) throws EntityNoExistsException;
    FilamentResponse updateFilament(Integer filamentId, FilamentUpdateDTO filamentUpdateDTO) throws EntityNoExistsException;
}
