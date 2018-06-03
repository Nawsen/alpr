package solutions.vado.alpr.web.rest;

import org.springframework.web.bind.annotation.*;
import solutions.vado.alpr.web.domain.ModuleGroup;
import solutions.vado.alpr.web.repository.ModuleGroupRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ModuleGroupController {

    private ModuleGroupRepository moduleGroupRepository;

    public ModuleGroupController(ModuleGroupRepository moduleGroupRepository) {
        this.moduleGroupRepository = moduleGroupRepository;
    }

    @GetMapping("/modulegroups")
    public List<ModuleGroup> getAllModuleGroups() {
        return this.moduleGroupRepository.findAll();
    }

    @PutMapping("/modulegroups")
    public ModuleGroup editModule(@Valid @RequestBody ModuleGroup module) {
        ModuleGroup moduleGroupToEdit = this.moduleGroupRepository.getOne(module.getId());
        moduleGroupToEdit.update(module);
        this.moduleGroupRepository.save(moduleGroupToEdit);
        return moduleGroupToEdit;
    }

    @PostMapping("/modulegroups")
    public ModuleGroup createModule(@Valid @RequestBody ModuleGroup module) {
        return this.moduleGroupRepository.save(module);
    }
}
