package  com.xuecheng.govern.center;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName GovernCenterApplication
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/4/13 15:15
 * @Version 1.0
 **/
@EnableEurekaServer
@SpringBootApplication
public class GovernCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(GovernCenterApplication.class,args);
    }
}
