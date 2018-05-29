package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity
public class Answer {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "body")
    private String body;

    @ForeignKey(entity = Question.class, parentColumns = "uid", childColumns = "questionId", onDelete = CASCADE)
    private int questionId;

    public Answer(int uid, String body, int questionId) {
        this.uid = uid;
        this.body = body;
        this.questionId = questionId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
