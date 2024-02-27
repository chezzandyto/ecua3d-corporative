package com.ecua3d.corporative.controller;

import com.ecua3d.corporative.exception.EntityExistsException;
import com.ecua3d.corporative.exception.EntityNoExistsException;
import com.ecua3d.corporative.service.IColorService;
import com.ecua3d.corporative.vo.ColorDTO;
import com.ecua3d.corporative.vo.ColorResponse;

import com.ecua3d.corporative.vo.ColorUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/color")
public class ColorController {
    @Autowired
    private IColorService iColorService;

    @GetMapping
    public ResponseEntity<List<ColorResponse>> getAllColor(){
        return new ResponseEntity<List<ColorResponse>>(iColorService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ColorResponse> saveNewColor(@RequestBody @Valid ColorDTO body) throws EntityExistsException {
        return new ResponseEntity<>(iColorService.saveNewColor(body),HttpStatus.CREATED);
    }
    @PatchMapping("/{colorId}")
    public ResponseEntity<ColorResponse> updateColor(@PathVariable Integer colorId, @RequestBody @Valid ColorUpdateDTO body) throws EntityNoExistsException {
        return new ResponseEntity<>(iColorService.updateColor(colorId, body),HttpStatus.OK);
    }

    @GetMapping("/findBy")
    public ResponseEntity<List<ColorResponse>> getByColorName(@RequestParam String colorName) throws EntityNoExistsException {
        return new ResponseEntity<List<ColorResponse>>(iColorService.findByColorName(colorName), HttpStatus.OK);
    }
}
