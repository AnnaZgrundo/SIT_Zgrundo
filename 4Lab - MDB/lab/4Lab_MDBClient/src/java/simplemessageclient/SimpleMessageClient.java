/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemessageclient;

import java.util.ArrayList;
import java.util.Scanner;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 *
 * @author ko
 */
public class SimpleMessageClient {

    /**
     * @param args the command line arguments
     */
    @Resource (mappedName = "jms/Topic")
    private static Topic topic;
    
    @Resource (mappedName = "jms/ConnectionFactory")
    private static ConnectionFactory connectionFactory;
  
    public static void main(String[] args) throws JMSException {
        // TODO code application logic here
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(topic);
    
        TextMessage message = session.createTextMessage();

        boolean q = true;
        while (q) {
            System.out.print("Введите строку (для окончания ввода нажмите '*': ");
            Scanner scanner = new Scanner(System.in);
            String mess = scanner.next();
            if (mess.equals("*")) {
                q=false;  
            }
            message.setText(mess);
            messageProducer.send(message);
        }
    }
}