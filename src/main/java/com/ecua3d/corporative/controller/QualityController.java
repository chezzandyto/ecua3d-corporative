package com.ecua3d.corporative.controller;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.exception.EntityNoExistsException;
import com.ecua3d.corporative.service.IMaterialService;
import com.ecua3d.corporative.service.IQualityService;
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
@RequestMapping("/quality")
public class QualityController {
    @Autowired
    private IQualityService iQualityService;

    @GetMapping
    public ResponseEntity<List<QualityResponse>> getAllQualities(){
        return new ResponseEntity<List<QualityResponse>>(iQualityService.findAll(), HttpStatus.OK);
    }
    @PatchMapping("/{qualityId}")
    public ResponseEntity<QualityResponse> updateQuality(@PathVariable Integer qualityId, @RequestBody @Valid QualityUpdateDTO body) throws EntityNoExistsException {
        return new ResponseEntity<>(iQualityService.updateQuality(qualityId, body),HttpStatus.OK);
    }
    @GetMapping("/{qualityId}")
    public ResponseEntity<QualityToQuoteResponse> getByQualityId(@PathVariable Integer qualityId) throws EntityNoExistsException {
        return new ResponseEntity<QualityToQuoteResponse>(iQualityService.findByQualityIdRestResponse(qualityId), HttpStatus.OK);
    }

}
