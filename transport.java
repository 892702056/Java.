package homework;

import java.util.Scanner;//引入输入输出包
import java.text.DecimalFormat;//控制小数点位数的包
import java.util.Map;//
import java.util.HashMap;//两个高级类型 用于存放两地的距离和两地之间的信息

/*设置一个接口*/
interface inter{
	public abstract void show();
}

/*
 * 抽象类 trans 
 * 属性有  GoStationTime到达车站或者飞机场的时间 GetTicketTime取票时间 SecurityCheckTime安检时间  WaitingTime候车或候机时间
 * Distance两地距离 全局变量 TrainPrice CarPrice PlanePrice 记录火车 汽车 飞机的每公里费用 TrainSpeed PlaneSpeed CarSpeed 记录他们的速度
 *  
 * */
abstract  class trans implements inter{
	double GoStationTime;
	double GetTicketTime;
	double SecurityCheckTime;
	double WaitingTime;
	double Distance;
	final double TrainPrice=0.45;
	final double CarPrice=0.32;
	final double PlanePrice=0.75;
	final double TrainSpeed=300.0;
	final double PlaneSpeed=800.0;
	final double CarSpeed=130.0;
	
	/*抽象方法
	 * 他的作用是计算出在某个工具下 从始发地到终点的时间和费用
	 *  */
	public abstract String message();
	
	/*实例方法 输出抽象方法*/
	public void show() {
	   System.out.println(this.message());	
	}
  
}

/*
 * 实例类 check 
 * 静态变量 name 用于以后 输出 始发站和终点站的名字 高级静态变量 map 用于存放两地信息
 * */
class check{
	
	static Map<String,Double>map=new HashMap<String,Double>();
	static String name;
	
	/*
	 * 构造函数 在该类实例生成的时候 这些信息加载进入map 中
	 * */
	public check() {
		map.put("北京到广州", 2200.0);
		map.put("北京到上海",1213.0);
		map.put("北京到武汉", 1152.2);
		map.put("武汉到荆州", 223.4);
		map.put("上海到成都", 2000.0);
		map.put("广州到重庆", 971.0);
		map.put("成都到石家庄", 1503.5);
		map.put("北京到沈阳", 686.9);
		map.put("沈阳到黑龙江", 538.2);
	}
	/*
	 * 静态方法 用于用 始发地 和目的地 的名字来检索两点之间的距离
	 * */
	public static double checking(String Begin,String Terminus ) {
		name=Begin+"到"+Terminus;
//		System.out.println(name);
		/*如果没有检索到values值 则返回0 在后面的里有处理没有相应地点的方法*/
		if (map.get(name) != null){
			return map.get(name);
		}else {
			return 0;
		}
	}
	
}

/*抽象类的子类*/
class train extends trans{
	
	/*构造函数 在生成实例时 给自己的取票时间等时间赋值
	 * @param double 类型的distance 由 check类中的checking 方法获取
	 * */
	public train(double distance) {
		this.GetTicketTime=10.0;
		this.GoStationTime=30.0;
		this.SecurityCheckTime=5.0;
		this.WaitingTime=20.0;
		this.Distance=distance;
	}
	@Override
	/*实现抽象方法*/
	public String message() {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat(".00");//控制输出的小数位为两位
		double time=(this.GetTicketTime+this.GoStationTime*2+this.SecurityCheckTime+this.WaitingTime)/60+this.Distance/this.TrainSpeed;
		double price=this.Distance*this.TrainPrice;
		return "坐火车需要花费"+df.format(time)+"小时"+",花费"+df.format(price)+"元";
	}
	
}

class Plane extends trans{
	
	public Plane(double distance) {
		this.GetTicketTime=10.0;
		this.GoStationTime=60.0;
		this.SecurityCheckTime=10.0;
		this.WaitingTime=40.0;
		this.Distance=distance;
	}
	
	@Override
	public String message() {
		if(this.Distance<300) {
		    return	"距离太近，无飞机";
		}else {
			DecimalFormat df = new DecimalFormat(".00");
			double time=(this.GetTicketTime+this.GoStationTime*2+this.SecurityCheckTime+this.WaitingTime)/60+this.Distance/this.PlaneSpeed;
			double price=this.Distance*this.PlanePrice;
			return "坐飞机需要花费"+df.format(time)+"小时"+",花费"+df.format(price)+"元";
		}
	}
	
}

class Bus extends trans{
	
	public Bus(double distance) {
		this.GetTicketTime=10.0;
		this.GoStationTime=20.0;
		this.SecurityCheckTime=3.0;
		this.WaitingTime=5.0;
		this.Distance=distance;
	}
	
	
	@Override
	public String message() {
		DecimalFormat df = new DecimalFormat(".00");
		double time=(this.GetTicketTime+this.GoStationTime*2+this.SecurityCheckTime+this.WaitingTime)/60+this.Distance/this.CarSpeed;
		double price=this.Distance*this.CarPrice;
		return "坐火车需要花费"+df.format(time)+"小时"+",花费"+df.format(price)+"元";
	}
	
}

/*
 * 控制类
 * 属性 check 类的 che  train tar Bus bus 和 Plane pla 在这个类中 集合这个程序中所有的类 所有在main中只需要实例化contral 就可以了
 * */
class control{
	check che=new check();
	train tar ;
	Bus bus;
	Plane pla;
	double distance;
	
	/*构造函数 
	 * 调用Distance方法 获取两地之间的距离
	 * */
	public control() {
	     this.Distance();
		 tar =new train (distance);
		 bus =new Bus (distance);
		 pla=new Plane(distance);
	}
	
	/*
	 * 在这里加入判断 判断是否有该地点
	 * */
	public void check() {
		if (this.distance!=0) {
			System.out.println(check.name+"的距离是"+this.distance+"千米");
			tar.show();
			bus.show();
			pla.show();
		}else {
			System.out.println("请输入正确的地点");
		}
	}/*
	
	*Distance方法 用户可以用键盘输入始发站和目的地 
	*
	*/
	public void Distance() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输出始发站");
		String begin=scanner.next();
		System.out.println("请输入终点站");
		String Terminus=scanner.next();
		this.distance=check.checking(begin,Terminus);
		
	}
	
	
}

public class transport {
	public static void main(String[] args) {
		control con=new control();
		con.check();
	}

}

/*输出内容
 * 请输出始发站
武汉
荆州
请输入终点站
荆州
武汉到荆州的距离是223.4千米
坐火车需要花费2.33小时,花费100.53元
坐火车需要花费2.69小时,花费71.49元
距离太近，无飞机
 * 
 * */
