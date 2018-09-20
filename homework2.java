package homework;
import java.util.*;//引入这个包才能调用java的输入方法；

class game{
	/*
	 * 定义两个私有属性 String类name 为玩家姓名;
	 *          int类grade 为玩家分数;
	 * */
	private String name;
	private int grade;
	Scanner scanner1=new Scanner(System.in);
	/**
	 * 
	 */
	/*
	 * 无参构造函数，在构造函数内部用java输入的方式给属性赋值,并且给每个玩家的grade赋初值为0;
	 * 
	 * 
	 * */
	public game() {
		
	    System.out.println("请输入玩家姓名");
	    this.name=scanner1.next();
	    this.grade=0;
	}
	/*
	 *      实现猜数游戏的主方法：
	 *  首先实现生成随机数方法， 方法为：Math.random()这个方法可以生成0.0~1.0之间的小数，所以要*10给范围放大十倍，范围从0~10取不到10  我们猜数字 只猜整数，所以要
	 *  强制转换成int类型 再加上+使得范围成为1~10;
	 *  第二步就是判断随机与玩家输入的数是否相同
	 * 
	 * */
	public void play() {
		int ranDomNum=1+(int)(Math.random()*10);
		Scanner scanner2=new Scanner(System.in);
		int num=scanner2.nextInt();
		if(num==ranDomNum) {
			System.out.println("这个随机数是"+ranDomNum+"\n恭喜你猜对了");
			this.Grade(true);
		}else {
			System.out.println("这个随机数是"+ranDomNum+"\n很遗憾你猜错了");
			this.Grade(false);
		}
	}
	/*
	 * 本方法的作用为 根据猜数字的情况给玩家的分数进行控制，猜对加分 猜错不加分；
	 * */
	public void Grade(boolean a) {
		if(a) {
			this.grade++;
		}/*else {
			if(this.grade>0) {
				this.grade--;
			}else {
				this.grade=this.grade;
			}
		}*/
	}
	/*
	 * 输出函数 输出玩家姓名和当前分数；
	 * */
	public void show() {
		System.out.println("姓名:"+this.name+"\t 您的分数为:"+this.grade);
	}
	
	
}





public class test2 {
   public static void main(String []args) {
	   Scanner scanner = new Scanner(System.in);
	   int personNum=0;//定义玩家数量
	   int num=0;//定义游戏轮数
	  
	   System.out.println("请输入参与游戏的玩家");
	   personNum = scanner.nextInt();
	   System.out.println("请输入游戏的轮数"); 
	   num=scanner.nextInt();
	   
	   
	   game []array=new game[personNum];//创建一个game数组实例，存放每一个game类实例
	   for(int i=0;i<personNum;i++) {
		   array[i]=new game();//实例化
	   }
	 
	  for(int i=0;i<num;i++) {
		  for(int j=0;j<personNum;j++) {
			  array[j].play();
		}
		System.out.println("第"+(i+1)+"轮结束！");  
	  }
	  for(int i=0;i<personNum;i++) {
		   array[i].show();
	   }
	  
	  
	}
}
