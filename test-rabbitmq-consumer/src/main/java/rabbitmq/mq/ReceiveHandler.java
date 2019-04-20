package rabbitmq.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.config.RabbitmqConfig;


/**
 * @ClassName ReceiveHandler
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/4/7 16:17
 * @Version 1.0
 **/
@Component
public class ReceiveHandler {
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
    public void send_email(String msg, Message message , Channel channel){
        System.out.println("receive message"+msg);
    }

}
