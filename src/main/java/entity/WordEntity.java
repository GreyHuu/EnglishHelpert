package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "word", schema = "eng", catalog = "")
public class WordEntity {
    private int id;
    private String englishWord;
    private String pa;
    private String chineseWord;
    private String englishInstance1;
    private String chineseInstance1;
    private String englishInstance2;
    private String chineseInstance2;
    private Integer collect;
    private String pron;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "englishWord")
    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    @Basic
    @Column(name = "pa")
    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    @Basic
    @Column(name = "chineseWord")
    public String getChineseWord() {
        return chineseWord;
    }

    public void setChineseWord(String chineseWord) {
        this.chineseWord = chineseWord;
    }

    @Basic
    @Column(name = "englishInstance1")
    public String getEnglishInstance1() {
        return englishInstance1;
    }

    public void setEnglishInstance1(String englishInstance1) {
        this.englishInstance1 = englishInstance1;
    }

    @Basic
    @Column(name = "chineseInstance1")
    public String getChineseInstance1() {
        return chineseInstance1;
    }

    public void setChineseInstance1(String chineseInstance1) {
        this.chineseInstance1 = chineseInstance1;
    }

    @Basic
    @Column(name = "englishInstance2")
    public String getEnglishInstance2() {
        return englishInstance2;
    }

    public void setEnglishInstance2(String englishInstance2) {
        this.englishInstance2 = englishInstance2;
    }

    @Basic
    @Column(name = "chineseInstance2")
    public String getChineseInstance2() {
        return chineseInstance2;
    }

    public void setChineseInstance2(String chineseInstance2) {
        this.chineseInstance2 = chineseInstance2;
    }

    @Basic
    @Column(name = "collect")
    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    @Basic
    @Column(name = "pron")
    public String getPron() {
        return pron;
    }

    public void setPron(String pron) {
        this.pron = pron;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordEntity that = (WordEntity) o;
        return id == that.id &&
                Objects.equals(englishWord, that.englishWord) &&
                Objects.equals(pa, that.pa) &&
                Objects.equals(chineseWord, that.chineseWord) &&
                Objects.equals(englishInstance1, that.englishInstance1) &&
                Objects.equals(chineseInstance1, that.chineseInstance1) &&
                Objects.equals(englishInstance2, that.englishInstance2) &&
                Objects.equals(chineseInstance2, that.chineseInstance2) &&
                Objects.equals(collect, that.collect) &&
                Objects.equals(pron, that.pron);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, englishWord, pa, chineseWord, englishInstance1, chineseInstance1, englishInstance2, chineseInstance2, collect, pron);
    }
}
