package solutions.vado.alpr.web.rest;

import org.springframework.web.bind.annotation.*;
import solutions.vado.alpr.web.domain.LicensePlate;
import solutions.vado.alpr.web.repository.LicensePlateRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LicensePlateController {

    private LicensePlateRepository licensePlateRepository;

    public LicensePlateController(LicensePlateRepository licensePlateRepository) {
        this.licensePlateRepository = licensePlateRepository;
    }

    // Get All Notes
    @GetMapping("/licenseplates")
    public List<LicensePlate> getAllLicensePlates() {
        return licensePlateRepository.findAll();
    }

    @GetMapping("/licenseplates/active")
    public List<LicensePlate> getActiveLicensePlates() {
        return licensePlateRepository.findAllByValidFromGreaterThanEqualAndValidToLessThanEqual(new Date(), new Date());
    }

    @GetMapping("/licenseplates/{location}")
    public List<LicensePlate> getAllLicensePlatesForLocation(@PathVariable("location") Long location) {
        return licensePlateRepository.findAllByLocationId(location);
    }

    @PostMapping("/licenseplates")
    public LicensePlate createNote(@Valid @RequestBody LicensePlate licensePlate) {
        return licensePlateRepository.save(licensePlate);
    }

    @PutMapping("/licenseplates/{id}")
    public LicensePlate updateNote(@PathVariable(value = "id") Long licensePlateId,
                                   @Valid @RequestBody LicensePlate licensePlateDetails) {

        LicensePlate plate = licensePlateRepository.getOne(licensePlateId);
        plate.update(licensePlateDetails);
        licensePlateRepository.save(plate);
        return plate;
    }

}
