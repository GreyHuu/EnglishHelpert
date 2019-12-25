package dao;

import entity.ReadingChooseEntity;
import entity.ReadingQuestionEntity;
import entity.ReadingTotalEntity;
import entity.ReadingtestEntity;

import java.util.List;

public interface ReadingDao {
    public List<ReadingtestEntity> getReading();

    public List<ReadingQuestionEntity> getReadingQuestion();

    public ReadingtestEntity getReadingById(int id);

    public ReadingChooseEntity getReadingChooseById(int id);

    public List<ReadingQuestionEntity> getReadingQuestionByTestId(int id);

    public String insertTotal(ReadingTotalEntity readingTotalEntity);
}
