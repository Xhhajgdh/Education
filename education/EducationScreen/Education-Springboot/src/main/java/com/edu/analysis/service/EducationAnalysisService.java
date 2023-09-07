package com.edu.analysis.service;

import com.edu.analysis.mapper.EdudationMapper;  // 引入 EdudationMapper 接口
import com.edu.analysis.pojo.Education;  // 引入 Education 实体类
import org.springframework.beans.factory.annotation.Autowired;  // 引入 Spring 的依赖注入注解
import org.springframework.stereotype.Service;  // 声明为 Spring 的服务类

import java.util.HashMap;  // 引入 HashMap 类，用于存储键值对数据
import java.util.List;  // 引入 List 类，用于存储数据列表

@Service  // 标注这是一个 Spring 服务类
public class EducationAnalysisService {

    @Autowired  // 进行 Spring 的依赖注入，将 EdudationMapper 注入到当前类中
    private EdudationMapper edudationMapper;

    // 定义方法用于获取全部数据，调用 EdudationMapper 接口中的 selectAll 方法
    public List<Education> selectAll() {
        return edudationMapper.selectAll();
    }

    // 定义方法用于获取分析数据，调用 EdudationMapper 接口中的 selectAnalysis 方法
    public List<HashMap<String, String>> selectAnalysis(String cate) {
        return edudationMapper.selectAnalysis(cate);
    }

    // 定义方法用于获取分析数据2，调用 EdudationMapper 接口中的 selectAnalysis2 方法
    public List<HashMap<String, String>> selectAnalysis2() {
        return edudationMapper.selectAnalysis2();
    }

    // 定义方法用于获取分析数据3，调用 EdudationMapper 接口中的 selectAnalysis3 方法
    public List<HashMap<String, String>> selectAnalysis3() {
        return edudationMapper.selectAnalysis3();
    }

    // 定义方法用于获取分析数据4，调用 EdudationMapper 接口中的 selectAnalysis4 方法
    public List<HashMap<String, String>> selectAnalysis4() {
        return edudationMapper.selectAnalysis4();
    }
}
