package services;

import data.model.Diary;
import dtos.CreateEntryRequest;
import dtos.LoginRequest;
import dtos.RegisterRequest;

public interface DiaryService {

    void register(RegisterRequest request);

    void login(LoginRequest request);
    void checkLoginWith(LoginRequest request);
    void createEntry(CreateEntryRequest entry);
    void logout(String username);
    void deleteEntry(String username);
    Diary findByUsername(String username);

    Diary findById(String username);

    long totalNumberOfUsers();

}
