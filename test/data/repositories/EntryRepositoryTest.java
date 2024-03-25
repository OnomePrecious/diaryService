package data.repositories;

import data.model.Diary;
import data.model.Entry;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EntryRepositoryTest {

    @Test
    public void test_saveEntry() {
        EntryRepository repository = new EntryRepositoryImp();
        Entry entry = new Entry("1234", "Precious", "The story of my life");
        repository.save(entry);
        assertEquals(1, repository.count());
    }

    @Test
    public void test_thatICanSaveTwoEntries() {
        EntryRepository repository = new EntryRepositoryImp();
        Entry entry = new Entry("1234", "Precious", "The story of my life");
        Entry entry1 = new Entry("12345", "Rachel", "The blind mistake");
        repository.save(entry);
        repository.save(entry1);
        assertEquals(2, repository.count());
    }

    @Test
    public void test_findById() {
        EntryRepository repository = new EntryRepositoryImp();
        Entry entry = new Entry("1234", "Had i known", "Anonymous");
        repository.save(entry);
        assertEquals(entry, repository.findById("1234"));

    }

    @Test
    public void test_deleteById() {
        EntryRepository repository = new EntryRepositoryImp();
        Entry entry = new Entry("1234", "Had i known", "Anonymous");
        Entry entry1 = new Entry("2352", "Precious", "The story of my life");
        repository.save(entry);
        repository.save(entry1);
        repository.delete("1234");
        assertNull(repository.findById("1234"));

    }

    @Test
    public void test_ThatWhenICreateFourEntriesAndDeleteTwoById_bothEntriesIsNull() {
        EntryRepository repository = new EntryRepositoryImp();
        Entry entry1 = new Entry("12", "Had i known", "Anonymous");
        Entry entry2 = new Entry("32", "Precious", "The story of my life");
        Entry entry3 = new Entry("63", "I wish", "I can fly");
        Entry entry4 = new Entry("54", "Jesus loves you", "Love of Christ");
        repository.save(entry1);
        repository.save(entry2);
        repository.save(entry3);
        repository.save(entry4);
        repository.delete("12");
        repository.delete("32");
        assertNull(repository.findById("12"));
        assertNull(repository.findById("32"));

    }


    @Test
    public void test_deleteByEntry() {
        EntryRepository repository = new EntryRepositoryImp();
        Entry entry = new Entry("12", "Had i known", "Anonymous");
        repository.save(entry);
        repository.delete(entry);
        assertNull(repository.findById("12"));
    }

    @Test
    public void testThatICanFindAllEntries() {
        EntryRepository repository = new EntryRepositoryImp();
        Entry entry = new Entry("12", "Had i known", "Anonymous");
        Entry entry1 = new Entry("52", "Precious", "The story of my life");
        repository.save(entry);
        repository.save(entry1);
        List<Entry> entries = new ArrayList<>();
        entries.add(entry);
        entries.add(entry1);
        assertEquals(entries, repository.findAll());
    }



}