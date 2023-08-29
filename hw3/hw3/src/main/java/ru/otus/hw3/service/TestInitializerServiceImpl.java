package ru.otus.hw3.service;

import org.springframework.stereotype.Service;
import ru.otus.hw3.domain.User;

import java.util.ArrayList;

@Service
public class TestInitializerServiceImpl implements TestInitializerService {

    private final LocalizationService localizationService;

    private final IOService ioService;

    private final TestService testService;

    public TestInitializerServiceImpl(LocalizationService localizationService,
                                      IOService ioService,
                                      TestService testService) {
        this.localizationService = localizationService;
        this.ioService = ioService;
        this.testService = testService;
    }

    @Override
    public User createUser() {
        var name = inputUserName();
        var surname = inputUserSurnameName();
        var helloMessage = localizationService.getMessage("test.start", name, surname);
        ioService.outputString(helloMessage);

        return new User(name, surname, testService.getTest(), new ArrayList<>());
    }

    private String inputUserName() {
        var nameText = localizationService.getMessage("test.name");
        return ioService.inputWithText(nameText);
    }

    private String inputUserSurnameName() {
        var surnameText = localizationService.getMessage("test.surname");
        return ioService.inputWithText(surnameText);
    }
}
