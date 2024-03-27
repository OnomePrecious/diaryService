package controllers;

import data.model.Diary;
import dtos.CreateEntryRequest;
import dtos.RegisterRequest;
import exceptions.*;
import services.DiaryService;
import services.DiaryServiceImp;
import dtos.LoginRequest;

public class DiaryController {
    private final DiaryService diaryService = new DiaryServiceImp();
    private Diary diary;
    public String register(RegisterRequest registerRequest) {
        try {
            diaryService.register(registerRequest);
            return "Registration successful";
        }catch (DiaryIsNotAccessibleException e){
            return "diary is locked";
        }
    }
    public String login(LoginRequest loginRequest) {
        try {
            diaryService.login(loginRequest);
            return "Login successful ";
        } catch (LoginNotSuccessfulException e) {
            return "unable to login";
        }
    }
    public String createEntry(CreateEntryRequest createEntry){
        try {
            diaryService.createEntry(createEntry);
            return "A new entry successfully created";
        }catch (UnableToCreateAnEntryException e){
            return "unable to create an entry";
        }
    }
    public String logout(String username){
        try {
            diaryService.logout(username);
            return "Logout successful";
        }catch (UnableToLogoutException e){
            return "unable to log out";
        }
    }
    public String deleteEntry(String username){
        try {
            diaryService.deleteEntry(username);
            return "Entry successfully deleted";
        }catch (UnableToDeleteEntryException e){
            return "failed to delete an entry";
        }
    }
}
