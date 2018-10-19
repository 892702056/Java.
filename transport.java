package homework;

import java.util.Scanner;//�������������
import java.text.DecimalFormat;//����С����λ���İ�
import java.util.Map;//
import java.util.HashMap;//�����߼����� ���ڴ�����صľ��������֮�����Ϣ

/*����һ���ӿ�*/
interface inter{
	public abstract void show();
}

/*
 * ������ trans 
 * ������  GoStationTime���ﳵվ���߷ɻ�����ʱ�� GetTicketTimeȡƱʱ�� SecurityCheckTime����ʱ��  WaitingTime�򳵻���ʱ��
 * Distance���ؾ��� ȫ�ֱ��� TrainPrice CarPrice PlanePrice ��¼�� ���� �ɻ���ÿ������� TrainSpeed PlaneSpeed CarSpeed ��¼���ǵ��ٶ�
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
	
	/*���󷽷�
	 * ���������Ǽ������ĳ�������� ��ʼ���ص��յ��ʱ��ͷ���
	 *  */
	public abstract String message();
	
	/*ʵ������ ������󷽷�*/
	public void show() {
	   System.out.println(this.message());	
	}
  
}

/*
 * ʵ���� check 
 * ��̬���� name �����Ժ� ��� ʼ��վ���յ�վ������ �߼���̬���� map ���ڴ��������Ϣ
 * */
class check{
	
	static Map<String,Double>map=new HashMap<String,Double>();
	static String name;
	
	/*
	 * ���캯�� �ڸ���ʵ�����ɵ�ʱ�� ��Щ��Ϣ���ؽ���map ��
	 * */
	public check() {
		map.put("����������", 2200.0);
		map.put("�������Ϻ�",1213.0);
		map.put("�������人", 1152.2);
		map.put("�人������", 223.4);
		map.put("�Ϻ����ɶ�", 2000.0);
		map.put("���ݵ�����", 971.0);
		map.put("�ɶ���ʯ��ׯ", 1503.5);
		map.put("����������", 686.9);
		map.put("������������", 538.2);
	}
	/*
	 * ��̬���� ������ ʼ���� ��Ŀ�ĵ� ����������������֮��ľ���
	 * */
	public static double checking(String Begin,String Terminus ) {
		name=Begin+"��"+Terminus;
//		System.out.println(name);
		/*���û�м�����valuesֵ �򷵻�0 �ں�������д���û����Ӧ�ص�ķ���*/
		if (map.get(name) != null){
			return map.get(name);
		}else {
			return 0;
		}
	}
	
}

/*�����������*/
class train extends trans{
	
	/*���캯�� ������ʵ��ʱ ���Լ���ȡƱʱ���ʱ�丳ֵ
	 * @param double ���͵�distance �� check���е�checking ������ȡ
	 * */
	public train(double distance) {
		this.GetTicketTime=10.0;
		this.GoStationTime=30.0;
		this.SecurityCheckTime=5.0;
		this.WaitingTime=20.0;
		this.Distance=distance;
	}
	@Override
	/*ʵ�ֳ��󷽷�*/
	public String message() {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat(".00");//���������С��λΪ��λ
		double time=(this.GetTicketTime+this.GoStationTime*2+this.SecurityCheckTime+this.WaitingTime)/60+this.Distance/this.TrainSpeed;
		double price=this.Distance*this.TrainPrice;
		return "������Ҫ����"+df.format(time)+"Сʱ"+",����"+df.format(price)+"Ԫ";
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
		    return	"����̫�����޷ɻ�";
		}else {
			DecimalFormat df = new DecimalFormat(".00");
			double time=(this.GetTicketTime+this.GoStationTime*2+this.SecurityCheckTime+this.WaitingTime)/60+this.Distance/this.PlaneSpeed;
			double price=this.Distance*this.PlanePrice;
			return "���ɻ���Ҫ����"+df.format(time)+"Сʱ"+",����"+df.format(price)+"Ԫ";
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
		return "������Ҫ����"+df.format(time)+"Сʱ"+",����"+df.format(price)+"Ԫ";
	}
	
}

/*
 * ������
 * ���� check ��� che  train tar Bus bus �� Plane pla ��������� ����������������е��� ������main��ֻ��Ҫʵ����contral �Ϳ�����
 * */
class control{
	check che=new check();
	train tar ;
	Bus bus;
	Plane pla;
	double distance;
	
	/*���캯�� 
	 * ����Distance���� ��ȡ����֮��ľ���
	 * */
	public control() {
	     this.Distance();
		 tar =new train (distance);
		 bus =new Bus (distance);
		 pla=new Plane(distance);
	}
	
	/*
	 * ����������ж� �ж��Ƿ��иõص�
	 * */
	public void check() {
		if (this.distance!=0) {
			System.out.println(check.name+"�ľ�����"+this.distance+"ǧ��");
			tar.show();
			bus.show();
			pla.show();
		}else {
			System.out.println("��������ȷ�ĵص�");
		}
	}/*
	
	*Distance���� �û������ü�������ʼ��վ��Ŀ�ĵ� 
	*
	*/
	public void Distance() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����ʼ��վ");
		String begin=scanner.next();
		System.out.println("�������յ�վ");
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

/*�������
 * �����ʼ��վ
�人
����
�������յ�վ
����
�人�����ݵľ�����223.4ǧ��
������Ҫ����2.33Сʱ,����100.53Ԫ
������Ҫ����2.69Сʱ,����71.49Ԫ
����̫�����޷ɻ�
 * 
 * */
