package data.repositories;

import data.model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImp implements EntryRepository {
    private List <Entry> entries = new ArrayList<>();
    private long count;

    @Override
    public Entry save(Entry entry) {
        entries.add(entry);
        count++;
        return entry;
    }

    @Override
    public List<Entry> findAll() {
        return null;
    }

    @Override
    public Entry findById(String username) {
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
    public void delete(Entry Entry) {

    }
}
