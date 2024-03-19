package data.model;

import java.time.LocalDateTime;

public class Entry {
    private int id;
    private String body;
    private String title;
    private LocalDateTime dateCreated;

    public int getId() {
        return id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public Entry(int id, String body, String title){
        this.id = id;
        this.body = body;
        this.title = title;
    }

}
