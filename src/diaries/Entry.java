package diaries;

import java.time.LocalDateTime;

public class Entry {
    private int id;
    private String title;
    private String body;

    private LocalDateTime dateCreated;

    public Entry(int id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
        this.dateCreated = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String setTitle(String newTitle){
        return this.title = newTitle;
    }

    public String setBody(String newBody){
        return this.body = newBody;
    }

    public LocalDateTime getDateCreated(){
        return this.dateCreated = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return STR."Diary Entry ID: \{getId()}\nTitle: \{getTitle()}\nBody: \{getBody()}";
    }
}
