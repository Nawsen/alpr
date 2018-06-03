package solutions.vado.alpr.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solutions.vado.alpr.web.domain.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    Module findFirstByIdEquals(Long id);
}
