package services;

import data.model.Diary;
import data.repositories.DiaryRepositoryImp;
import dtos.CreateEntryRequest;
import dtos.LoginRequest;
import dtos.LogoutRequest;
import dtos.RegisterRequest;
import exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class DiaryServiceImp implements DiaryService {
    private final List<Diary> diaries = new ArrayList<>();
    //private DiaryRepositoryImp diaryRepositoryImp = new DiaryRepositoryImp();
    private DiaryServiceImp diaryServiceImp = new DiaryServiceImp();
    private long totalNumberOfUsers;

    @Override
    public void register(RegisterRequest request) {
        userExist(request.getUsername());
        Diary diary = new Diary();
        request.setUsername(request.getUsername());
        request.setPassword(request.getPassword());
        //diary.setLocked(true);
        diaries.add(diary);
        totalNumberOfUsers++;
    }
    public long getTotalNumberOfUsers() {
       return  totalNumberOfUsers;
    }
    private void userExist(String username){
        for (Diary diary:diaries){
            if (diary.getUsername().equals(username))
                throw new UsernameAlreadyExistsException("The user with Username: "+ username+ " already exist");
        }
    }

    @Override
    public void login(LoginRequest request) {
        userExist(request.getUsername());
        Diary diary = new Diary();
        if(isPasswordIncorrect(diary, request.getPassword())) throw new IncorrectPassword("Invalid password");
        diary.setLocked(true);
    }

    private boolean isPasswordIncorrect(Diary diary, String password) {
        if(diary == null){
            throw new NullValueException("password is null");
        }
        if(!diary.getPassword().equals(password)) throw new InvalidPasswordException("Password is not valid");
        return false;
    }

    @Override
    public void checkLoginWith(LoginRequest request) {
    }

    @Override
    public void createEntry(CreateEntryRequest entry) {

    }

    @Override
    public void logout(String username) {
        findByUsername(username);
        Diary diary = new Diary();
        diary.setLocked(false);


    }
    @Override
    public void deleteEntry(String username) {
        if(username != null){
            diaries.remove(username);
        }
    }
    @Override
    public Diary findByUsername(String username) {
        return diaryServiceImp.findByUsername(username);
    }
}

