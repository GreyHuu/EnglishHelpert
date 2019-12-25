package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reading_choose", schema = "eng", catalog = "")
public class ReadingChooseEntity {
    private int id;
    private String readingChooseA;
    private String readingChooseB;
    private String readingChooseC;
    private String readingChooseD;
    private String result;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "reading_choose_a")
    public String getReadingChooseA() {
        return readingChooseA;
    }

    public void setReadingChooseA(String readingChooseA) {
        this.readingChooseA = readingChooseA;
    }

    @Basic
    @Column(name = "reading_choose_b")
    public String getReadingChooseB() {
        return readingChooseB;
    }

    public void setReadingChooseB(String readingChooseB) {
        this.readingChooseB = readingChooseB;
    }

    @Basic
    @Column(name = "reading_choose_c")
    public String getReadingChooseC() {
        return readingChooseC;
    }

    public void setReadingChooseC(String readingChooseC) {
        this.readingChooseC = readingChooseC;
    }

    @Basic
    @Column(name = "reading_choose_d")
    public String getReadingChooseD() {
        return readingChooseD;
    }

    public void setReadingChooseD(String readingChooseD) {
        this.readingChooseD = readingChooseD;
    }

    @Basic
    @Column(name = "result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadingChooseEntity that = (ReadingChooseEntity) o;
        return id == that.id &&
                Objects.equals(readingChooseA, that.readingChooseA) &&
                Objects.equals(readingChooseB, that.readingChooseB) &&
                Objects.equals(readingChooseC, that.readingChooseC) &&
                Objects.equals(readingChooseD, that.readingChooseD) &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, readingChooseA, readingChooseB, readingChooseC, readingChooseD, result);
    }
}
