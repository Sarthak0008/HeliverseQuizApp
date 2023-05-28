package com.heliverse.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heliverse.dto.QuizAnswerDto;
import com.heliverse.entity.Quiz;
import com.heliverse.entity.QuizStatus;
import com.heliverse.exception.QuizException;
import com.heliverse.repository.QuizRepository;



@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public Quiz createQuiz(Quiz quiz) throws QuizException {
		quiz.setStatus(QuizStatus.INACTIVE);
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getActiveQuiz() throws QuizException {
		
		List<Quiz> quizzes=quizRepository.findActiveQuizzes();
		if(quizzes.isEmpty())
		{
			throw new QuizException("No Active Quiz found");
		}
		else
		{
			return quizzes;
		}
	}


	@Override
	public List<Quiz> getAllQuizzes() throws QuizException {
		List<Quiz> quizzes=quizRepository.findAll();
		if(quizzes.isEmpty()){
			throw new QuizException("No  Quiz found");
		}else{
			return quizzes;
		}
	}

	@Override
	public QuizAnswerDto getQuizResult(Long id) throws QuizException {
		Optional<Quiz> quiz=quizRepository.findById(id);

		if(quiz.isPresent()) {
			Quiz q=quiz.get();
			LocalDateTime ldt=LocalDateTime.now();
			long duration=Duration.between(q.getEndDate(),ldt).toMinutes();
			if(duration>5){
				Quiz ans = quiz.get();
				QuizAnswerDto qadt=new QuizAnswerDto();
				qad.setQuestion(ans.getQuestion());
				qad.setOptions(ans.getOptions());
				qad.setAnswer(ans.getOptions().get(answer.getRightAnswerIndex()));
				return  qadt;
			}else{
				throw  new QuizException("Please try after 5 munutes of the Quiz end");
			}
		}else {
			throw new QuizException("Invalid ID");
		}

	}

}
