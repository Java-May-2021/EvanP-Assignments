package com.evan.beltReview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.evan.beltReview.models.Wedding;

@Repository
public interface WeddingRepository extends CrudRepository<Wedding, Long> {
	List<Wedding> findAll();


}
