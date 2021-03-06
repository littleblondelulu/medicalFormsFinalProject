package com.theironyard.services;

import com.theironyard.entities.Form;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FormRepository extends CrudRepository<Form, Integer>{
    List<Form> findByName(String title);
    Form findById(Integer id);
    List<Form> findAll();


}
