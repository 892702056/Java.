package homework;

import java.util.Scanner;//������������
import java.util.Random;//���������������
import java.text.DecimalFormat;//����������С��λ���İ�
import java.io.*;//����д���ȡ�ļ���
import java.util.Map;//����߼�����Map��
import java.util.HashMap;//����߼�����HashMap���Ͱ�


/*������Company
 * ���ԣ� static int ���� employ_num ��̬���� ����ÿ��������employee���й���ʱ��+1 ������¼employee����
 *   static int  ���� manage_num ��̬���� ͬ��
 *   static int ���� shareholder_num ��̬���� ͬ��
 *   String ����name ��¼ʵ��������
 *   String ���� position ��¼ʵ����ְλ
 *   double ����birthday ��¼ʵ��������   
 * */
abstract class Company{
	Scanner scanner = new Scanner(System.in);
	
	static int employee_num=0;
	static int manage_num=0;
	static int shareholder_num=0;
	String name;
	String position;
	double birthday;
	
	/*���󷽷� pay
	 * @param int ���͵�month ���� ���͵��·� 
	 * @return String ���� һ���ַ���
	 * ����������Խ���һ���·ݣ����ص��µĹ������
	 * */
	public abstract String pay(int month);
	/*
	 * ���󷽷� payall 
	 * @param int year int month ������������·�
	 * @return String ����һ���ַ���
	 * ����������Խ���һ�����һ���·ݣ���������Ķ�ʱ���ڵĹ������
	 * */
	public abstract String payall(int year,int month);
	
	/*���� birth 
	 * @param ��
	 * @return int ����һ����������
	 * �����������ͨ����������һ�����գ���������Ǹ�double ���� �򷵻ص�ʱ�� Ҫ����ת��Ϊint ����;
	 * */
	public  int birth () {
		System.out.println("������"+this.position+this.name+"������:");
		this.birthday=scanner.nextDouble();
		return (int)(this.birthday);
	}
	
}

/*
 * ��̬��Company_money
 * ������еķ���������ȫ�Ǿ�̬�� ���ڵ���ʱ ������ Company_money.+����or����
 * �����������Ǽ���Ӫҵ��������
 * */
class Company_money{
	static double month_pay;
	static double profit;//����;
	static double turnor;//��Ӫҵ��;
	/*һ���µ�Ӫҵ��*/
	/*��̬���� month
	 * @param ��
	 * @return double ����һ��double ����
	 * ��������������������һ���µ�Ӫҵ�� Ӫҵ����100000��200000֮�����ȡֵ
	 * */
	public static  double month() {
		month_pay=new Random().nextInt(200000)+100000;//���������
		return month_pay;
	}
	/*
	 * ��̬���� turnor 
	 * @param ��
	 * @return String ����һ���ַ���
	 * ��������������� ѭ������12��month()����ӻ��һ���Ӫҵ��
	 * �����õ���DecimalFormat���еķ��� ʹ�����Ӫҵ����Ա�����λС���������ַ�����ʽ����
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
     *      ��̬����profit
     *   @param ��
     *   @return String ����һ���ַ���
     *     �������������������һ�������� ��ͳ�Ƶ�ʵ������employee��manager���� ������Ӧ�Ĺ��ʵõ���һ��Ŀ�֧������Ӫҵ���ȥ��֧���ɵõ�����   
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
 * ����employee �̳г�����Company
 *   ���ԣ� ��̬���� employee_pay ��employee_present ��������Ϊ10000��1500
 *   
 * 
 * */
class employee extends Company{
	static double employ_pay=10000;
	static double employ_present=1500;
	
	/*���췽��
	 * @param String���͵�name 
	 * �ڹ��췽���м��뾲̬����employee_num ������¼ʵ��������
	 * 
	 * */
	public employee(String name) {
		this.name=name;
		this.position="Ա��";
		employee_num++;
		this.birthday=this.birth();
	}
	/*
	 * ʵ�ֳ��󷽷� pay 
	 * �ж�����·ݺ͸ö���ʵ���������Ƿ���ͬһ���� �����ڷ���ֵ�м���һ���������� ���� ��û��
	 * */
	public String pay(int month) {
		if(month!=this.birthday)
		{
		  return this.position+this.name+"����¹���Ϊ"+this.employ_pay;	
		}
		else {
		  return this.position+this.name+"����¹���Ϊ"+this.employ_pay+"��������Ϊ:"+this.employ_present;
		}
		
	}
	
	/*ʵ�ֳ��󷽷�payall
	 * �ж��·��Ƿ����������ʵ����������ͬһ���� ������ϸ������������ ���� ��һ�����������ȥ��
	 * */
	public String payall(int year,int month) {
		 if (month<this.birthday) {
		 return (this.name+year+"��"+month+"�µĹ��ʼ������ܺ�Ϊ:"+((year*12+month)*this.employ_pay+(year-1)*this.employ_present));
		 }else {
			 return (this.name+year+"��"+month+"�µĹ��ʼ������ܺ�Ϊ:"+((year*12+month)*this.employ_pay+year*this.employ_present));
		 }
	}
}


/*
 *����manager �̳г����� Company 
 *����: ��̬���� double ���͵�manager_pay manager_present ��manager_bonu �ֱ�ֵ 20000�� 2000 ����ļ���Ϊ ÿ���µ�Ӫҵ��İٷ�֮��
 */
class manager extends Company{
	static double manager_pay=20000;
	static double manager_present=2000;
	static double manager_bonu=Company_money.month()*0.02;;
	public manager(String name) {
		this.name=name;
		this.position="����";
		manage_num++;
		this.birthday=this.birth();
	}
	
	@Override
	/*ʵ�ֳ�����*/
	public String pay(int month) {
		if(month!=this.birthday)
		{
			return (this.position+this.name+"���¹���Ϊ:"+manager_pay+"���½���Ϊ:"+manager_bonu);
		}else {
			return this.position+(this.name+"���¹���Ϊ:"+manager_pay+"���½���Ϊ:"+manager_bonu+"��������Ϊ:"+this.manager_present);
		}
	}
	
	
	@Override
	/*ʵ�ֳ�����
	 * */
	public String payall(int year, int month) {
		DecimalFormat df = new DecimalFormat(".00");
		if(month<this.birthday) {
		   return this.position+this.name+year+"��"+month+"��"+"�Ĺ��ʼӽ���������ܺ�Ϊ:"+
	    ((year*12+month)*(this.manager_pay+manager_bonu)+(year-1)*(manager_present));
	    }else {
		 return this.position+this.name+year+"��"+month+"��"+"�Ĺ��ʼӽ���������ܺ�Ϊ:"+df.format(
					((year*12+month)*(this.manager_pay+manager_bonu)+year*(manager_present)));
	}
 }

}

/*����shareholder �̳г�����Company 
 * ���ԣ�  ��̬���� shareholder_pay
 * */
class shareholder extends Company{
    static double shareholder_pay;
    
    public shareholder(String name) {
    	this.name=name;
    	this.position="�ɶ�";
    	Company.shareholder_num++;
    }
	
	@Override
	/*ʵ�ֳ��󷽷�*/
	public String pay(int month) {
		
		return "�ɶ�û����н��" ;
	}

	@Override
	/*ʵ�ֳ��󷽷�*/
	public String payall(int year, int month) {
		DecimalFormat df = new DecimalFormat(".00");
		shareholder_pay=year*Company_money.profit*0.1;
		return this.position+this.name+" "+year+"��ķֺ�Ϊ:"+df.format(shareholder_pay);
	}	
}


/*��ͨ���� opertate*/
class operate{
	 static Map<String,Company>map=new HashMap<String,Company>();//��̬���� �߼�����Map ������ΪString  ֵ����ΪCompany
	 shareholder sh1=new shareholder("1");
	 shareholder sh2=new shareholder("2");
	 shareholder sh3=new shareholder("3");
	 shareholder sh4=new shareholder("4");
	 shareholder sh5=new shareholder("5");
	 /*���췽�� 
	  * ʵ������������
	  * 
	  * */
	 public operate() {
		 Company_money.turnor();
		 Company_money.profit();
		 this.write(new manager("С��"));
		 this.write(new manager("С��"));
		 this.write(new employee("С��"));
		 this.write(new employee("����"));
		 this.write(new employee("����"));
		 this.write(new manager("�ܿ���"));
		 this.write(sh1);
		 this.write(sh2);
		 this.write(sh3);
		 this.write(sh4);
		 this.write(sh5);
	}
	/*
	 * @param Company a  ����Ϊ Company����
	 * @return ��
	 * ��������������� ��Company���͵Ķ������map��
	 * */ 
    public void write(Company a) {
    	map.put(a.name, a);
	}
    /*
     * @param String 
     * @return Company 
     * �����������������map �в�ѯ�ò����Ƿ���� ���ڸü� �򷵻ظ�ֵ
     * */
    public Company check(String name) {
    	return map.get(name);
    }
    /*
     * @param ��
     * @return ��
     * ��������������Ǳ�������map������foreach ���� ��������һ��String���������ţ������ļ���д�ķ�ʽ ������Map���е����ж����һ�깤��д��txt �ļ���
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
		 manager man1=(manager) op.check("С��");
		 employee ep1=(employee)op.check("С��");
		 System.out.println(man1.payall(1,0));
		 System.out.println(ep1.pay(2));
         //op.traverse();
	 }
	
}


/*
 * pay.txt�ļ�����Ϊ��
 * ����1��0�µĹ��ʼ������ܺ�Ϊ:120000.0
�ɶ�1 1��ķֺ�Ϊ:251638.60
����1��0�µĹ��ʼ������ܺ�Ϊ:120000.0
�ɶ�2 1��ķֺ�Ϊ:251638.60
����С��1��0�µĹ��ʼӽ���������ܺ�Ϊ:267297.6
�ɶ�3 1��ķֺ�Ϊ:251638.60
����С��1��0�µĹ��ʼӽ���������ܺ�Ϊ:267297.6
�ɶ�4 1��ķֺ�Ϊ:251638.60
�ɶ�5 1��ķֺ�Ϊ:251638.60
С��1��0�µĹ��ʼ������ܺ�Ϊ:120000.0
����ܿ���1��0�µĹ��ʼӽ���������ܺ�Ϊ:267297.6

 * 
 * 
 * 
 * */
/*����̨���������Ϊ:
 * �����뾭��С��������:
2
�����뾭��С��������:
3
������Ա��С�ε�����:
5
������Ա������������:
3
������Ա�����ĵ�����:
2
�����뾭��ܿ��������:
1
����С��1��0�µĹ��ʼӽ���������ܺ�Ϊ:268711.44
Ա��С������¹���Ϊ10000.0
*/
