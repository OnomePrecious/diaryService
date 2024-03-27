package data.repositories;

import data.model.Diary;
import dtos.LoginRequest;
import exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImp implements DiaryRepository{
    private List<Diary> diaries = new ArrayList<>();
    private long count;
    @Override
    public Diary save(Diary diary) {
        diaries.add(diary);
        count++;

        return diary;
    }

    @Override
    public List<Diary> findAll() {
        return diaries;
    }

    @Override
    public Diary findById(String username) {
        for (Diary diary : diaries) {
            if (diary.getUsername().equals(username)) {
                return diary;
            }break;
        }
            throw new UserNotFoundException("not found");

    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public void delete(String username) {

        diaries.removeIf(diary -> diary.getUsername().equals(username));
    }

    @Override
    public void delete(Diary diary) {
        diaries.remove(diary);


    }

    @Override
    public void login(LoginRequest loginrequest) {
    }

    public void logout(String username) {

    }
}

