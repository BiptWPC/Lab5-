package exp4;

public class Basic {
	String name,sex;
	int age;
	int number;
	public void setBasic(String name,String sex,int age,int number){
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.number = number;
	}
	public String toString(){
		return "姓名:" + name + "性别:" + sex + "年龄:" + age + "学号:" + number + "\n"; 
		}
}
