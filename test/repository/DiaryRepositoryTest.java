package repository;

import data.model.Diary;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImp;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiaryRepositoryTest {

    @Test
    public void test_save() {
        DiaryRepository repository = new DiaryRepositoryImp();
        Diary diary = new Diary("username", "password");
        repository.save(diary);
        assertEquals(1, repository.count());

    }

    @Test
    public void test_saveDiary_returnsDiary() {
        DiaryRepository repository = new DiaryRepositoryImp();
        Diary diary = new Diary("username", "password");
        assertEquals(diary, repository.save(diary));

    }

    @Test
    public void test_thatICanCreateTwoEntries() {
        DiaryRepository repository = new DiaryRepositoryImp();
        Diary diary = new Diary("username", "password");
        Diary diary1 = new Diary("username", "password");
        repository.save(diary);
        repository.save(diary1);
        assertEquals(2, repository.count());
    }

    @Test
    public void test_putInAList_returnsTheList(){
        DiaryRepository repository = new DiaryRepositoryImp();
        Diary diary = new Diary("username", "password");
        Diary diary1 = new Diary("username", "password");
        repository.save(diary);
        repository.save(diary1);
        List<Diary> diaries = new ArrayList<>();
        diaries.add(diary);
        diaries.add(diary1);
        assertEquals(diaries, repository.findAll());
}
    @Test
     public void test_findById() {
        DiaryRepository repository = new DiaryRepositoryImp();
        Diary diary = new Diary("username", "password");
        repository.save(diary);
        assertEquals(diary, repository.findById("username"));

    }
    @Test
    public void test_delete() {
        DiaryRepository repository = new DiaryRepositoryImp();
        Diary diary = new Diary("username", "password");
        Diary diary1 = new Diary("username2", "password2");
        repository.save(diary);
        repository.save(diary1);
        List<Diary> diaries = new ArrayList<>();
        diaries.add(diary);
        diaries.add(diary1);
        assertEquals(diary, repository.delete("username"));
    }
}