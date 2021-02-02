package ru.chaban.mongock.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ru.chaban.domain.Author;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "dropDb", author = "chaban", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

/*    @ChangeSet(order = "002", id = "insertLermontov", author = "ydvorzhetskiy")
    public void insertLermontov(MongoDatabase db) {
        MongoCollection<Document> myCollection = db.getCollection("persons");
        var doc = new Document().append("name", "Lermontov");
        myCollection.insertOne(doc);
    }*/

/*
    @ChangeSet(order = "003", id = "insertPushkin", author = "stvort")
   public void insertPushkin(Author repository) {
        repository.save(new Author("Pushkin"));
    }
*/

}
