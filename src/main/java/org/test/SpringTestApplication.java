package org.test;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.test.domain.Student;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class SpringTestApplication {

    public static void main(String[] args) {
        ThreadLocal<Object> tl = new ThreadLocal<>();
        tl.set("");
        tl.get();
        InheritableThreadLocal<Object> itl = new InheritableThreadLocal<>();
        SpringApplication.run(SpringTestApplication.class, args);
//        List<Student> studentsList = Arrays.asList(new Student("张三", "数学", 99), new Student("张三", "语文", 12),
//                new Student("李四", "数学", 121), new Student("李四", "语文", 33));
//        Map<String,Integer> map=new HashMap<>();
//        studentsList.forEach(student -> map.merge(student.getName(),student.getScore(),(oldValue,newValue)->oldValue+newValue));
//        System.out.println(map);
        String path="C:\\Users\\魏海球\\Desktop\\DG-CW-BB-01-05（采购管理-审计工作底稿） - 副本222.doc";
//        try {
//            // 读取doc文件
//            FileInputStream fis = new FileInputStream(new File(path));
//            WordExtractor extractor = new WordExtractor(fis);
//            // 将doc文件转换成文本文件
//            String text = extractor.getText();
//            FileWriter fw = new FileWriter(new File("C:\\Users\\魏海球\\Desktop\\DG-CW-BB-01-05（采购管理-审计工作底稿） - 副本222.txt"));
//            fw.write(text);
//            fw.close();
//
//            // 关闭文件输入流
//            fis.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        try {
            // 读取文本文件
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\魏海球\\Desktop\\DG-CW-BB-01-05（采购管理-审计工作底稿） - 副本222.txt"), StandardCharsets.UTF_8));

            // 定义正则表达式
            /**
             * \s* 匹配任意空白字符（包括空格、制表符等）0次或多次；
             * (.*?) 匹配任意字符0次或多次，非贪婪模式，即尽可能少地匹配，以便后续匹配能够成功；
             * 这段代码使用了Java中的正则表达式模块，编译了一个正则表达式模式，该模式可以匹配一个包含特定格式的字符串，并从中提取出日期、索引号、审计项目、被审计单位、审计事项、审计内容、附件、问题分类、政策依据、审计结论及处理意见、建议、被审计单位核实情况记录、编制人、小组长、主审和组长等信息。
             *
             * 具体来说，该正则表达式模式中的各个部分含义如下：
             *
             * "日期：\s*(.?)\s"：匹配以"日期："开头的字符串，后面跟着任意数量的空格和任意非空白字符（日期信息），并将日期信息保存到第1个捕获组中；
             * "索引号：\s*(.?)\s"：匹配以"索引号："开头的字符串，后面跟着任意数量的空格和任意非空白字符（索引号信息），并将索引号信息保存到第2个捕获组中；
             * "审计项目\s*(.?)\s"：匹配以"审计项目"开头的字符串，后面跟着任意数量的空格和任意非空白字符（审计项目信息），并将审计项目信息保存到第3个捕获组中；
             * "被审计单位\s*(.?)\s"：匹配以"被审计单位"开头的字符串，后面跟着任意数量的空格和任意非空白字符（被审计单位信息），并将被审计单位信息保存到第4个捕获组中；
             * "审计事项\s*(.?)\s"：匹配以"审计事项"开头的字符串，后面跟着任意数量的空格和任意非空白字符（审计事项信息），并将审计事项信息保存到第5个捕获组中；
             * "审\n计\n内\n容\s*(.?)\s"：匹配以"审\n计\n内\n容"开头的字符串，后面跟着任意数量的空格和任意非空白字符（审计内容信息），并将审计内容信息保存到第6个捕获组中；.............以此类推
             */
            Pattern pattern = Pattern.compile("日期：\\s*(.*?)\\s*索引号：\\s*(.*?)\\s*审计项目\\s*(.*?)\\s*被审计单位\\s*(.*?)\\s*审计事项\\s*(.*?)\\s*审\n计\n内\n容\\s*(.*?)\\s*附件\\s*(.*?)\\s*问题分类\\s*(.*?)\n政策依据:\\s*(.*?)\\s*审计结论及处理意见、建议：\\s*(.*?)\\s*被审计单位核实情况记录\\s*(.*?)\\s*编制人：\\s*(.*?)\\s*小组长：\\s*(.*?)\\s*主\\s+审：\\s*(.*?)\\s*组\\s+长：\\s*(.*?)\\s*");

            // 提取信息
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String content = sb.toString();
            System.out.println(content);
            Matcher matcher = pattern.matcher(content);
            if (matcher.find()) {
                String date = matcher.group(1);
                String index = matcher.group(2);
                String project = matcher.group(3);
                String unit = matcher.group(4);
                String auditItem = matcher.group(5);
                String auditContent = matcher.group(6);
                String attachment = matcher.group(7);
                String problemType = matcher.group(8);
                String policyBasis = matcher.group(9);
                String conclusion = matcher.group(10);
                String verification = matcher.group(11);
                String author = matcher.group(12);
                String groupLeader = matcher.group(13);
                String mainAuditor = matcher.group(14);
                String teamLeader = matcher.group(15);
                // 打印提取的信息
                System.out.println("日期：" + date);
                System.out.println("索引号：" + index);
                System.out.println("审计项目：" + project);
                System.out.println("被审计单位：" + unit);
                System.out.println("审计事项：" + auditItem);
                System.out.println("审计内容：" + auditContent);
                System.out.println("附件：" + attachment);
                System.out.println("问题分类：" + problemType);
                System.out.println("政策依据：" + policyBasis);
                System.out.println("审计结论及处理意见、建议：" + conclusion);
                System.out.println("被审计单位核实情况记录：" + verification);
                System.out.println("编制人：" + author);
                System.out.println("小组长：" + groupLeader);
                System.out.println("主审：" + mainAuditor);
                System.out.println("组长：" + teamLeader);

            }

} catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
