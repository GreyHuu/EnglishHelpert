package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "news", schema = "eng", catalog = "")
public class NewsEntity {
    private int newId;
    private String news;
    private String chinese;
    private String title;
    private String imgurl;

    @Id
    @Column(name = "newID")
    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }

    @Basic
    @Column(name = "news")
    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Basic
    @Column(name = "chinese")
    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "imgurl")
    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsEntity that = (NewsEntity) o;
        return newId == that.newId &&
                Objects.equals(news, that.news) &&
                Objects.equals(chinese, that.chinese) &&
                Objects.equals(title, that.title) &&
                Objects.equals(imgurl, that.imgurl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newId, news, chinese, title, imgurl);
    }
}
