package services;

import data.model.Diary;
import dtos.LoginRequest;
import dtos.RegisterRequest;
import exceptions.UsernameAlreadyExistsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class DiaryServiceTest {
    DiaryServiceImp diaryService = new DiaryServiceImp();

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

    @Test
    public void test_ThatICanLogin(){
        LoginRequest loginRequest = new LoginRequest();
        Diary diary = new Diary();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryService.login(loginRequest);
        assertFalse(diary.setLocked(true));
        //diary.lockStatus();
        //assertTrue(diary.setLocked(true));


    }



}