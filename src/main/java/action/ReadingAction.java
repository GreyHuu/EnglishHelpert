package action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import entity.ReadingTotalEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.ReadingService;

import javax.annotation.Resource;


@Controller("readingAction")
@Scope("prototype")
public class ReadingAction extends ActionSupport {

    private static final long serialVersionUID = 2L;

    @Resource
    private ReadingService readingService;

    private String result;


    private int id;

    private int total;

    @Override
    public String execute() throws Exception {
        result = new Gson().toJson(readingService.getReading());
        return "success";
    }

    //    获得问题
    public String getQuestionByTestId() {
        result = new Gson().toJson(readingService.getReadingQuestionByReadingId(id));
        return "question";
    }

    //    获得选项
    public String getChooseById() {
        result = new Gson().toJson(readingService.getReadingChooseById(id));
        return "choose";
    }


    //    获得选项
    public String insertTotal() {
        ReadingTotalEntity entity = new ReadingTotalEntity();
        entity.setReadingId(id);
        entity.setReadingId(total);
        result = new Gson().toJson(readingService.insertTotal(entity));
        return "insert";
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
