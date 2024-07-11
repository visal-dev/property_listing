package security_demo.example.exam_rupp.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import security_demo.example.exam_rupp.domain.PropertyType;

public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {}
