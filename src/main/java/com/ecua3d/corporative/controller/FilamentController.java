package com.ecua3d.corporative.controller;

import com.ecua3d.corporative.exception.EntityNoExistsException;
import com.ecua3d.corporative.service.IFilamentService;
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
@RequestMapping("/filament")
public class FilamentController {
    @Autowired
    private IFilamentService iFilamentService;

    @GetMapping
    public ResponseEntity<List<FilamentResponse>> getAllFilament(){
        return new ResponseEntity<List<FilamentResponse>>(iFilamentService.findAll(), HttpStatus.OK);
    }
    @PostMapping

    public ResponseEntity<FilamentResponse> saveNewFilament(@RequestBody @Valid FilamentDTO body) {
        return new ResponseEntity<>(iFilamentService.saveNewFilament(body),HttpStatus.CREATED);
    }
    @PatchMapping("/{filamentId}")
    public ResponseEntity<FilamentResponse> updateFilament(@PathVariable Integer filamentId, @RequestBody @Valid FilamentUpdateDTO body) throws EntityNoExistsException {
        return new ResponseEntity<>(iFilamentService.updateFilament(filamentId, body),HttpStatus.OK);
    }

    @GetMapping("/{filamentId}")
    public ResponseEntity<FilamentToQuoteResponse> getByFilamentId(@PathVariable Integer filamentId) throws EntityNoExistsException {
        return new ResponseEntity<FilamentToQuoteResponse>(iFilamentService.findByFilamentIdRestResponse(filamentId), HttpStatus.OK);
    }

}
