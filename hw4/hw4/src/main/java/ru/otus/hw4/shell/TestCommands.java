package ru.otus.hw4.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.hw4.domain.User;
import ru.otus.hw4.service.UserService;

@ShellComponent
@RequiredArgsConstructor
public class TestCommands {

    private final UserService userService;

    private User user;

    @ShellMethod(value = "Login to test", key = {"login", "l"})
    public void login() {
        user = userService.initializeTest();
    }

    @ShellMethod(value = "Run test", key = {"run", "test", "r", "t"})
    @ShellMethodAvailability("isTestAvailable")
    public void runTest() {
        userService.runTest();
        userService.finishTest();
    }

    private Availability isTestAvailable() {
        return user == null
                ? Availability.unavailable("Please login")
                : Availability.available();
    }
}
