package homework;

import java.util.Scanner;//引入键盘输入包
import java.util.Random;//引入生成随机数包
import java.text.DecimalFormat;//引入控制输出小数位数的包
import java.io.*;//引入写入读取文件包
import java.util.Map;//引入高级类型Map包
import java.util.HashMap;//引入高级类型HashMap类型包


/*抽象类Company
 * 属性： static int 类型 employ_num 静态变量 ，再每次有子类employee进行构造时加+1 用来记录employee数量
 *   static int  类型 manage_num 静态变量 同上
 *   static int 类型 shareholder_num 静态变量 同上
 *   String 类型name 记录实例的名字
 *   String 类型 position 记录实例的职位
 *   double 类型birthday 记录实例的生日   
 * */
abstract class Company{
	Scanner scanner = new Scanner(System.in);
	
	static int employee_num=0;
	static int manage_num=0;
	static int shareholder_num=0;
	String name;
	String position;
	double birthday;
	
	/*抽象方法 pay
	 * @param int 类型的month 接受 整型的月份 
	 * @return String 返回 一串字符串
	 * 这个方法可以接受一个月份，返回当月的工资情况
	 * */
	public abstract String pay(int month);
	/*
	 * 抽象方法 payall 
	 * @param int year int month 接受整型年和月份
	 * @return String 返回一串字符串
	 * 这个方法可以接受一个年份一个月份，返回在这的段时间内的工资情况
	 * */
	public abstract String payall(int year,int month);
	
	/*方法 birth 
	 * @param 无
	 * @return int 返回一个整型生日
	 * 这个方法可以通过键盘输入一个生日，但输入的是个double 类型 则返回的时候 要进行转型为int 类型;
	 * */
	public  int birth () {
		System.out.println("请输入"+this.position+this.name+"的生日:");
		this.birthday=scanner.nextDouble();
		return (int)(this.birthday);
	}
	
}

/*
 * 静态类Company_money
 * 这个类中的方法和属性全是静态的 则在调用时 可以用 Company_money.+方法or属性
 * 这个类的作用是计算营业额和利润的
 * */
class Company_money{
	static double month_pay;
	static double profit;//利润;
	static double turnor;//总营业额;
	/*一个月的营业额*/
	/*静态方法 month
	 * @param 无
	 * @return double 返回一个double 类型
	 * 这个方法是用随机数生成一个月的营业额 营业额在100000到200000之间随机取值
	 * */
	public static  double month() {
		month_pay=new Random().nextInt(200000)+100000;//生成随机数
		return month_pay;
	}
	/*
	 * 静态方法 turnor 
	 * @param 无
	 * @return String 返回一个字符串
	 * 这个方法的作用是 循环调用12次month()并相加获得一年的营业额
	 * 这里用到了DecimalFormat包中的方法 使输出的营业额可以保留两位小数并且以字符串形式返回
	 * */
    public static String turnor() {
     DecimalFormat df = new DecimalFormat(".00");
      for(int i=0;i<12;i++)
      {
    	turnor+=month();
      }
	   return df.format(turnor);
	}
    /*
     *      静态方法profit
     *   @param 无
     *   @return String 返回一个字符串
     *     这个方法是用来计算这一年的利润的 用统计的实例化的employee和manager数量 乘以相应的工资得到这一年的开支，再用营业额减去开支即可得到利润   
     * */
     public static String profit() {
    	 DecimalFormat df = new DecimalFormat(".00");
    	 double employee_money=Company.employee_num*(12*employee.employ_pay+employee.employ_present);
    	 double manager_money=Company.manage_num*(12*(manager.manager_pay+manager.manager_bonu)+manager.manager_present);
    	 profit=turnor-(employee_money)-(manager_money);
    	 //System.out.println(Company.manage_num);
    	 return df.format(profit);
     }
}

/*
 * 
 * 子类employee 继承抽象类Company
 *   属性： 静态变量 employee_pay 和employee_present 设置属性为10000和1500
 *   
 * 
 * */
class employee extends Company{
	static double employ_pay=10000;
	static double employ_present=1500;
	
	/*构造方法
	 * @param String类型的name 
	 * 在构造方法中加入静态变量employee_num 用来记录实例化数量
	 * 
	 * */
	public employee(String name) {
		this.name=name;
		this.position="员工";
		employee_num++;
		this.birthday=this.birth();
	}
	/*
	 * 实现抽象方法 pay 
	 * 判断这个月份和该对象实例的生日是否在同一个月 是则在返回值中加入一个生日礼物 否则 则没有
	 * */
	public String pay(int month) {
		if(month!=this.birthday)
		{
		  return this.position+this.name+"这个月工资为"+this.employ_pay;	
		}
		else {
		  return this.position+this.name+"这个月工资为"+this.employ_pay+"生日礼物为:"+this.employ_present;
		}
		
	}
	
	/*实现抽象方法payall
	 * 判断月份是否在这个对象实例的生日在同一个月 是则加上该年的生日礼物 否则 这一年的生日礼物去掉
	 * */
	public String payall(int year,int month) {
		 if (month<this.birthday) {
		 return (this.name+year+"年"+month+"月的工资加礼物总和为:"+((year*12+month)*this.employ_pay+(year-1)*this.employ_present));
		 }else {
			 return (this.name+year+"年"+month+"月的工资加礼物总和为:"+((year*12+month)*this.employ_pay+year*this.employ_present));
		 }
	}
}


/*
 *子类manager 继承抽象类 Company 
 *属性: 静态属性 double 类型的manager_pay manager_present 和manager_bonu 分别赋值 20000和 2000 奖金的计算为 每个月的营业额的百分之二
 */
class manager extends Company{
	static double manager_pay=20000;
	static double manager_present=2000;
	static double manager_bonu=Company_money.month()*0.02;;
	public manager(String name) {
		this.name=name;
		this.position="经理";
		manage_num++;
		this.birthday=this.birth();
	}
	
	@Override
	/*实现抽象类*/
	public String pay(int month) {
		if(month!=this.birthday)
		{
			return (this.position+this.name+"当月工资为:"+manager_pay+"当月奖金为:"+manager_bonu);
		}else {
			return this.position+(this.name+"当月工资为:"+manager_pay+"当月奖金为:"+manager_bonu+"生日礼物为:"+this.manager_present);
		}
	}
	
	
	@Override
	/*实现抽象类
	 * */
	public String payall(int year, int month) {
		DecimalFormat df = new DecimalFormat(".00");
		if(month<this.birthday) {
		   return this.position+this.name+year+"年"+month+"月"+"的工资加奖金加礼物总和为:"+
	    ((year*12+month)*(this.manager_pay+manager_bonu)+(year-1)*(manager_present));
	    }else {
		 return this.position+this.name+year+"年"+month+"月"+"的工资加奖金加礼物总和为:"+df.format(
					((year*12+month)*(this.manager_pay+manager_bonu)+year*(manager_present)));
	}
 }

}

/*子类shareholder 继承抽象类Company 
 * 属性：  静态属性 shareholder_pay
 * */
class shareholder extends Company{
    static double shareholder_pay;
    
    public shareholder(String name) {
    	this.name=name;
    	this.position="股东";
    	Company.shareholder_num++;
    }
	
	@Override
	/*实现抽象方法*/
	public String pay(int month) {
		
		return "股东没有月薪！" ;
	}

	@Override
	/*实现抽象方法*/
	public String payall(int year, int month) {
		DecimalFormat df = new DecimalFormat(".00");
		shareholder_pay=year*Company_money.profit*0.1;
		return this.position+this.name+" "+year+"年的分红为:"+df.format(shareholder_pay);
	}	
}


/*普通方法 opertate*/
class operate{
	 static Map<String,Company>map=new HashMap<String,Company>();//静态属性 高级类型Map 键类型为String  值类型为Company
	 shareholder sh1=new shareholder("1");
	 shareholder sh2=new shareholder("2");
	 shareholder sh3=new shareholder("3");
	 shareholder sh4=new shareholder("4");
	 shareholder sh5=new shareholder("5");
	 /*构造方法 
	  * 实例化各个对象
	  * 
	  * */
	 public operate() {
		 Company_money.turnor();
		 Company_money.profit();
		 this.write(new manager("小明"));
		 this.write(new manager("小康"));
		 this.write(new employee("小宋"));
		 this.write(new employee("张三"));
		 this.write(new employee("李四"));
		 this.write(new manager("杰克马"));
		 this.write(sh1);
		 this.write(sh2);
		 this.write(sh3);
		 this.write(sh4);
		 this.write(sh5);
	}
	/*
	 * @param Company a  参数为 Company类型
	 * @return 无
	 * 这个方法的作用是 讲Company类型的对象放入map中
	 * */ 
    public void write(Company a) {
    	map.put(a.name, a);
	}
    /*
     * @param String 
     * @return Company 
     * 这个方法的作用是在map 中查询该参数是否存在 存在该键 则返回该值
     * */
    public Company check(String name) {
    	return map.get(name);
    }
    /*
     * @param 无
     * @return 无
     * 这个方法的作用是遍历整个map表，采用foreach 方法 遍历并用一个String类型数组存放，再用文件读写的方式 将整个Map表中的所有对象的一年工资写入txt 文件中
     * 
     * */
    public void traverse() throws IOException {
    	String[] array=new String[map.size()];
    	int i=0;
    	for(Company a:map.values()) {
    		array[i]=a.payall(1, 0);
    		i++;
    	}
    	 FileWriter  w = new FileWriter ("E:\\szjava\\MyJava\\JavaWork\\pay.txt",true);
    	 for(int j=0;j<operate.map.size();j++) {
			w.write(array[j]);
			w.write("\r\n");
		 }
    	 w.close();
    }
	
}
public class PayOff {
	 public static void main(String []args) throws IOException {
		 operate op=new operate();
		 manager man1=(manager) op.check("小明");
		 employee ep1=(employee)op.check("小宋");
		 System.out.println(man1.payall(1,0));
		 System.out.println(ep1.pay(2));
         //op.traverse();
	 }
	
}


/*
 * pay.txt文件内容为：
 * 李四1年0月的工资加礼物总和为:120000.0
股东1 1年的分红为:251638.60
张三1年0月的工资加礼物总和为:120000.0
股东2 1年的分红为:251638.60
经理小康1年0月的工资加奖金加礼物总和为:267297.6
股东3 1年的分红为:251638.60
经理小明1年0月的工资加奖金加礼物总和为:267297.6
股东4 1年的分红为:251638.60
股东5 1年的分红为:251638.60
小宋1年0月的工资加礼物总和为:120000.0
经理杰克马1年0月的工资加奖金加礼物总和为:267297.6

 * 
 * 
 * 
 * */
/*控制台的输出内容为:
 * 请输入经理小明的生日:
2
请输入经理小康的生日:
3
请输入员工小宋的生日:
5
请输入员工张三的生日:
3
请输入员工李四的生日:
2
请输入经理杰克马的生日:
1
经理小明1年0月的工资加奖金加礼物总和为:268711.44
员工小宋这个月工资为10000.0
*/
