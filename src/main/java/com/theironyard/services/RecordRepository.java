package com.theironyard.services;

import com.theironyard.entities.Record;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, Integer>{
    Record findById(Integer id);

}
