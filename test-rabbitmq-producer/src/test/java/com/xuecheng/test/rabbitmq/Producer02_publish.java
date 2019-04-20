package com.xuecheng.test.rabbitmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @ClassName Producer01
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/4/6 16:38
 * @Version 1.0
 **/
public class Producer02_publish {
    private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    private static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    private static final String EXCHANGE_FANOUT_INFORM = "exchange_fanout_inform";

    public static void main(String[] args) {
        //生产者和mq 创建链接
        //通过连接工厂创建新的链接和mq建立链接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置参数
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        //设置虚拟机,一个mq服务可以设置多个虚拟机，每个虚拟机就相当于一个独立的mq
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        try {
            //建立新的链接
            connection = connectionFactory.newConnection();
            //创建会话通道，生产者和mq服务所有通信都在channal通道中完成。
            Channel channel = connection.createChannel();
            //声明队列,如果队列在mq中没有则要创建
            //参数明细，1，String queue队列名称，
            // 2.boolean durable是否持久化，如果是持久化，mq重启后，队列还在，
            // 3.boolean exclusive 是否独占链接，队列只允许在该链接中访问，如果链接关闭后，队列自动删除。如果将此参数设置为true，可用作临时队列的创建。
            //4.boolean autodelete 自动删除，队列不在使用的时候是否自动删除队列，如果将这个参数和exclusive设置为true就可以实现临时队列。不用了就自动删除了。
            //5.arguments 参数，可以设置一些队列的拓展参数。比如；存活时间，

            channel.queueDeclare(QUEUE_INFORM_EMAIL, true, false, false, null);
            channel.queueDeclare(QUEUE_INFORM_SMS, true, false, false, null);

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
            channel.queueBind(QUEUE_INFORM_SMS, EXCHANGE_FANOUT_INFORM, "");


            //
            //参数明细
            //1.exchange,交换机，如果不指定默认使用mq的默认交换机，
            // 2、routingKey ，路由key交换机根据路由key来将消息转发到指定的队列，如果使用默认交换机， routingKey设置为队列的名称。
            // 3、props 消息的属性，
            // 4、boby消息内容
            //消息内容

            for (int i = 0; i < 5; i++) {
                String message = "send inform message";
                channel.basicPublish(EXCHANGE_FANOUT_INFORM, "", null, message.getBytes());
                System.out.println("sned message to mq" + message);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭连接


        }

    }
}
