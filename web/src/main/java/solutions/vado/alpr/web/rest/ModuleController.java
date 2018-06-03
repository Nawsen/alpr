package solutions.vado.alpr.web.rest;

import org.springframework.web.bind.annotation.*;
import solutions.vado.alpr.web.domain.Module;
import solutions.vado.alpr.web.repository.ModuleRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ModuleController {

    private ModuleRepository moduleRepository;

    public ModuleController(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @GetMapping("/modules")
    public List<Module> getAllModules() {
        return this.moduleRepository.findAll();
    }

    @PutMapping("/modules")
    public Module editModule(@Valid @RequestBody Module module) {
        Module moduleToEdit = this.moduleRepository.getOne(module.getId());
        moduleToEdit.update(module);
        this.moduleRepository.save(moduleToEdit);
        return moduleToEdit;
    }

    @PostMapping("/modules")
    public Module createModule(@Valid @RequestBody Module module) {
        return this.moduleRepository.save(module);
    }

    @PostMapping("/modules/beep")
    public void aliveBeep(@Valid @RequestBody Module module) {
        Module foundById = this.moduleRepository.findFirstByIdEquals(module.getId());
        if (foundById == null) {
            this.moduleRepository.save(module);
        } else {
            foundById.checkIn();
            this.moduleRepository.save(foundById);
        }
    }
}
