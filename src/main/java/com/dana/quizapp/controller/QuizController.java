package com.dana.quizapp.controller;

import com.dana.quizapp.model.Question;
import com.dana.quizapp.model.QuestionWrapper;
import com.dana.quizapp.model.Response;
import com.dana.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizservice;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title) {
        return quizservice.createQuiz(category,numQ,title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity <List<QuestionWrapper>> getQuizQuestions(@PathVariable int id) {
        return quizservice.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> responses) {
        return quizservice.calculateResult(id,responses);
    }
}
