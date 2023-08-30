package ru.otus.hw4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw4.domain.User;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class FinishTestServiceImpl implements FinishTestService {

    private final LocalizationService localizationService;

    private final IOService ioService;

    @Override
    public void finishTest(User user) {
        var correctAnswersCount = getCorrectCount(user);
        var resultMessage = localizationService.getMessage("test.result", correctAnswersCount);
        ioService.outputString(resultMessage);
    }

    private int getCorrectCount(User user) {
        int correctCount = 0;
        var tasks = user.test().tasks();
        for (int i = 0; i < tasks.size(); i++) {
            var userAnswer = Arrays.asList(user.userAnswers().get(i));
            var correctAnswers = new ArrayList<>();
            var answers = tasks.get(i).answers();
            for (int j = 0; j < answers.size(); j++) {
                if (answers.get(j).isCorrect()) {
                    correctAnswers.add(String.valueOf(j + 1));
                }
            }
            if (userAnswer.equals(correctAnswers)) {
                correctCount++;
            }
        }
        ioService.outputEmptyLine();
        return correctCount;
    }
}
