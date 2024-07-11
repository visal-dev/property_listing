package security_demo.example.exam_rupp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security_demo.example.exam_rupp.application.AmenityService;
import security_demo.example.exam_rupp.domain.Amenity;

import java.util.List;

@RestController
@RequestMapping("/api/amenities")
public class AmenityController {

    @Autowired
    private AmenityService amenityService;

    @GetMapping
    public List<Amenity> getAllAmenities() {
        return amenityService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Amenity> getAmenityById(@PathVariable Long id) {
        return amenityService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Amenity createAmenity(@RequestBody Amenity amenity) {
        return amenityService.save(amenity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Amenity> updateAmenity(@PathVariable Long id, @RequestBody Amenity updatedAmenity) {
        return amenityService.findById(id)
                .map(amenity -> {
                    amenity.setName(updatedAmenity.getName());
                    return ResponseEntity.ok(amenityService.save(amenity));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmenity(@PathVariable Long id) {
        amenityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}