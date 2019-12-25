package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reading_total", schema = "eng", catalog = "")
public class ReadingTotalEntity {
    private int id;
    private Integer readingId;
    private String total;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "reading_id")
    public Integer getReadingId() {
        return readingId;
    }

    public void setReadingId(Integer readingId) {
        this.readingId = readingId;
    }

    @Basic
    @Column(name = "total")
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadingTotalEntity that = (ReadingTotalEntity) o;
        return id == that.id &&
                Objects.equals(readingId, that.readingId) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, readingId, total);
    }
}
