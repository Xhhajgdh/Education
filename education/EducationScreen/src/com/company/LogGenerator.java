import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class LogGenerator {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/education_info?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "root";

    private Random random = new Random();

    public static void main(String[] args) {
        LogGenerator generator = new LogGenerator();
        generator.insertRandomLog();
    }

    public void insertRandomLog() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO education_info(id, nick_name, order_pay, order_pay_way, order_way, cource_type, student_age, vip_grade, gender, ip_city, cource_teacher, area, pic, last_logintime, agent_name, order_status, process, score, url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, getRandomId());
                statement.setString(2, "Fixed Nick Name");
                statement.setFloat(3, getRandomOrderPay());
                statement.setString(4, getRandomOrderPayWay());
                statement.setString(5, getRandomOrderWay());
                statement.setString(6, getRandomCourseType());
                statement.setInt(7, getRandomStudentAge());
                statement.setString(8, getRandomVIPGrade());
                statement.setString(9, getRandomGender());
                statement.setString(10, getRandomCity());
                statement.setString(11, getRandomCourseTeacher());
                statement.setString(12, getRandomArea());
                statement.setString(13, "Fixed Pic URL");
                statement.setString(14, getRandomAgentName());
                statement.setString(15, getRandomOrderStatus());
                statement.setInt(16, getRandomProcess());
                statement.setInt(17, 95);
                statement.setString(18, "Fixed URL");

                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getRandomId() {
        return random.nextInt(1000);
    }

    private float getRandomOrderPay() {
        return random.nextFloat() * 1000;
    }

    private String getRandomOrderPayWay() {
        String[] ways = {"Credit Card", "Cash", "Paypal"};
        return ways[random.nextInt(ways.length)];
    }

    private String getRandomOrderWay() {
        String[] ways = {"Online", "Offline"};
        return ways[random.nextInt(ways.length)];
    }

    private String getRandomCourseType() {
        String[] types = {"Math", "History", "Science"};
        return types[random.nextInt(types.length)];
    }

    private int getRandomStudentAge() {
        return random.nextInt(25) + 5;  // age between 5 and 30
    }

    private String getRandomVIPGrade() {
        String[] grades = {"Silver", "Gold", "Platinum"};
        return grades[random.nextInt(grades.length)];
    }

    private String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return genders[random.nextInt(genders.length)];
    }

    private String getRandomCity() {
        String[] cities = {"New York", "London", "Paris"};
        return cities[random.nextInt(cities.length)];
    }


    private String getRandomCourseTeacher() {
        String[] teachers = {"Mr. Smith", "Ms. Brown", "Dr. Green"};
        return teachers[random.nextInt(teachers.length)];
    }

    private String getRandomArea() {
        String[] areas = {"North", "South", "East", "West"};
        return areas[random.nextInt(areas.length)];
    }

    private String getRandomAgentName() {
        String[] agents = {"Agent A", "Agent B", "Agent C"};
        return agents[random.nextInt(agents.length)];
    }

    private String getRandomOrderStatus() {
        String[] statuses = {"Processing", "Completed", "Cancelled"};
        return statuses[random.nextInt(statuses.length)];
    }

    private int getRandomProcess() {
        return random.nextInt(100);
    }
}
