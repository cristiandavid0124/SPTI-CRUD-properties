package edu.escuelaing.arep.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropertyRepository extends CrudRepository<Property, Long> {

    Property findById(long id);

    List<Property> findAll();


}
