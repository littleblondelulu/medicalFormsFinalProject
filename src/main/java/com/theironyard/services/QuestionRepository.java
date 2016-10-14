package com.theironyard.services;


import com.theironyard.entities.Question;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lindseyringwald on 10/11/16.
 */
public interface QuestionRepository extends CrudRepository<Question, Integer>{
    Question findById(Integer id);
}
