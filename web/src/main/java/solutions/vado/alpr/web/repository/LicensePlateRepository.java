package solutions.vado.alpr.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solutions.vado.alpr.web.domain.LicensePlate;

import java.util.Date;
import java.util.List;

@Repository
public interface LicensePlateRepository extends JpaRepository<LicensePlate, Long> {

    List<LicensePlate> findAllByLocationId(Long location);

    List<LicensePlate> findAllByValidFromGreaterThanEqualAndValidToLessThanEqual(Date date, Date date2);
}
