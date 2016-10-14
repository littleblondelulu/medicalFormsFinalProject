package com.theironyard.services;

import com.theironyard.entities.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by lindseyringwald on 10/11/16.
 */
public interface PatientRepository extends CrudRepository<Patient, Integer>{
//    List<Patient> findAllFirstByName(String name);

    Patient findById(Integer id);

    List<Patient> findAll();

}
