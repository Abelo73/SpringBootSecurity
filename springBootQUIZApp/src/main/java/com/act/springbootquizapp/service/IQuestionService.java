package com.act.springbootquizapp.service;

import com.act.springbootquizapp.model.Question;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface IQuestionService {
//    Method to create new questions
    Question createQuestion(Question question);
    List<Question> getAllQuestions();
    Optional<Question> getQuestionById(Long id);
    List<String> getAllSubjects();
    Question updateQuestion(Long id, Question question) throws ChangeSetPersister.NotFoundException;
    void deleteQuestion(Long id);
    List <Question> getQuestionsForUser(Integer numOfQuestions, String subject);
}
