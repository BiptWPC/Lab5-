# Lab5-
第五次作业

## 实验目的
掌握字符串String及其方法的使用
掌握文件的读取/写入方法
掌握异常处理结构


## 实验内容
设计学生类；
采用交互式方式实例化某学生；
设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。 对于下列文本
每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”
允许提供输入参数，统计古诗中某个字或词出现的次数
输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A
考虑操作中可能出现的异常，在程序中设计异常处理程序


  
## 实验过程
# 实验思路
设计思路

断句功能：通过read类读取文本内容，对字符计数，7奇偶倍数分别加逗号句号然后写入文本。 查字功能：逐个读取字符与要查询字符比对计数。 
查词功能：逐行读取文本，在每行总搜索是否出现某词语，出现则进行计数。 运用多线程：本程序不太需要多线程，但为了运用多线程，强行添加一个多线程实现查词功能。



## 核心方法
实现断句功能

  int n = -1;
            int i = 0;
            byte [] a = new byte[100];
            File f = new File("src\\Experience1\\changhenge.txt");
            FileInputStream in = new FileInputStream(f);
            File targetFile = new File("src\\Experience1\\B.txt");
            Writer out = new FileWriter(targetFile,true);
            out.append(li.toString());
            System.out.println(li.toString());
            out.flush();
            while((n = in.read(a,0,2)) != -1){
                String s = new String (a,0,n);
                i++;
                out.write(s);
                out.flush();
                if(i%7 == 0 && i%14 != 0){
                    //out.write(s);
                    out.append("，");
                    out.flush();
                }

                else if(i%14 == 0){
                    out.append("。\n");
                    //out.write(s);
                    out.flush();
                }
                else{
                    //out.write(s);
                    out.flush();
                }
            }

            in.close();

实现创建多线程，实现查词功能。

//创建多线程的类
public class MultiThread extends Thread {
    //定义此线程查词功能的方法
    public static boolean Containstr(String s1, String s2) {
        if (s1.indexOf(s2) >= 0) {
            return true;

        } else {
            return false;
        }
    }
    //实现查找字词的主要方法
    public static void strfind(String file){
        File f = new File(file);
        int m = 0;
        try
        {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            List<String> list = new ArrayList<String>();
            String str = null;
            //int num = 1;
            while ((str = br.readLine()) != null)
            {
                list.add(str);
            }
            System.out.println("请输入查找的字词");
            Scanner sc = new Scanner(System.in);
            String strword = sc.nextLine();
            for (String s : list)
            {
                boolean b = Containstr(s, strword);
                if (b)
                {
                    //System.out.println(num + ":" + s);
                    m++;
                }
                //num++;
            }
            System.out.println("出现\""+strword+"\" 的次数是："+m);

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }


    //重写的是父类Thread的run()
    public void run(String file) {
        strfind(file);
    }
}

//学生管理的接口，定义学生必须要有的方法
interface StudentManage {
    void setfee(int fee);
    int getfee();
}


## 实验结果


## 实验感想
经过这么多次实验，我理解了越来越多的JAVA知识，其中类与方法接触是最多的，虽然总体上这些不是很难，但要熟练应用的话，这需要大量的练习再加上学习其他人的设计思路以及参考别人的代码的长处，我想自己的JAVA学习之路还很长，自己还有很多东西没有完全理解，自己设计的实验程序仍停留在模仿阶段，不过我相信只要在接下来的学习过程更加专注勤奋，就能获得进步与收获。
