package com.heliverse.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@RequiredArgsConstructor
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotNull
	@NotEmpty
	private String question;
	
	@ElementCollection
	@CollectionTable(name = "quiz_options")
	@NotNull
	@NotEmpty
	private List<String> options;
	
	@Column(nullable = false)
	@NotNull
	private int rightAnswerIndex;
	
	@Column(nullable = false)
	@NotNull
	private LocalDateTime startDate;
	
	@Column(nullable = false)
	@NotNull
	private LocalDateTime endDate;
	
	@Column(nullable = false)
	@NotNull
	private QuizStatus  status;

}
