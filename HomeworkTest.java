package exp4;
import java.util.Scanner;
import java.io.*;

public class HomeworkTest {
	public static void main(String args[]) {
        Basic student = new Basic();
        System.out.println("请依次输入姓名,性别,年龄,学号");
        Scanner stu = new Scanner(System.in);
        String name = stu.nextLine();
        String sex = stu.nextLine();
        int age = stu.nextInt();
        int number = stu.nextInt();
        student.setBasic(name, sex, age, number);
        try {
            FileReader fileReader = new FileReader("D:\\长恨歌.txt");//读取D盘文件
            BufferedReader bufferedReader = new BufferedReader(fileReader);//把文件存到缓冲区
            Writer writer = new FileWriter(new File("D:\\A.txt"));//将缓冲区文件写入A文件中
            String str = bufferedReader.readLine();
            String regex = "(.{7})";
            str = str.replaceAll(regex, "$1，");
            StringBuffer x = new StringBuffer(str);
            for (int  i = 15; i <289; i = i + 17) {
                x.replace(i, i + 1, "。\n");
            }
            System.out.println(x);
            writer.write(String.valueOf(student));
            writer.write("\n");
            writer.write(String.valueOf(x));
            bufferedReader.close();//关闭缓冲区
            fileReader.close();//关闭文件读取
            writer.close();//关闭写入

            a:
            while (true) {
                System.out.println("输入1或者2选择查询字和词或者退出");
                Scanner in = new Scanner(System.in);
                int nu = in.nextInt();
                switch (nu) {
                    case 1:
                        Scanner y = new Scanner(System.in);
                        System.out.println("请输入想要查询的字:");
                        String c = y.nextLine();
                        int count = (str.length() - str.replace(c, "").length()) / c.length(); 
                        System.out.println(count);
                        break;
                    case 2:
                        System.out.println("退出");
                        break a;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("出现错误!");
        }
    }
}
