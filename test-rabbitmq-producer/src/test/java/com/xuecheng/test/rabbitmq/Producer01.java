package com.xuecheng.test.rabbitmq;

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
public class Producer01 {
    private static final String QUEUE = "helloworld";
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
            channel.queueDeclare(QUEUE,true,false,false,null);
            //参数明细
            //1.exchange,交换机，如果不指定默认使用mq的默认交换机，
            // 2、routingKey ，路由key交换机根据路由key来将消息转发到指定的队列，如果使用默认交换机， routingKey设置为队列的名称。
            // 3、props 消息的属性，
            // 4、boby消息内容
            //消息内容
            String message = "hello world";
            channel.basicPublish("", QUEUE,null,message.getBytes());
            System.out.println("sned message to mq"+ message);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭连接



        }

    }
}
