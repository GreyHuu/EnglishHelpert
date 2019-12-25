package service;

import dao.ReadingDao;
import entity.ReadingChooseEntity;
import entity.ReadingQuestionEntity;
import entity.ReadingTotalEntity;
import entity.ReadingtestEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("readingService")
public class ReadingServiceImpl implements ReadingService {

    @Resource
    private ReadingDao readingDao;

    @Override
    public List<ReadingtestEntity> getReading() {
        return readingDao.getReading();
    }

    @Override
    public List<ReadingQuestionEntity> getReadingQuestion() {
        return readingDao.getReadingQuestion();
    }

    @Override
    public ReadingtestEntity getReadingById(int id) {
        return readingDao.getReadingById(id);
    }

    @Override
    public ReadingChooseEntity getReadingChooseById(int id) {
        return readingDao.getReadingChooseById(id);
    }

    @Override
    public List<ReadingQuestionEntity> getReadingQuestionByReadingId(int id) {
        return readingDao.getReadingQuestionByTestId(id);
    }

    @Override
    public String insertTotal(ReadingTotalEntity readingTotalEntity) {
        return readingDao.insertTotal(readingTotalEntity);
    }
}
