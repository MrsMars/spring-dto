package com.aoher.controller;

import com.aoher.dto.ModuleDto;
import com.aoher.dto.mapper.ModuleDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ModuleController {

    @Autowired
    private ModuleDtoMapper moduleDtoMapper;

    @PostMapping("/savemodule")
    public HttpStatus saveModule(@Valid @RequestBody ModuleDto moduleDto) {
        moduleDtoMapper.saveModule(moduleDto);
        return HttpStatus.CREATED;
    }

    @GetMapping("/getAllmodules")
    public List<ModuleDto> getModules() {
        return moduleDtoMapper.getAllModules();
    }

    @DeleteMapping("/deleteModuleById/{id}")
    public ResponseEntity<ModuleDto> deleteModule(@PathVariable int id) {
        moduleDtoMapper.deleteModule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateModule")
    public ResponseEntity<ModuleDto> updateModule(@Valid @RequestBody ModuleDto moduleDto) {
        moduleDtoMapper.updateModules(moduleDto);
        return new ResponseEntity<>(moduleDto, HttpStatus.NO_CONTENT);
    }
}
