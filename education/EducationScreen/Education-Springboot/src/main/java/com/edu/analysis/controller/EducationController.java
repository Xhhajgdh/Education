//处理了教育数据分析相关的请求，通过调用相应的服务方法，将数据处理结果以 JSON 格式返回给客户端。
package com.edu.analysis.controller;

import com.alibaba.fastjson.JSON;  // 引入 FastJSON 库，用于将数据转换为 JSON 格式
import com.edu.analysis.service.EducationAnalysisService;  // 引入 EducationAnalysisService 服务，用于处理教育数据的分析
import com.edu.analysis.pojo.Education;  // 引入 Education 实体类，用于存储教育数据信息
import org.springframework.beans.factory.annotation.Autowired;  // 引入 Spring 的依赖注入注解
import org.springframework.web.bind.annotation.*;  // 引入 Spring Web 的注解，用于定义 RESTful 风格的接口

import java.util.ArrayList;  // 引入 ArrayList 类，用于存储数据列表
import java.util.HashMap;  // 引入 HashMap 类，用于存储键值对数据
import java.util.List;  // 引入 List 类，用于存储数据列表

@RestController  // 声明该类为 Restful 风格的控制器，会自动将返回值转为 JSON
@RequestMapping("/data")  // 映射请求路径的共同前缀为 "/data"
public class EducationController {

    @Autowired  // 进行 Spring 的依赖注入，将 EducationAnalysisService 注入到当前类中
    private EducationAnalysisService educationService;

    // 定义用于处理 POST 请求的方法，映射路径为 "/data/getdata"
    @ResponseBody  // 标注返回的对象会以 JSON 格式返回给客户端
    @RequestMapping(value = "/getdata", method = RequestMethod.POST)
    public List<Education> showData() {
        List<Education> educationList = new ArrayList<>();  // 创建存储 Education 实体的列表
        educationList = educationService.selectAll();  // 调用 educationService 的 selectAll 方法获取教育数据
        return educationList;  // 返回获取到的 Education 列表数据
    }

    // 定义用于处理 GET 请求的方法，映射路径为 "/data/getAnaly"
    @GetMapping("/getAnaly")
    public String getAnData(@RequestParam("cate") String cate) {
        // 调用 educationService 的 selectAnalysis 方法获取指定分类的分析数据
        List<HashMap<String, String>> data = educationService.selectAnalysis(cate);
        // 将获取的数据转为 JSON 格式并返回
        return "{\n\"data\":" + JSON.toJSONString(data) + "\n}";
    }

    // 类似地，定义其他用于处理 GET 请求的方法，分别映射到不同的路径
    @GetMapping("/getAnaly2")
    public String getAnData2() {
        List<HashMap<String, String>> data = educationService.selectAnalysis2();
        return "{\n\"data\":" + JSON.toJSONString(data) + "\n}";
    }

    @GetMapping("/getAnaly3")
    public String getAnData3() {
        List<HashMap<String, String>> data = educationService.selectAnalysis3();
        return "{\n\"data\":" + JSON.toJSONString(data) + "\n}";
    }

    @GetMapping("/getAnaly4")
    public String getAnData4() {
        List<HashMap<String, String>> data = educationService.selectAnalysis4();
        return "{\n\"data\":" + JSON.toJSONString(data) + "\n}";
    }
}
