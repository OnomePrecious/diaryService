package repository;

import data.model.Diary;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryRepositoryTest {

    @Test
   public void test_save() {
     DiaryRepository repository = new DiaryRepositoryImp();
     Diary diary = new Diary("username","password");
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
    public void test_thatICanCreateTwoEntries(){
        DiaryRepository repository = new DiaryRepositoryImp();

    }
    @Test
     public void testfindById() {
    }

    @Test
    void count() {
    }

    @Test
    void delete() {
    }

    @Test
    void testDelete() {
    }
}