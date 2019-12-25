package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "writing", schema = "eng", catalog = "")
public class WritingEntity {
    private int compositionId;
    private String composition;
    private String modle;
    private String anser;
    private Integer mark;

    @Id
    @Column(name = "compositionID")
    public int getCompositionId() {
        return compositionId;
    }

    public void setCompositionId(int compositionId) {
        this.compositionId = compositionId;
    }

    @Basic
    @Column(name = "composition")
    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    @Basic
    @Column(name = "modle")
    public String getModle() {
        return modle;
    }

    public void setModle(String modle) {
        this.modle = modle;
    }

    @Basic
    @Column(name = "anser")
    public String getAnser() {
        return anser;
    }

    public void setAnser(String anser) {
        this.anser = anser;
    }

    @Basic
    @Column(name = "mark")
    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WritingEntity that = (WritingEntity) o;
        return compositionId == that.compositionId &&
                Objects.equals(composition, that.composition) &&
                Objects.equals(modle, that.modle) &&
                Objects.equals(anser, that.anser) &&
                Objects.equals(mark, that.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compositionId, composition, modle, anser, mark);
    }
}
