package com.ecua3d.corporative.controller;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.service.IMaterialService;
import com.ecua3d.corporative.service.IQualityService;
import com.ecua3d.corporative.vo.MaterialDTO;
import com.ecua3d.corporative.vo.MaterialResponse;
import com.ecua3d.corporative.vo.QualityResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/quality")
public class QualityController {
    @Autowired
    private IQualityService iQualityService;

    @GetMapping
    public ResponseEntity<List<QualityResponse>> getAllQualities(){
        return new ResponseEntity<List<QualityResponse>>(iQualityService.findAll(), HttpStatus.OK);
    }

}
