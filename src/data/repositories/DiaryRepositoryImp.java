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
        return diaries;
    }

    @Override
    public Diary findById(String username) {
        for(Diary diary: diaries){
            if(diary.getUsername().equals(username)){
                return diary;
            }
        }
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public Diary delete(String username) {
        for (Diary diary : diaries) {
            if (diary.getUsername().equals(username)) {
                diaries.remove(username);
                return diary;
            }

        }
        return null;
    }

    @Override
    public void delete(Diary diary) {

    }
}
