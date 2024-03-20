package data.repositories;

import data.model.Diary;
import data.model.Entry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryRepositoryTest {

    @Test
   public void test_saveEntry() {
        EntryRepository repository = new EntryRepositoryImp();
        Entry entry = new Entry(1, "Precious", "The story of my life");
        repository.save(entry);
        assertEquals(1, repository.count());
    }

    @Test
    public void test_findById() {
        EntryRepository repository = new EntryRepositoryImp();
        Entry entry = new Entry(1, "Had i known", "Anonymous");
        repository.save(entry);
        assertEquals(entry, repository.findById("username"));

    }

    @Test
    void delete() {
    }

    @Test
    void testDelete() {
    }
}