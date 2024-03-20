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
        assertEquals(entry, repository.findById(1));

    }

    @Test
    public void test_deleteById() {
        EntryRepository repository = new EntryRepositoryImp();
        Entry entry = new Entry(1, "Had i known", "Anonymous");
        Entry entry1 = new Entry(2, "Precious", "The story of my life");
        repository.save(entry);
        repository.save(entry1);
        repository.delete(1);
        assertNull(repository.findById(1));

    }

    @Test
   void testDelete() {
   }
}