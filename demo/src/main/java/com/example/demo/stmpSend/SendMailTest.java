package com.example.demo.stmpSend;

import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.io.*;
import java.util.*;

public class SendMailTest {
    private static final String username="username";
    private static final String password="password";

    public static void main(String[] args) throws MessagingException, IOException {

        Map<String,String> map= new HashMap<>();


            //暂时未成功，需要调试
        /*SendMail mail = new SendMail("14789****@sina.cn","***miya");
        map.put("mail.smtp.host", "smtp.sina.com");*/
        /*
        *
        * mail.transport.protocol=smtp
mail.smtp.host=smtp.qq.com
mail.smtp.port=465
mail.smtp.auth=true
mail.smtp.timeout=60000

mail.smtp.socketFactory.port=465
mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory

username=970157939@qq.com
password=fthejzuxmtlgbbde*/

        InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream("/mail.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        Properties properties= MailConfig.readProperties(new File("F:\\zip\\mybatisplus-spring-mvc\\src\\main\\resources\\mail.properties"));

        PropertiesGetUtils pgu=new PropertiesGetUtils(properties);
        SendMail mail = new SendMail(pgu.getTypeFromPropStr(username),pgu.getTypeFromPropStr(password));
        map.put("mail.smtp.host", properties.getProperty("mail.smtp.host"));
        map.put("mail.smtp.auth", properties.getProperty("mail.smtp.auth"));

        map.put("mail.transport.protocol", properties.getProperty("mail.transport.protocol"));
        map.put("mail.smtp.timeout", properties.getProperty("mail.smtp.timeout"));
        map.put("mail.smtp.socketFactory.class", properties.getProperty("mail.smtp.socketFactory.class"));
        map.put("mail.smtp.socketFactory.port", properties.getProperty("mail.smtp.socketFactory.port"));
        map.put("mail.smtp.port", properties.getProperty("mail.smtp.port"));
        mail.setPros(map);
        mail.initMessage();
            /*
             * 添加收件人有三种方法：
             * 1,单人添加(单人发送)调用setRecipient(str);发送String类型
             * 2,多人添加(群发)调用setRecipients(list);发送list集合类型
             * 3,多人添加(群发)调用setRecipients(sb);发送StringBuffer类型
             */
        List<String> list = new ArrayList<>();
        list.add(properties.getProperty("ToUserName"));
        mail.setRecipients(list);
        /*String defaultStr = "283942930@qq.com,429353942@qq.com,2355663819@qq.com,381766286@qq.com;
        StringBuffer sb = new StringBuffer();
        sb.append(defaultStr);
        sb.append(",316121113@qq.com");
        mail.setRecipients(sb);*/
        mail.setSubject("日常上下班记得打卡");
//        mail.setText("谢谢合作");
        mail.setDate(new Date());
        mail.setFrom("quartzProject");
//      mail.setMultipart("D:你你你.txt");
        mail.setContent("谢谢合作", "text/html; charset=UTF-8");
//        List<String> fileList = new ArrayList<>();
//        fileList.add("E:\\NetTongWork\\mybatis-plus.txt");
//        fileList.add("F:\\zip\\AmazeUI-2.7.2.zip");
//        fileList.add("F:\\zip\\mybatisplus-spring-mvc\\src\\main\\resources\\doc\\logback.sql");
//        fileList.add("C:\\Users\\Administrator.ZAJCCZKSNO2PB3E\\Desktop\\普惠金融.doc");
//        mail.setMultiparts(fileList);
        System.out.println(mail.sendMessage());
    }
    @Test
    public void testPropeties(){
        Properties pro=new Properties();
        try {
            pro.load(new FileInputStream(new File("F:\\zip\\mybatisplus-spring-mvc\\src\\main\\resources\\mail.properties")));

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pro);
        System.out.println(pro.getProperty("username"));
    }

    @Test
    void MailConfigTest() {
        Properties properties= MailConfig.readProperties(new File("F:\\zip\\mybatisplus-spring-mvc\\src\\main\\resources\\mail.properties"));
        System.out.println(properties.getProperty("username"));
    }
}
