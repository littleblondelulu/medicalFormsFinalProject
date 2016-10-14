package com.theironyard.services;

import com.theironyard.entities.Answer;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by lindseyringwald on 10/11/16.
 */
public interface AnswerRepository extends CrudRepository<Answer, Integer>{
    Answer findById(Integer id);
}
