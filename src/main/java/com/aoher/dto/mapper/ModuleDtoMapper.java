package com.aoher.dto.mapper;

import com.aoher.dto.ModuleDto;
import com.aoher.entity.Module;
import com.aoher.services.ModuleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ModuleDtoMapper {

    @Autowired
    private ModuleService moduleService;

    private ModelMapper modelMapper = new ModelMapper();

    public Module saveModule(ModuleDto moduleDto) {
        Module module = modelMapper.map(moduleDto, Module.class);
        return moduleService.saveModule(module);
    }

    public List<ModuleDto> getAllModules() {
        List<Module> modules = moduleService.getModules();
        Type listType = new TypeToken<List<ModuleDto>>() {}.getType();
        return modelMapper.map(modules, listType);
    }

    public void deleteModule(int id) {
        moduleService.deleteModuleById(id);
    }

    public void updateModules(ModuleDto moduleDto) {
        Module module = modelMapper.map(moduleDto, Module.class);
        entityToDTO(moduleService.updateModule(module));
    }

    private ModuleDtoMapper entityToDTO(Module module) {
        return modelMapper.map(module, ModuleDtoMapper.class);
    }

}
