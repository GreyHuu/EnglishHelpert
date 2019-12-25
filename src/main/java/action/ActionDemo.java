package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.UserEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.UserService;

import javax.annotation.Resource;


@Controller("userAction")
@Scope("prototype")
//创建IndexAction(action类)继承ActionSupport接口
public class ActionDemo extends ActionSupport {

    private static final long serialVersionUID = 1L;

    //声明service，但不给它创建具体的实现类的实例，
    @Resource
    private UserService userService;

    //编写execute()方法
    public String execute() {
        //获取IndexService实例，调用getAllBookCard()方法
        //将结果保存到List集合里
        List<UserEntity> myUserList = userService.getAllUser();

        //将查询出来的结构集打印到控制台
        System.out.println("结果集：" + myUserList.size());

        //获取Context上下文对象
        ActionContext ac = ActionContext.getContext();

        //将myBookCardList集合添加到上下文对象里
        ac.put("myUserList", myUserList);

        //返回一个字符串
        return "success";
    }
}
