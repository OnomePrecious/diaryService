package data.model;

import java.time.LocalDateTime;

public class Entry {
    private String id;
    private String body;
    private String title;
    private LocalDateTime dateCreated;
public Entry(){

}
    public String getId() {
        return id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }
      public Entry(String id, String body, String title){
        this.id = id;
        this.body = body;
        this.title = title;
    }

}
