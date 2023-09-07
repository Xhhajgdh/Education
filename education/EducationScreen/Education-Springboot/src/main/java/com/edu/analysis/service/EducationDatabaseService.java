package com.edu.analysis.service;

import com.edu.analysis.dao.EducationInfoDao;  // 引入 EducationInfoDao 接口
import com.edu.analysis.pojo.Education;  // 引入 Education 实体类
import org.springframework.beans.factory.annotation.Autowired;  // 引入 Spring 的依赖注入注解
import org.springframework.data.domain.Example;  // 引入 Spring Data JPA 的 Example 类
import org.springframework.stereotype.Service;  // 声明为 Spring 的服务类

import java.util.List;  // 引入 List 类，用于存储数据列表

@Service  // 标注这是一个 Spring 服务类
public class EducationDatabaseService {

    @Autowired  // 进行 Spring 的依赖注入，将 EducationInfoDao 注入到当前类中
    private EducationInfoDao educationInfoDao;

    // 定义方法用于保存教育数据，如果数据不存在则保存
    public void save(Education education) {
        Education param = new Education();
        param.setUrl(education.getUrl());  // 设置查询参数为 education 对象的 url 字段
        List<Education> list = this.findHouseInfo(param);  // 调用 findHouseInfo 方法查询是否存在相同 url 的数据
        if (list.isEmpty()) {
            educationInfoDao.saveAndFlush(education);  // 若不存在相同 url 的数据，则保存新的 education 数据
        }
    }

    // 定义方法用于根据指定参数查询教育数据
    public List<Education> findHouseInfo(Education education) {
        Example<Education> example = Example.of(education);  // 创建 Example 对象以进行查询
        return educationInfoDao.findAll(example);  // 调用 findAll 方法进行查询并返回结果列表
    }
}
