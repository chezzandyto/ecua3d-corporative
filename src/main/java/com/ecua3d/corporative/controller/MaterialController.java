package com.ecua3d.corporative.controller;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.exception.EntityNoExistsException;
import com.ecua3d.corporative.service.IMaterialService;
import com.ecua3d.corporative.vo.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private IMaterialService iMaterialService;

    @GetMapping
    public ResponseEntity<List<MaterialResponse>> getAllMaterial(){
        return new ResponseEntity<List<MaterialResponse>>(iMaterialService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/save-new-material")
    public ResponseEntity<MaterialResponse> saveNewMaterial(@RequestBody @Valid MaterialDTO body) throws EntityExistsException {
        return new ResponseEntity<>(iMaterialService.saveNewMaterial(body),HttpStatus.CREATED);
    }
    @PatchMapping("/update-material")
    public ResponseEntity<MaterialResponse> updateMaterial(@RequestBody @Valid MaterialUpdateDTO body) throws EntityNoExistsException {
        return new ResponseEntity<>(iMaterialService.updateMaterial(body),HttpStatus.OK);
    }
}
