package security_demo.example.exam_rupp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security_demo.example.exam_rupp.application.PropertyTypeService;
import security_demo.example.exam_rupp.domain.PropertyType;

import java.util.List;

@RestController
@RequestMapping("/api/property-types")
public class PropertyTypeController {

    @Autowired
    private PropertyTypeService propertyTypeService;

    @GetMapping
    public List<PropertyType> getAllPropertyTypes() {
        return propertyTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyType> getPropertyTypeById(@PathVariable Long id) {
        return propertyTypeService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PropertyType createPropertyType(@RequestBody PropertyType propertyType) {
        return propertyTypeService.save(propertyType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyType> updatePropertyType(@PathVariable Long id, @RequestBody PropertyType updatedPropertyType) {
        return propertyTypeService.findById(id)
                .map(propertyType -> {
                    propertyType.setName(updatedPropertyType.getName());
                    propertyType.setDescription(updatedPropertyType.getDescription());
                    return ResponseEntity.ok(propertyTypeService.save(propertyType));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePropertyType(@PathVariable Long id) {
        propertyTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}