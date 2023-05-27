package com.heliverse.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.heliverse.repository.QuizRepository;


@Component
public class QuizScheduler {
	
	private final QuizRepository quizRepository;

	public QuizScheduler(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	@Scheduled(cron = "0 0/1 * * * ?")
	@Transactional
	public void updateQuizStatuses() {
		LocalDateTime now = LocalDateTime.now();

		List<Quiz> activeQuizzes = quizRepository.findAll()
				.stream()
				.filter(q -> q.getStartDate().isBefore(now) && q.getEndDate().isAfter(now))
				.collect(Collectors.toList());

		List<Quiz> inactiveQuizzes = quizRepository.findAll()
				.stream()
				.filter(q -> q.getStartDate().isAfter(now))
				.collect(Collectors.toList());

		List<Quiz> finishedQuizzes = quizRepository.findAll()
				.stream()
				.filter(q -> q.getEndDate().isBefore(now))
				.collect(Collectors.toList());

		if (!activeQuizzes.isEmpty()) {
			activeQuizzes.forEach(q -> q.setStatus(QuizStatus.ACTIVE));
			quizRepository.saveAll(activeQuizzes);
			quizRepository.flush(); 
		}

		if (!finishedQuizzes.isEmpty()) {
			finishedQuizzes.forEach(q -> q.setStatus(QuizStatus.FINISHED));
			quizRepository.saveAll(finishedQuizzes);
			quizRepository.flush(); 
		}

		if (!inactiveQuizzes.isEmpty()) {
			inactiveQuizzes.forEach(q -> q.setStatus(QuizStatus.INACTIVE));
			quizRepository.saveAll(inactiveQuizzes);
			quizRepository.flush(); 
		}

	}

}
