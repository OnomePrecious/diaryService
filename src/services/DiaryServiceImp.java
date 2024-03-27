package services;

import data.model.Diary;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImp;
import dtos.CreateEntryRequest;
import dtos.LoginRequest;
import dtos.RegisterRequest;
import exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class DiaryServiceImp implements DiaryService {
    private final List<Diary> diaries = new ArrayList<>();
    private final DiaryRepository diaryRepositoryImp = new DiaryRepositoryImp();
     private long totalNumberOfUsers;

        @Override
        public void register(RegisterRequest request) {
            userExist(request.getUsername());
            Diary diary = new Diary();
            diary.setUsername(request.getUsername());
            diary.setPassword(request.getPassword());
            diaryRepositoryImp.save(diary);
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
            for (Diary diary  : diaries)
                if (diary.getUsername().equals(username))
                    return diary;
            throw new UserNotFoundException("user not found");

        }

    @Override
    public Diary findById(String username) {
        return null;
    }

    @Override
    public long totalNumberOfUsers() {
        return diaries.size();
    }
}



















