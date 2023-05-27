package com.heliverse.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.heliverse.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>{
	
	@Query("SELECT q FROM Quiz q WHERE q.status=ACTIVE")
	List<Quiz> findActiveQuizzes();

	Optional<Quiz> findById(Long id);

}
