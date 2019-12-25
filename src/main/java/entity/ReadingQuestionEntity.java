package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reading_question", schema = "eng", catalog = "")
public class ReadingQuestionEntity {
    private int id;
    private String readingQuestion;
    private Integer readingChoose;
    private int readingId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "reading_question")
    public String getReadingQuestion() {
        return readingQuestion;
    }

    public void setReadingQuestion(String readingQuestion) {
        this.readingQuestion = readingQuestion;
    }

    @Basic
    @Column(name = "reading_choose")
    public Integer getReadingChoose() {
        return readingChoose;
    }

    public void setReadingChoose(Integer readingChoose) {
        this.readingChoose = readingChoose;
    }

    @Basic
    @Column(name = "reading_id")
    public int getReadingId() {
        return readingId;
    }

    public void setReadingId(int readingId) {
        this.readingId = readingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadingQuestionEntity that = (ReadingQuestionEntity) o;
        return id == that.id &&
                readingId == that.readingId &&
                Objects.equals(readingQuestion, that.readingQuestion) &&
                Objects.equals(readingChoose, that.readingChoose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, readingQuestion, readingChoose, readingId);
    }
}
