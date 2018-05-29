package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity
public class Question {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "body")
    private String body;

    @ColumnInfo(name = "type")
    private String type;

    @ForeignKey(entity = Form.class, parentColumns = "uid", childColumns = "formId", onDelete = CASCADE)
    private int formId;

    public Question(int uid, String body, String type, int formId){
        this.uid = uid;
        this.body = body;
        this.type = type;
        this.formId = formId;
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

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
