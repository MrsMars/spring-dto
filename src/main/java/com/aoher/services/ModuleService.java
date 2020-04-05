package com.aoher.services;

import com.aoher.entity.Module;
import java.util.List;

public interface ModuleService {

    Module saveModule(Module module);
    List<Module> getModules();
    Module getModuleById(int moduleId);
    void deleteModuleById(int moduleId);
    Module updateModule(Module module);
}
