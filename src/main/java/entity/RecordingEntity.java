package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "recording", schema = "eng", catalog = "")
public class RecordingEntity {
    private int id;
    private String userid;
    private String time;
    private int number;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordingEntity that = (RecordingEntity) o;
        return id == that.id &&
                number == that.number &&
                Objects.equals(userid, that.userid) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, time, number);
    }
}
