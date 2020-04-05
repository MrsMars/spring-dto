package com.aoher.repositories;

import com.aoher.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Integer> {

    Module findModuleByModuleId(int id);
}
