package com.heliverse.service;

import java.util.List;

import com.heliverse.dto.QuizAnswerDto;
import com.heliverse.entity.Quiz;
import com.heliverse.exception.QuizException;

public interface QuizService {
	
	public Quiz createQuiz(Quiz quiz) throws QuizException;
	public List<Quiz> getActiveQuiz() throws QuizException;
	public List<Quiz> getAllQuizzes() throws QuizException;
	public QuizAnswerDto getQuizResult(Long id) throws QuizException;

}
