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
	
	@PostMapping
	public Quiz createQuiz(@RequestBody Quiz quiz) throws QuizException {
		return quizService.createQuiz(quiz);
	}
	@GetMapping("/active")
	public List<Quiz> getActiveQuiz() throws QuizException {
		return quizService.getActiveQuiz();
	}
	@GetMapping("/{id}/result")
	public QuizAnswerDto getQuizResult(@PathVariable Long id) throws QuizException {
		return quizService.getQuizResult(id);
	}
	@GetMapping("/all")
	public List<Quiz> getAllQuizzes() throws QuizException {
		return quizService.getAllQuizzes();
	}

}
