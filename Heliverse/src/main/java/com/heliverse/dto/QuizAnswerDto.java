package com.heliverse.dto;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class QuizAnswerDto {
	
	private String question;
	private List<String> options;
	private String answer;

}
