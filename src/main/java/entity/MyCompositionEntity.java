package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "myComposition", schema = "eng", catalog = "")
public class MyCompositionEntity {
    private int mycptId;
    private Integer cptId;
    private String mycpt;
    private Date mycptCreateTime;
    private Integer mycptWordCount;
    private Integer userId;
    private String cptTitle;

    @Id
    @Column(name = "mycpt_id")
    public int getMycptId() {
        return mycptId;
    }

    public void setMycptId(int mycptId) {
        this.mycptId = mycptId;
    }

    @Basic
    @Column(name = "cpt_id")
    public Integer getCptId() {
        return cptId;
    }

    public void setCptId(Integer cptId) {
        this.cptId = cptId;
    }

    @Basic
    @Column(name = "mycpt")
    public String getMycpt() {
        return mycpt;
    }

    public void setMycpt(String mycpt) {
        this.mycpt = mycpt;
    }

    @Basic
    @Column(name = "mycpt_create_time")
    public Date getMycptCreateTime() {
        return mycptCreateTime;
    }

    public void setMycptCreateTime(Date mycptCreateTime) {
        this.mycptCreateTime = mycptCreateTime;
    }

    @Basic
    @Column(name = "mycpt_word_count")
    public Integer getMycptWordCount() {
        return mycptWordCount;
    }

    public void setMycptWordCount(Integer mycptWordCount) {
        this.mycptWordCount = mycptWordCount;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "cpt_title")
    public String getCptTitle() {
        return cptTitle;
    }

    public void setCptTitle(String cptTitle) {
        this.cptTitle = cptTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCompositionEntity that = (MyCompositionEntity) o;
        return mycptId == that.mycptId &&
                Objects.equals(cptId, that.cptId) &&
                Objects.equals(mycpt, that.mycpt) &&
                Objects.equals(mycptCreateTime, that.mycptCreateTime) &&
                Objects.equals(mycptWordCount, that.mycptWordCount) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(cptTitle, that.cptTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mycptId, cptId, mycpt, mycptCreateTime, mycptWordCount, userId, cptTitle);
    }
}
