package com.edu.analysis.mapper;

import com.edu.analysis.pojo.Education;  // 引入 Education 实体类，用于映射教育数据信息
import org.apache.ibatis.annotations.Mapper;  // 引入 MyBatis 的 Mapper 注解
import org.apache.ibatis.annotations.Param;  // 引入 MyBatis 的 Param 注解
import org.springframework.stereotype.Repository;  // 引入 Spring 的 Repository 注解

import java.util.HashMap;  // 引入 HashMap 类，用于存储键值对数据
import java.util.List;  // 引入 List 类，用于存储数据列表

@Mapper  // 标注这是一个 MyBatis 的 Mapper 接口
@Repository  // 声明该类为 Spring 的 Repository，表示这是一个数据访问对象
public interface EdudationMapper {

    // 声明查询所有教育数据的方法
    public List<Education> selectAll();

    // 声明根据某个条件进行分析的方法，使用 @Param 注解将参数绑定到 SQL 查询中
    public List<HashMap<String, String>> selectAnalysis(@Param("cate") String cate);

    // 声明其他用于分析的方法，获取不同类型的数据分析结果
    public List<HashMap<String, String>> selectAnalysis2();
    public List<HashMap<String, String>> selectAnalysis3();
    public List<HashMap<String, String>> selectAnalysis4();
}
