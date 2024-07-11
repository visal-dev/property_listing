package security_demo.example.exam_rupp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import security_demo.example.exam_rupp.domain.PropertyType;
import security_demo.example.exam_rupp.infrastructure.PropertyTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyTypeService {
    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    public List<PropertyType> findAll() {
        return propertyTypeRepository.findAll();
    }

    public Optional<PropertyType> findById(Long id) {
        return propertyTypeRepository.findById(id);
    }

    public PropertyType save(PropertyType propertyType) {
        return propertyTypeRepository.save(propertyType);
    }

    public void deleteById(Long id) {
        propertyTypeRepository.deleteById(id);
    }
}