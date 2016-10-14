package com.theironyard.services;

import com.sun.tools.javac.util.List;
import com.theironyard.entities.Form;
import com.theironyard.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface FormRepository extends CrudRepository<Form, Integer>{
    List<Form> findByName(String title);
    Form findById(Integer id);

}
