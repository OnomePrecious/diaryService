package dtos;

public class CreateEntryRequest {
    private int id;
    private String author;
    private String body;
    private String title;

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public void setId() {
        this.id = id;
    }
     public void setBody() {
         this.body = body;
     }
     public void setAuthor(){
      this.author = author;
    }
    public void setTitle(){
        this.title = title;

    }

    public int getId() {
        return id;
    }
}
