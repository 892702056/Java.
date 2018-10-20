package homework;


/*引入键盘输入包*/
import java.util.Scanner;

/*普通宾客的接口 有三个抽象方法 吃 住 行*/
interface rece{
   public abstract void Eat();
   public abstract void Stay();
   public abstract void Trip();
}
/*
 * 高级宾客接口 加入一个抽象方法 礼物
 * */
interface guibing{
	public abstract void Present();
}


/*
 * 抽象类receipt 实现 普通接口
 * */
abstract class receipt implements rece{
	
	public final double StandardRoomPrice=300.0;//豪华标间价格
	public final double DeluxRoomPrice=180;//标准间价格
	public final double CommonFoodPrice=20.0;//普通食物价格
	public final double GoodFoodPrice=40.0;//优质食物
	public final double PresidentialPrice=500.0;//总统套房价格
	public double EatPrice;//吃方面花的钱
	public double StayPrice;//住方面花的钱
	public double TripPrice;//行方面花的钱
	public int StayDays;//停留天数
	public double AllPrice;//所有的花费
	public int grade;//等级 这个属性是对应在高级宾客上的
	public abstract void show();//抽象方法 输出花费的总金额

}

/*实例类 大学生 继承抽象类*/
class Undergraduate extends receipt{
	/*
	 * 构造函数 
	 * @param int days 停留天数 String begin 出发的始发地 String terminus 目的地
	 * 
	 * */
	public Undergraduate(int days,String begin,String terminus) {
		check che=new check();
		
		this.StayPrice=DeluxRoomPrice;
		this.EatPrice=CommonFoodPrice;
		this.StayDays=days;
		check che1=new check();//创建一个check 实例对象 这个check对象在本包中的transport类中
		this.TripPrice=che1.checking(begin, terminus)*trans.CarPrice;//行花的费的钱等于 两地之间的距离*该交通工具的费用

	}
	
	@Override
	/*实现抽象方法*/
	public void Eat() {
		// TODO Auto-generated method stub
		System.out.println("为学生提供普通食物");
		System.out.println("学生"+this.StayDays+"天在吃方面需要花费"+(this.EatPrice*this.StayDays)+"元");
		
	}

	@Override
	/*实现抽象方法*/
	public void Stay() {
		// TODO Auto-generated method stub
		System.out.println("为学生提供标准间");
		System.out.println("学生"+this.StayDays+"天在住宿方面需要花费"+(this.StayPrice*this.StayDays)+"元");
		
	}

	@Override
	/*实现抽象方法*/
	public void Trip() {
		// TODO Auto-generated method stub
		System.out.println("为学生提供汽车往返");
		System.out.println("学生"+this.StayDays+"天在住宿方面需要花费"+(this.TripPrice*2)+"元");
		
	}

	@Override
	/*实现抽象方法*/
	public void show() {
		// TODO Auto-generated method stub
		this.AllPrice=this.StayDays*(this.StayPrice+this.EatPrice)+this.TripPrice*2;
		System.out.println("这个学生在这"+this.StayDays+"天总共花费"+this.AllPrice+"元");
		
	}

	
}


class Teacher  extends receipt{
	
	
	public  Teacher(int days,String begin,String terminus) {
		this.EatPrice=this.GoodFoodPrice;
		this.StayPrice=this.StandardRoomPrice;
		this.StayDays=days;
		check che2=new check();
		this.TripPrice=che2.checking(begin, terminus)*trans.TrainPrice;//老师对应的交通工具是火车

	}
	@Override
	/*实现抽象方法*/
	public void Eat() {
		System.out.println("为老师提供优质食物");
		System.out.println("老师"+this.StayDays+"天在吃方面需要花费"+(this.EatPrice*this.StayDays)+"元");
		
	}

	@Override
	/*实现抽象方法*/
	public void Stay() {
		// TODO Auto-generated method stub
		System.out.println("为老师提供豪华标准间");
		System.out.println("老师"+this.StayDays+"天在住宿方面需要花费"+(this.StayPrice*this.StayDays)+"元");
		
	}

	@Override
	/*实现抽象方法*/
	public void Trip() {
		// TODO Auto-generated method stub
		System.out.println("为老师提供火车往返");
		System.out.println("老师"+this.StayDays+"天在住宿方面需要花费"+(this.TripPrice*2)+"元");
		
	}

	@Override
	/*实现抽象方法*/
	public void show() {
		// TODO Auto-generated method stub
		this.AllPrice=this.StayDays*(this.StayPrice+this.EatPrice)+this.TripPrice*2;
		System.out.println("这个老师在这"+this.StayDays+"天总共花费"+this.AllPrice+"元");
		
	}
	
}

class Patriarch extends receipt{
	
		
	public  Patriarch(int days,String begin,String terminus) {
		this.EatPrice=this.CommonFoodPrice;
		this.StayPrice=this.StandardRoomPrice;
		this.StayDays=days;
		check che=new check();
		this.TripPrice=che.checking(begin, terminus)*trans.TrainPrice;//家长对应的交通工具是火车

	} 
	@Override
	public void Eat() {
		System.out.println("为家长提供普通食物");
		System.out.println("家长"+this.StayDays+"天在吃方面需要花费"+(this.EatPrice*this.StayDays)+"元");
		
	}

	@Override
	/*实现抽象方法*/
	public void Stay() {
		// TODO Auto-generated method stub
		System.out.println("为家长提供豪华标准间");
		System.out.println("家长"+this.StayDays+"天在住宿方面需要花费"+(this.StayPrice*this.StayDays)+"元");
		
	}

	@Override
	/*实现抽象方法*/
	public void Trip() {
		// TODO Auto-generated method stub
		System.out.println("为家长提供火车往返");
		System.out.println("家长"+this.StayDays+"天在住宿方面需要花费"+(this.TripPrice*2)+"元");
		
	}

	@Override
	/*实现抽象方法*/
	public void show() {
		// TODO Auto-generated method stub
		this.AllPrice=this.StayDays*(this.StayPrice+this.EatPrice)+this.TripPrice*2;
		System.out.println("这个家长在这"+this.StayDays+"天总共花费"+this.AllPrice+"元");
		
	}
	
}
/*高级宾客 领导先继承 receipt 再实现接口guibing*/
class Leader  extends receipt implements guibing{
	
	double PresentPrice;//定义一个浮点类型的礼物属性
	/*
	 * 这里的构造函数比上面的普通宾客多了一个grade 等级参数 用来传入该领导或外宾的等级 来确定其的礼物价格
	 * 
	 * */
	public Leader(int days,int grade,String begin,String terminus){
		this.EatPrice=this.GoodFoodPrice;
		this.StayPrice=this.PresidentialPrice;
		this.StayDays=days;
		this.grade=grade;
		check che4=new check();
		this.TripPrice=che4.checking(begin, terminus)*trans.PlanePrice;//领导使用的飞机
		
	}
	@Override
	public void Eat() {
		// TODO Auto-generated method stub
		System.out.println("为领导提供优质食物");
		System.out.println("领导"+this.StayDays+"天在吃方面需要花费"+(this.EatPrice*this.StayDays)+"元");
		
	}

	@Override
	public void Stay() {
		// TODO Auto-generated method stub
		System.out.println("为领导提供总统套房");
		System.out.println("领导"+this.StayDays+"天在住宿方面需要花费"+(this.StayPrice*this.StayDays)+"元");
		
	}

	@Override
	public void Trip() {
		// TODO Auto-generated method stub
		System.out.println("为领导提供飞机往返");
		System.out.println("领导"+this.StayDays+"天在行程方面需要花费"+(this.TripPrice*2)+"元");
		
	}

	@Override
	public void Present() {
		// TODO Auto-generated method stub
		switch (this.grade) {
		case 1:
			this.PresentPrice=2000;
			break;
		case 2:
			this.PresentPrice=4000;
			break;
		case 3:
			this.PresentPrice=6000;
			break;
		default:
			System.out.println("输入有误！");
			break;
		}
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.Present();
		this.AllPrice=this.StayDays*(this.StayPrice+this.EatPrice)+this.TripPrice*2+this.PresentPrice;
		System.out.println("这个领导在这"+this.StayDays+"天总共花费"+this.AllPrice+"元");
		
	}
	
}

class Foreign extends receipt implements guibing{
	double PresentPrice;
	
	public Foreign(int days,int grade,String begin,String terminus){
		this.EatPrice=this.GoodFoodPrice;
		this.StayPrice=this.PresidentialPrice;
		this.StayDays=days;
		this.grade=grade;
		check che=new check();
		this.TripPrice=che.checking(begin, terminus)*trans.PlanePrice;
		
	}
	@Override
	public void Eat() {
		// TODO Auto-generated method stub
		System.out.println("为外宾提供优质食物");
		System.out.println("外宾"+this.StayDays+"天在吃方面需要花费"+(this.EatPrice*this.StayDays)+"元");
		
	}

	@Override
	public void Stay() {
		// TODO Auto-generated method stub
		System.out.println("为外宾提供总统套房");
		System.out.println("外宾"+this.StayDays+"天在住宿方面需要花费"+(this.StayPrice*this.StayDays)+"元");
		
	}

	@Override
	public void Trip() {
		// TODO Auto-generated method stub
		System.out.println("为外宾提供飞机往返");
		System.out.println("外宾"+this.StayDays+"天在行程方面需要花费"+(this.TripPrice*2)+"元");
		
	}

	@Override
	public void Present() {
		// TODO Auto-generated method stub
		switch (this.grade) {
		case 1:
			this.PresentPrice=4000;
			break;
		case 2:
			this.PresentPrice=6000;
			break;
		case 3:
			this.PresentPrice=8000;
			break;
		default:
			System.out.println("输入有误！");
			break;
		}
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.Present();
		this.AllPrice=this.StayDays*(this.StayPrice+this.EatPrice)+this.TripPrice*2+this.PresentPrice;
		System.out.println("这个外宾在这"+this.StayDays+"天总共花费"+this.AllPrice+"元");
		
	}
	
}

/*
 *操作类 Operate1 
 *在这个类中 我们可以对上面的类进行操作
 * */
class Operate1{
	public	String name;//查询的类别
	public	double distance;//两地的距离
	public	int days;//停留的天数
	public	String begin;//始发地
	public	String terminus;//目的地
	public	int grades;//等级
	public	int n;//控制参数 1为普通宾客2为高级宾客
	
	
	public 	Operate1(String name) {
		System.out.println(name);
		switch (name) {
		case "大学生":
			this.write(1);
			Undergraduate gra=new Undergraduate(this.days,this.begin,this.terminus);
			gra.show();
			break;
		case "老师":
			this.write(1);
			Teacher tea=new Teacher(this.days,this.begin,this.terminus);
			tea.show();
			break;
		case"家长":
			this.write(1);
			Patriarch pat=new Patriarch(this.days,this.begin,this.terminus);
			pat.show();
			break;
		case "领导":
			this.write(2);
			Leader lead=new Leader(this.days,this.grades,this.begin,this.terminus);
			lead.show();
			break;
		case "外宾":
			this.write(2);
			Foreign foreign = new Foreign(this.days,this.grades,this.begin,this.terminus);
			foreign.show();
			break;
					
		default:
			System.out.println("输入错误!");
			break;
		}
	}
	/*信息写入方法 ，讲需要的参数写入类中属性中*/
	public void write(int n) {
		if(n==1) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入停留天数");
			int d=scanner.nextInt();
			this.days=d;
			System.out.println("请输入始发地");
			String b=scanner.next();
			this.begin=b;
			System.out.println("请输入目的地");
			String t=scanner.next();
			this.terminus=t;
		}else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入停留天数");
			int d=scanner.nextInt();
			this.days=d;
			System.out.println("请输入他的等级");
			int g=scanner.nextInt();
			this.grades=g;
			System.out.println("请输入始发地");
			String b=scanner.next();
			this.begin=b;
			System.out.println("请输入目的地");
			String t=scanner.next();
			this.terminus=t;
		}
	}
	
	
}



public class reception {
	public static void main(String[]args){
		System.out.println("请输入想查询的类别");
		Scanner scanner = new Scanner(System.in);
		String name=scanner.next();
		Operate1 ope=new Operate1(name);
	}
	
}
/*
 * 请输入想查询的类别
外宾
请输入停留天数
3
请输入他的等级
2
请输入始发地
北京
请输入目的地
广州
这个外宾在这3天总共花费10920.0元

 * 
 * 
 * */

