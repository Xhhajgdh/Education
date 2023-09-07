package com.edu.analysis.dao;

import com.edu.analysis.pojo.Education;  // 引入 Education 实体类，用于存储教育数据信息
import org.springframework.data.jpa.repository.JpaRepository;  // 引入 Spring Data JPA 的 JpaRepository 接口
//继承自 JpaRepository 接口，用于操作 Education 实体类对应的数据库表，
// 提供常用的 CRUD 操作方法: 注释说明了这个接口继承自 JpaRepository，
// 用于操作 Education 实体类所对应的数据库表，并且提供了常用的增删改查操作方法
public interface EducationInfoDao extends JpaRepository<Education, Long> {
    // 继承自 JpaRepository 接口，用于操作 Education 实体类对应的数据库表，提供常用的 CRUD 操作方法
}
