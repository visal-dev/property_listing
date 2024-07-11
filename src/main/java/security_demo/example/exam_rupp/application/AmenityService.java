package security_demo.example.exam_rupp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import security_demo.example.exam_rupp.domain.Amenity;
import security_demo.example.exam_rupp.infrastructure.AmenityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AmenityService {
    @Autowired
    private AmenityRepository amenityRepository;

    public List<Amenity> findAll() {
        return amenityRepository.findAll();
    }

    public Optional<Amenity> findById(Long id) {
        return amenityRepository.findById(id);
    }

    public Amenity save(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    public void deleteById(Long id) {
        amenityRepository.deleteById(id);
    }
}