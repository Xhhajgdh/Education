package com.edu.analysis.pojo;

import javax.persistence.*;

@Entity  // 标明这是一个 JPA 实体类
public class Education {
    @Id  // 声明该字段为实体的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 指定主键生成策略为自增
    private Long id;  // 订单id
    private String nickName;  // 用户昵称
    private String orderPay;  // 订单金额
    private String orderPayWay;  // 订单支付方式
    private String orderWay;  // 订单来源
    private String courceType;  // 课程类型
    private String studentAge;  // 学生年龄
    private String vipGrade;  // VIP等级
    private String gender;  // 性别
    private String ipCity;  // ip来源
    private String registrationDays;  // 注册天数
    private String courceTeacher;  // 任课老师
    private String area;  // 课程所属学科
    private String courseIntroduction;  // 课程介绍
    private String pic;  // 课程封面url
    private String lastLogintime;  // 上次登录时间
    private String agentName;  // 课程推荐人
    private String orderStatus;  // 课程有效状态
    private String process;  // 课程学习进度
    private String score;  // 课程得分
    private String url;  // 本订单课程页面

    // 下面是一系列的 getter 和 setter 方法，用于获取和设置各个属性的值
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String houseTitle) {
        this.nickName = houseTitle;
    }

    public String getOrderPay() {
        return orderPay;
    }

    public void setOrderPay(String housePay) {
        this.orderPay = housePay;
    }

    public String getOrderPayWay() {
        return orderPayWay;
    }

    public void setOrderPayWay(String housePayWay) {
        this.orderPayWay = housePayWay;
    }

    public String getOrderWay() {
        return orderWay;
    }

    public void setOrderWay(String rentWay) {
        this.orderWay = rentWay;
    }

    public String getCourceType() {
        return courceType;
    }

    public void setCourceType(String houseType) {
        this.courceType = houseType;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String houseArea) {
        this.studentAge = houseArea;
    }

    public String getVipGrade() {
        return vipGrade;
    }

    public void setVipGrade(String houseDecora) {
        this.vipGrade = houseDecora;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String vip_grade) {
        this.gender = vip_grade;
    }

    public String getIpCity() {
        return ipCity;
    }

    public void setIpCity(String floor) {
        this.ipCity = floor;
    }

    public String getRegistrationDays() {
        return registrationDays;
    }

    public void setRegistrationDays(String floorHeight) {
        this.registrationDays = floorHeight;
    }

    public String getCourceTeacher() {
        return courceTeacher;
    }

    public void setCourceTeacher(String houseEstate) {
        this.courceTeacher = houseEstate;
    }

    public String getarea() {
        return area;
    }

    public void setarea(String area) {
        this.area = area;
    }

    public String getCourseIntroduction() {
        return courseIntroduction;
    }

    public void setCourseIntroduction(String address) {
        this.courseIntroduction = address;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLastLogintime() {
        return lastLogintime;
    }

    public void setLastLogintime(String time) {
        this.lastLogintime = time;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String houseDisposal) {
        this.orderStatus = houseDisposal;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String houseSpot) {
        this.process = houseSpot;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String houseDesc) {
        this.score = houseDesc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @Override  // 重写父类的 toString 方法
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", orderPay='" + orderPay + '\'' +
                ", orderPayWay='" + orderPayWay + '\'' +
                ", orderWay='" + orderWay + '\'' +
                ", courceType='" + courceType + '\'' +
                ", studentAge='" + studentAge + '\'' +
                ", vipGrade='" + vipGrade + '\'' +
                ", gender='" + gender + '\'' +
                ", ipCity='" + ipCity + '\'' +
                ", registrationDays='" + registrationDays + '\'' +
                ", courceTeacher='" + courceTeacher + '\'' +
                ", area='" + area + '\'' +
                ", courseIntroduction='" + courseIntroduction + '\'' +
                ", pic='" + pic + '\'' +
                ", lastLogintime='" + lastLogintime + '\'' +
                ", agentName='" + agentName + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", process='" + process + '\'' +
                ", score='" + score + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
