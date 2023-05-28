package com.heliverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.heliverse.dto.QuizAnswerDto;
import com.heliverse.entity.Quiz;
import com.heliverse.exception.QuizException;
import com.heliverse.service.QuizService;

@RestController
@RequestMapping("/heliversequizzes")
public class QuizController {
	
	@Autowired
	private QuizService quizService;

	// POST controller method to create quiz
	@PostMapping("/create")
	public ResponseEntity<Quiz> createQuizHandler(@RequestBody Quiz quiz) throws QuizException {
		return new ResponseEntity<Quiz>(quizService.createQuiz(quiz), HttpStatus.CREATED) ;
	}
	
	// GET controller method to find active quizzes which is started
	@GetMapping("/active")
	public ResponseEntity<List<Quiz>> getActiveQuizHandler() throws QuizException {
		return new ResponseEntity<List<Quiz>>( quizService.getActiveQuiz(),HttpStatus.OK);
	}
	
	// controller method to find result by id
	@GetMapping("/{id}/result")
	public ResponseEntity<QuizAnswerDto> getQuizResultHandler(@PathVariable Long id) throws QuizException {
		return new ResponseEntity<QuizAnswerDto>( quizService.getQuizResult(id),HttpStatus.OK);
	}
	
	// controller method to find all quizzes
	@GetMapping("/all")
	public ResponseEntity<List<Quiz>> getAllQuizzesHandler() throws QuizException {
		return new ResponseEntity<List<Quiz>>( quizService.getAllQuizzes(),HttpStatus.OK);
	}

}
