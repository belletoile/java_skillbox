package com.example.mod10.repo;

import com.example.mod10.models.Reviews;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ReviewRepository extends CrudRepository<Reviews, Long> {

}
