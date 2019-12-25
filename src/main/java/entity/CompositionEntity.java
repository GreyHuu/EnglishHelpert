package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "composition", schema = "eng", catalog = "")
public class CompositionEntity {
    private int cptId;
    private String cptTitle;
    private String cptDirection;
    private Date cptCreateTime;
    private String cptModel;
    private int cptReference;

    @Id
    @Column(name = "cpt_id")
    public int getCptId() {
        return cptId;
    }

    public void setCptId(int cptId) {
        this.cptId = cptId;
    }

    @Basic
    @Column(name = "cpt_title")
    public String getCptTitle() {
        return cptTitle;
    }

    public void setCptTitle(String cptTitle) {
        this.cptTitle = cptTitle;
    }

    @Basic
    @Column(name = "cpt_direction")
    public String getCptDirection() {
        return cptDirection;
    }

    public void setCptDirection(String cptDirection) {
        this.cptDirection = cptDirection;
    }

    @Basic
    @Column(name = "cpt_create_time")
    public Date getCptCreateTime() {
        return cptCreateTime;
    }

    public void setCptCreateTime(Date cptCreateTime) {
        this.cptCreateTime = cptCreateTime;
    }

    @Basic
    @Column(name = "cpt_model")
    public String getCptModel() {
        return cptModel;
    }

    public void setCptModel(String cptModel) {
        this.cptModel = cptModel;
    }

    @Basic
    @Column(name = "cpt_reference")
    public int getCptReference() {
        return cptReference;
    }

    public void setCptReference(int cptReference) {
        this.cptReference = cptReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositionEntity that = (CompositionEntity) o;
        return cptId == that.cptId &&
                cptReference == that.cptReference &&
                Objects.equals(cptTitle, that.cptTitle) &&
                Objects.equals(cptDirection, that.cptDirection) &&
                Objects.equals(cptCreateTime, that.cptCreateTime) &&
                Objects.equals(cptModel, that.cptModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cptId, cptTitle, cptDirection, cptCreateTime, cptModel, cptReference);
    }
}
