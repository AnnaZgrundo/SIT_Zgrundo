/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author ko
 */
@MessageDriven(mappedName = "jms/Topic", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})

public class SimpleMessageBean implements MessageListener {
    
    @Resource 
    private MessageDrivenContext mdc;
    
    static final Logger logger = Logger.getLogger("SimpleMessageBean");
    
    public SimpleMessageBean() {
    }    
    
    List<String> list = new ArrayList<String>();
    
    @Override
    public void onMessage(Message inMessage) {
        TextMessage msg = null;
        String mess = inMessage.toString();
        
        boolean flag = false;
        try {
            msg = (TextMessage) inMessage;
            if (msg.getText().equals("*")) {               

                if (inMessage instanceof TextMessage) {
                    msg = (TextMessage) inMessage;
                    logger.info("MESSAGE BEAN: Message received: " + msg.getText());
                    PrintWriter writer;
                    try {
                        writer = new PrintWriter("//Users//J_Joke//Desktop//lab//1.txt");
                        //writer = new FileWriter("F:\\lab\\1.txt", true);
                        int min = 100, max = -1, k;
                        boolean fl1 = false, fl2 = false;
                        String minString = null, maxString = null;
                        char a;
                        for(String str : list){
                            k = 0;
                            for (int i = 0; i < str.length(); i++)
                            {
                                a = str.charAt(i);
                                if (a == 'a' || a == 'A' || a == 'e' || a == 'E' || a == 'y' || a == 'Y' || a == 'u' || a == 'U' 
                                        || a == 'o' || a == 'O' || a == 'i' || a == 'I') { k++;}                        
                            }
                            if (min == k) { fl1 = true; }
                            if (min == k) { fl2 = true; }
                            if (min > k){ min = k; minString = str; }
                            if (max < k){ max = k; maxString = str; }                            
                        } 
                        if (fl1) {
                            writer.println("MIN: ");
                            for (String str : list) {
                                k = 0;
                                for (int i = 0; i < str.length(); i++) {
                                    a = str.charAt(i);
                                    if (a == 'a' || a == 'A' || a == 'e' || a == 'E' || a == 'y' || a == 'Y' || a == 'u' || a == 'U'
                                            || a == 'o' || a == 'O' || a == 'i' || a == 'I') { k++; }
                                }
                                if (min == k) { minString = str; writer.println(minString + " - " + min); }
                            }
                        }
                        if (fl2) {
                            writer.println("\n");
                            writer.println("MAX: ");
                            for (String str : list) {
                                k = 0;
                                for (int i = 0; i < str.length(); i++) {
                                    a = str.charAt(i);
                                    if (a == 'a' || a == 'A' || a == 'e' || a == 'E' || a == 'y' || a == 'Y' || a == 'u' || a == 'U'
                                            || a == 'o' || a == 'O' || a == 'i' || a == 'I') { k++; }
                                }
                                if (max == k) { maxString = str; writer.println(maxString + " - " + max); }
                            }
                        }
                        else {
                            writer.println("MIN: " + minString + " - " + min);
                            System.out.println(minString+""+maxString);
                            writer.println("\n");
                            writer.println("MAX: " + maxString + " - " + max);
                        }
                        writer.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Ошибка открытия файла!");
                    }
                } else {
                    logger.warning("Message of wrong type: " + inMessage.getClass().getName());
                }
            }
            else list.add(msg.getText() + "\n");
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
}