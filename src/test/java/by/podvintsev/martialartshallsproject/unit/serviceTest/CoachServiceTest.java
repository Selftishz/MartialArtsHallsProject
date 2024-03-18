package by.podvintsev.martialartshallsproject.unit.serviceTest;

import by.podvintsev.martialartshallsproject.repository.CoachRepository;
import by.podvintsev.martialartshallsproject.service.CoachService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CoachServiceTest {
    @InjectMocks
    private CoachService coachService;
    @Mock
    private CoachRepository coachRepository;
}
