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
        return entries;
    }



    @Override
    public Entry findById(int id) {
        for(Entry entry: entries) {
            if (entry.getId()== id) {
                return entry;
            }
        }

        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public void delete(int id) {
        entries.removeIf(entry -> entry.getId()== id);


    }

    @Override
    public void delete(Entry entry) {
        entries.remove(entry);

    }
}
