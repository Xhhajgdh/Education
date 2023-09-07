package com.edu.analysis.task;

import com.edu.analysis.pojo.Education;  // 引入 Education 实体类
import com.edu.analysis.service.EducationDatabaseService;  // 引入 EducationDatabaseService 服务
import org.springframework.beans.factory.annotation.Autowired;  // 引入 Spring 的依赖注入注解
import org.springframework.stereotype.Component;  // 声明为 Spring 组件
import us.codecraft.webmagic.ResultItems;  // 引入 webmagic 的 ResultItems 类
import us.codecraft.webmagic.Task;  // 引入 webmagic 的 Task 类
import us.codecraft.webmagic.pipeline.Pipeline;  // 引入 webmagic 的 Pipeline 接口

@Component  // 标注这是一个 Spring 组件
public class EducationDataPipeline implements Pipeline {

    @Autowired  // 进行 Spring 的依赖注入，将 EducationDatabaseService 注入到当前类中
    private EducationDatabaseService educationDatabaseService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        // 从 resultItems 中获取封装好的教育对象
        Education education = resultItems.get("education");
        // 判断数据是否不为空
        if (education != null) {
            educationDatabaseService.save(education);  // 调用 educationDatabaseService 的 save 方法保存数据
        }
    }
}
