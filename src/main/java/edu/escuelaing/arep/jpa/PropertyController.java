package edu.escuelaing.arep.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PropertyController {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }


    @GetMapping("/properties")
    public Iterable<Property> getProperties() {
        return propertyRepository.findAll();
    }

    @GetMapping("/property/{id}")
    public Property getPropertyById(long id) {
        return propertyRepository.findById(id);
    }

    @PostMapping("/property")
    public Property saveProperty(@RequestBody Property property) {
        return propertyRepository.save(property);
    }

    @DeleteMapping("/property/{id}")
    public void deleteProperty(@PathVariable long id) {
        propertyRepository.deleteById(id);
    }

    @PutMapping("/property/{id}")
    public Property updateProperty(@PathVariable long id, @RequestBody Property property) {
        Property propertyToUpdate = propertyRepository.findById(id);
        if (propertyToUpdate == null) {
            return null;
        }
        propertyToUpdate.setAddress(property.getAddress());
        propertyToUpdate.setPrice(property.getPrice());
        propertyToUpdate.setSize(property.getSize());
        propertyToUpdate.setDescription(property.getDescription());
        return propertyRepository.save(propertyToUpdate);
    }



}