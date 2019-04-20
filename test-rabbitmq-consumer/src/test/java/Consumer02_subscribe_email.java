import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName Consumer02_subscribe_email
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/4/6 21:33
 * @Version 1.0
 **/
public class Consumer02_subscribe_email {

    private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    private static final String EXCHANGE_FANOUT_INFORM = "exchange_fanout_inform";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        //设置MabbitMQ所在服务器的ip和端口
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_INFORM_EMAIL, true, false, false, null);


        //声明一个交换机
        //1.String exchange 交换机名称
        //2.String type
        //fanout：对应的是publish/subscribe工作模式
        //direct：对应的是routing工作模式
        //topic 对应的是topics工作模式
        //header工作模式，对应的是header
        channel.exchangeDeclare(EXCHANGE_FANOUT_INFORM, BuiltinExchangeType.FANOUT);

        //交换机和消息队列绑定
        //参数：String queue 队列名称
        // 2。exchange 交换机的名称
        //3.routingKey 路由key,在发布订阅模式设置为空串，
        channel.queueBind(QUEUE_INFORM_EMAIL, EXCHANGE_FANOUT_INFORM, "");
        //实现消费方法
        //当接收到消息后，此方法将会被调用。
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            /**
             * @Author YaoSiyuan
             * @Description //
             * @Date 19:13 2019/4/6
             * @Param [consumerTag,消费者标签，用来标示消费者，可以在监听队列的时候设置，chanal.bacicConsumer
             *
             * envelope, 信封，可以拿到交换机，
             * properties,消息的属性
             * body ，消息的内容
             * @return void
             **/
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                //交换机
                String exchange = envelope.getExchange();
                //消息id，mq在channal中用来标示消息的id，可以用来确定消息是否接收。
                long deliveryTag = envelope.getDeliveryTag();
                //消息内容
                String message;
                message = new String(body, "UTF-8");
                System.out.println("receive message"+message);
            }
        };

        //监听队列，
        //1.String queue 队列名称
        // 2.boolean autoAck 自动回复，当消费者接收到消息后，要告诉mq消息已接受，如果将此参数设置为true表示会自动回复mq，如果设置为false，就要编程实现回复。如果不回复，消息将一直在队列中存在。
        //3. Consumer   callback 消费方法，当消费者接收到消息要执行的方法。
        channel.basicConsume(QUEUE_INFORM_EMAIL, true, defaultConsumer);


    }
}
