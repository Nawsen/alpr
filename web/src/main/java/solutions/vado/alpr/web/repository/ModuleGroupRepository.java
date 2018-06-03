package solutions.vado.alpr.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solutions.vado.alpr.web.domain.ModuleGroup;

@Repository
public interface ModuleGroupRepository extends JpaRepository<ModuleGroup, Long> {
}
