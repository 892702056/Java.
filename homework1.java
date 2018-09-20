package homework;

import java.util.Scanner;//引入这个包  可以调用Scanner对象 

/**
 * @author 施展 软工11601 
 * @time  9.20
 *
 */

class car{
	/*
	 * 定义四个私有属性 ，type 为字符串类型用于存放车辆名称;
	 * tank 整型 存放汽车油箱数量；
	 * OilCouter 浮点型 记录车辆每小时耗油量；
	 * myCaocaity 浮点型 记录车辆的油量剩余量；
	 *  CAPACITY 为全局静态变量 数值无法改变，用于记录一个油箱的存有总量；
	 * */
	private String type;
	private int tank;
	private double OilCounter;
	private double myCaoacity;
	public static final int CAPACITY=50;
	
	
	/* 在构造函数中，给成类成员属性赋值，并且根据输入的油箱数量得到 总油量的数值
	 * @param type 车辆名称 tank 油箱数量 OilCounter 每小时耗油量
	 * @return 构造函数 无返回值
	 * */
	public car(String type,int tank,double OilCounter) {
		this.type=type;
		this.tank=tank;
		this.OilCounter=OilCounter;
		this.myCaoacity=CAPACITY*this.tank;
	}
	/*
	 * 构造无参构造函数，使用java的输入函数，用键盘键入属性值；
	 * */
	public car () {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入车型");
		this.type=scanner.next();
		System.out.println("请输入车油箱数");
		this.tank=scanner.nextInt();
		System.out.println("请输入车油耗量");
		this.OilCounter=scanner.nextDouble();
		this.myCaoacity=CAPACITY*this.tank;
		}
	/*
	 * 该函数的作用是 给油箱加满油，则属性myCaoacity属性值重新回归构造函数时的数值；
	 * */
	public void gas() {
		System.out.println("油装满了");
		this.myCaoacity=CAPACITY*this.tank;
	}
	
	/*
	 * @param time 时间 
	 * @return 如果返回true 则说明油箱有油，返回false 则油箱已经空
	 * 
	 * */
	private boolean isEnough(double time) {
		if(this.myCaoacity>=time*this.OilCounter) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * Oil()函数的作用是返回当前类实例的剩余油量；
	 * */
	public void Oil() {
		 System.out.println(this.myCaoacity);
		
	}
	
	/*
	 * @param time 时间
	 * 首先判断 该时间下，剩余油量是否足够 ，若为true 则输出 时间 剩余油量和消耗量 若为false 则输出剩余油量可以行使的时间;
	 * 
	 * */
	public void run(double time) {
		if(this.isEnough(time)) {
			this.myCaoacity=this.myCaoacity-time*this.OilCounter;
			  System.out.println( "行驶了"+time+"小时共消耗"+(time*this.OilCounter)+"L油,还剩"+this.myCaoacity+"L油");
		}else {
			System.out.println("骑车只能行驶"+(this.myCaoacity/this.OilCounter)+"小时");
		}
	}
	/*
	 *  该函数可以输出类对象的基本属性；
	 * */
	public void show() {
		System.out.println("这款汽车的名字是:"+this.type+"\t有"+this.tank+"个油箱\t每小时油耗为："+this.OilCounter+"L");
	}
	
}


public class test1 {
    public static void main(String []args) {
         
    	car car1=new car("奔驰",2,20);
    	car car2=new car("宝马",3,25);
    	car car3=new car("路虎",4,30);
    	car car4=new car();//键盘输入属性值
    	car1.show();
    	car2.show();
    	car3.show();
    	car4.show();
    	car1.run(2);
    	car2.run(5);
    	car1.gas();
    	car1.Oil();
    }
}
/*
 * 该程序输出的结果为:
 * 这款汽车的名字是:奔驰	有2个油箱	每小时油耗为：20.0L
  这款汽车的名字是:宝马	有3个油箱	每小时油耗为：25.0L
  这款汽车的名字是:路虎	有4个油箱	每小时油耗为：30.0L
  这款汽车的名字是:捷豹	有2个油箱	每小时油耗为：10.0L
行驶了2.0小时共消耗40.0L油,还剩60.0L油
行驶了5.0小时共消耗125.0L油,还剩25.0L油
油装满了
100.0

 * 
 * 
 * */
