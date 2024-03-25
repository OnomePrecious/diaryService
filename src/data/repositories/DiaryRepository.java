package data.repositories;

import data.model.Diary;
import dtos.LoginRequest;

import java.util.List;

public interface DiaryRepository {
        Diary save(Diary diary);
        List<Diary> findAll();
        Diary findById(String username);
        long count();
        void delete(String username);
        void delete(Diary diary);

        void login(LoginRequest request);
}
