package service;

import entity.ReadingChooseEntity;
import entity.ReadingQuestionEntity;
import entity.ReadingTotalEntity;
import entity.ReadingtestEntity;


import java.util.List;

public interface ReadingService {
    public List<ReadingtestEntity> getReading();

    public List<ReadingQuestionEntity> getReadingQuestion();

    public ReadingtestEntity getReadingById(int id);

    public ReadingChooseEntity getReadingChooseById(int id);

    public List<ReadingQuestionEntity> getReadingQuestionByReadingId(int id);
    public String insertTotal(ReadingTotalEntity readingTotalEntity);
}
