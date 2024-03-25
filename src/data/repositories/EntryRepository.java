package data.repositories;

import data.model.Entry;

import java.util.List;

public interface EntryRepository {
    Entry save(Entry entry);
    List<Entry> findAll();

    Entry findById(String id);

    long count();
    void delete(String id);

    void delete(Entry Entry);



}
