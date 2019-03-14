package com.pmi.util;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.pmi.pojo.Answers;
import com.pmi.pojo.Questions;

public class TextToQuestions extends AbstractCsvConverter {

	@Override
	public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

		// SAMPLE value -> question_number=1, question_asked=What is occupation 1,
		// [answer_number=1, answer_label=mech Lenox, answer_value=mechanical engineer
		// Cheyenne] |
		value = value.replaceAll("\\[", "").replaceAll("\\]", "");
		String[] strArray = value.split("\\,");
		Questions questions = new Questions();
		Answers answers = new Answers();// single answer per question
		List<Answers> answerList = new ArrayList<>();
		for (String str : strArray) {
			String textValue = str.substring(str.indexOf("=") + 1).trim();
			if (str.contains("question_number=")) {
				questions.setQuestion_number(textValue);
			} else if (str.contains("question_asked=")) {
				questions.setQuestion_asked(textValue);
			} else if (str.contains("answer")) {
				if (str.contains("answer_number=")) {
					answers.setAnswer_number(textValue);
				} else if (str.contains("answer_label=")) {
					answers.setAnswer_label(textValue);
				} else if (str.contains("answer_value=")) {
					answers.setAnswer_value(textValue);

				}
			}
		}
		answerList.add(answers);
		questions.setAnswers(answerList);
		return questions;
	}

}
