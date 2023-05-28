package com.heliverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public Quiz createQuizHandler(@RequestBody Quiz quiz) throws QuizException {
		return quizService.createQuiz(quiz);
	}
	
	// GET controller method to find active quizzes which is started
	@GetMapping("/active")
	public List<Quiz> getActiveQuizHandler() throws QuizException {
		return quizService.getActiveQuiz();
	}
	
	// controller method to find result by id
	@GetMapping("/{id}/result")
	public QuizAnswerDto getQuizResultHandler(@PathVariable Long id) throws QuizException {
		return quizService.getQuizResult(id);
	}
	
	// controller method to find all quizzes
	@GetMapping("/all")
	public List<Quiz> getAllQuizzesHandler() throws QuizException {
		return quizService.getAllQuizzes();
	}

}
