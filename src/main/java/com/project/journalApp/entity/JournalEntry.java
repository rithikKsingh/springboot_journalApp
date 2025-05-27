package com.project.journalApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection="journal_entries")
@Data
@NoArgsConstructor //in lombok, when you use @Data, args constructor gets called. So when your code runs, it might show errors.like
//bad request. To avoid it , you need to use @NoArgsConstructor
public class JournalEntry {
//    private long id;

    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;

//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
//
//    //    public long getId() {
////        return id;
////    }
//    public ObjectId getId(){
//        return id;
//    }
//
////    public void setId(long id) {
////        this.id = id;
////    }
//    public void setId(ObjectId id){
//        this.id=id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
}
