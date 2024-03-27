package services;

import data.model.Diary;
import data.repositories.DiaryRepositoryImp;
import dtos.RegisterRequest;
import exceptions.UsernameAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class DiaryServiceTest {
    private DiaryServiceImp diaryService;
    private DiaryRepositoryImp diaryRepositoryImp;

    @BeforeEach
            public void setUp(){
        diaryService = new DiaryServiceImp();
        diaryRepositoryImp = new DiaryRepositoryImp();
    }
    @Test
    public void testThatIfADiaryIsRegistered_totalDiaryIsEqualsOne() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.register(registerRequest);
        assertEquals(1, diaryService.getTotalNumberOfUsers());
    }
    @Test
    public void testThatIfIRegisterTwiceWithSameUsername_throwsUsernameAlreadyExistsException() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setUsername("username");
        registerRequest.setPassword("my password");
        diaryService.register(registerRequest);
        assertThrows(UsernameAlreadyExistsException.class, () -> diaryService.register(registerRequest));
    }

    @Test
    public void testThatIfADiaryIsRegisteredTwice_totalDiaryIsEqualsTwo() {
        RegisterRequest registerRequest = new RegisterRequest();
        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest1.setUsername("my name");
        registerRequest1.setPassword("my password");
        diaryService.register(registerRequest);
        diaryService.register(registerRequest1);
        assertEquals(2 , diaryService.getTotalNumberOfUsers());
    }

    @Test
    public void testThatICanFindDiaryByUsername() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.register(registerRequest);
        Diary diary = new Diary();
        diary.setUsername(registerRequest.getUsername());
        assertEquals(diary, diaryService.findByUsername("username"));
    }
}