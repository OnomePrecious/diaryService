package data.repositories;

import data.model.Diary;
import data.model.Entry;

import java.util.List;

public interface EntryRepository {
    Entry save(Entry entry);
    List<Entry> findAll();
    Entry findById(String username);
    long count();
    void delete(String username);
    void delete(Entry Entry);



}
