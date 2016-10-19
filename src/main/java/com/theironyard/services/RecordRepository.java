package com.theironyard.services;

import com.theironyard.entities.Record;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecordRepository extends CrudRepository<Record, Integer>{

    Record findById(Integer id);

    List<Record> findAll();

}
