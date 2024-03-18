package by.podvintsev.martialartshallsproject.unit.controllerTest;

import by.podvintsev.martialartshallsproject.controller.CoachController;
import by.podvintsev.martialartshallsproject.service.CoachService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CoachControllerTest {
    @Mock
    CoachService coachService;
    @InjectMocks
    CoachController coachController;
}
