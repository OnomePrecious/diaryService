package data.repositories;

import data.model.Diary;

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
        return null;
    }

    @Override
    public Diary findById(String username) {
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public void delete(String username) {

    }

    @Override
    public void delete(Diary diary) {

    }
}
