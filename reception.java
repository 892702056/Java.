package homework;


/*������������*/
import java.util.Scanner;

/*��ͨ���͵Ľӿ� ���������󷽷� �� ס ��*/
interface rece{
   public abstract void Eat();
   public abstract void Stay();
   public abstract void Trip();
}
/*
 * �߼����ͽӿ� ����һ�����󷽷� ����
 * */
interface guibing{
	public abstract void Present();
}


/*
 * ������receipt ʵ�� ��ͨ�ӿ�
 * */
abstract class receipt implements rece{
	
	public final double StandardRoomPrice=300.0;//�������۸�
	public final double DeluxRoomPrice=180;//��׼��۸�
	public final double CommonFoodPrice=20.0;//��ͨʳ��۸�
	public final double GoodFoodPrice=40.0;//����ʳ��
	public final double PresidentialPrice=500.0;//��ͳ�׷��۸�
	public double EatPrice;//�Է��滨��Ǯ
	public double StayPrice;//ס���滨��Ǯ
	public double TripPrice;//�з��滨��Ǯ
	public int StayDays;//ͣ������
	public double AllPrice;//���еĻ���
	public int grade;//�ȼ� ��������Ƕ�Ӧ�ڸ߼������ϵ�
	public abstract void show();//���󷽷� ������ѵ��ܽ��

}

/*ʵ���� ��ѧ�� �̳г�����*/
class Undergraduate extends receipt{
	/*
	 * ���캯�� 
	 * @param int days ͣ������ String begin ������ʼ���� String terminus Ŀ�ĵ�
	 * 
	 * */
	public Undergraduate(int days,String begin,String terminus) {
		check che=new check();
		
		this.StayPrice=DeluxRoomPrice;
		this.EatPrice=CommonFoodPrice;
		this.StayDays=days;
		check che1=new check();//����һ��check ʵ������ ���check�����ڱ����е�transport����
		this.TripPrice=che1.checking(begin, terminus)*trans.CarPrice;//�л��ķѵ�Ǯ���� ����֮��ľ���*�ý�ͨ���ߵķ���

	}
	
	@Override
	/*ʵ�ֳ��󷽷�*/
	public void Eat() {
		// TODO Auto-generated method stub
		System.out.println("Ϊѧ���ṩ��ͨʳ��");
		System.out.println("ѧ��"+this.StayDays+"���ڳԷ�����Ҫ����"+(this.EatPrice*this.StayDays)+"Ԫ");
		
	}

	@Override
	/*ʵ�ֳ��󷽷�*/
	public void Stay() {
		// TODO Auto-generated method stub
		System.out.println("Ϊѧ���ṩ��׼��");
		System.out.println("ѧ��"+this.StayDays+"����ס�޷�����Ҫ����"+(this.StayPrice*this.StayDays)+"Ԫ");
		
	}

	@Override
	/*ʵ�ֳ��󷽷�*/
	public void Trip() {
		// TODO Auto-generated method stub
		System.out.println("Ϊѧ���ṩ��������");
		System.out.println("ѧ��"+this.StayDays+"����ס�޷�����Ҫ����"+(this.TripPrice*2)+"Ԫ");
		
	}

	@Override
	/*ʵ�ֳ��󷽷�*/
	public void show() {
		// TODO Auto-generated method stub
		this.AllPrice=this.StayDays*(this.StayPrice+this.EatPrice)+this.TripPrice*2;
		System.out.println("���ѧ������"+this.StayDays+"���ܹ�����"+this.AllPrice+"Ԫ");
		
	}

	
}


class Teacher  extends receipt{
	
	
	public  Teacher(int days,String begin,String terminus) {
		this.EatPrice=this.GoodFoodPrice;
		this.StayPrice=this.StandardRoomPrice;
		this.StayDays=days;
		check che2=new check();
		this.TripPrice=che2.checking(begin, terminus)*trans.TrainPrice;//��ʦ��Ӧ�Ľ�ͨ�����ǻ�

	}
	@Override
	/*ʵ�ֳ��󷽷�*/
	public void Eat() {
		System.out.println("Ϊ��ʦ�ṩ����ʳ��");
		System.out.println("��ʦ"+this.StayDays+"���ڳԷ�����Ҫ����"+(this.EatPrice*this.StayDays)+"Ԫ");
		
	}

	@Override
	/*ʵ�ֳ��󷽷�*/
	public void Stay() {
		// TODO Auto-generated method stub
		System.out.println("Ϊ��ʦ�ṩ������׼��");
		System.out.println("��ʦ"+this.StayDays+"����ס�޷�����Ҫ����"+(this.StayPrice*this.StayDays)+"Ԫ");
		
	}

	@Override
	/*ʵ�ֳ��󷽷�*/
	public void Trip() {
		// TODO Auto-generated method stub
		System.out.println("Ϊ��ʦ�ṩ������");
		System.out.println("��ʦ"+this.StayDays+"����ס�޷�����Ҫ����"+(this.TripPrice*2)+"Ԫ");
		
	}

	@Override
	/*ʵ�ֳ��󷽷�*/
	public void show() {
		// TODO Auto-generated method stub
		this.AllPrice=this.StayDays*(this.StayPrice+this.EatPrice)+this.TripPrice*2;
		System.out.println("�����ʦ����"+this.StayDays+"���ܹ�����"+this.AllPrice+"Ԫ");
		
	}
	
}

class Patriarch extends receipt{
	
		
	public  Patriarch(int days,String begin,String terminus) {
		this.EatPrice=this.CommonFoodPrice;
		this.StayPrice=this.StandardRoomPrice;
		this.StayDays=days;
		check che=new check();
		this.TripPrice=che.checking(begin, terminus)*trans.TrainPrice;//�ҳ���Ӧ�Ľ�ͨ�����ǻ�

	} 
	@Override
	public void Eat() {
		System.out.println("Ϊ�ҳ��ṩ��ͨʳ��");
		System.out.println("�ҳ�"+this.StayDays+"���ڳԷ�����Ҫ����"+(this.EatPrice*this.StayDays)+"Ԫ");
		
	}

	@Override
	/*ʵ�ֳ��󷽷�*/
	public void Stay() {
		// TODO Auto-generated method stub
		System.out.println("Ϊ�ҳ��ṩ������׼��");
		System.out.println("�ҳ�"+this.StayDays+"����ס�޷�����Ҫ����"+(this.StayPrice*this.StayDays)+"Ԫ");
		
	}

	@Override
	/*ʵ�ֳ��󷽷�*/
	public void Trip() {
		// TODO Auto-generated method stub
		System.out.println("Ϊ�ҳ��ṩ������");
		System.out.println("�ҳ�"+this.StayDays+"����ס�޷�����Ҫ����"+(this.TripPrice*2)+"Ԫ");
		
	}

	@Override
	/*ʵ�ֳ��󷽷�*/
	public void show() {
		// TODO Auto-generated method stub
		this.AllPrice=this.StayDays*(this.StayPrice+this.EatPrice)+this.TripPrice*2;
		System.out.println("����ҳ�����"+this.StayDays+"���ܹ�����"+this.AllPrice+"Ԫ");
		
	}
	
}
/*�߼����� �쵼�ȼ̳� receipt ��ʵ�ֽӿ�guibing*/
class Leader  extends receipt implements guibing{
	
	double PresentPrice;//����һ���������͵���������
	/*
	 * ����Ĺ��캯�����������ͨ���Ͷ���һ��grade �ȼ����� ����������쵼������ĵȼ� ��ȷ���������۸�
	 * 
	 * */
	public Leader(int days,int grade,String begin,String terminus){
		this.EatPrice=this.GoodFoodPrice;
		this.StayPrice=this.PresidentialPrice;
		this.StayDays=days;
		this.grade=grade;
		check che4=new check();
		this.TripPrice=che4.checking(begin, terminus)*trans.PlanePrice;//�쵼ʹ�õķɻ�
		
	}
	@Override
	public void Eat() {
		// TODO Auto-generated method stub
		System.out.println("Ϊ�쵼�ṩ����ʳ��");
		System.out.println("�쵼"+this.StayDays+"���ڳԷ�����Ҫ����"+(this.EatPrice*this.StayDays)+"Ԫ");
		
	}

	@Override
	public void Stay() {
		// TODO Auto-generated method stub
		System.out.println("Ϊ�쵼�ṩ��ͳ�׷�");
		System.out.println("�쵼"+this.StayDays+"����ס�޷�����Ҫ����"+(this.StayPrice*this.StayDays)+"Ԫ");
		
	}

	@Override
	public void Trip() {
		// TODO Auto-generated method stub
		System.out.println("Ϊ�쵼�ṩ�ɻ�����");
		System.out.println("�쵼"+this.StayDays+"�����г̷�����Ҫ����"+(this.TripPrice*2)+"Ԫ");
		
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
			System.out.println("��������");
			break;
		}
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.Present();
		this.AllPrice=this.StayDays*(this.StayPrice+this.EatPrice)+this.TripPrice*2+this.PresentPrice;
		System.out.println("����쵼����"+this.StayDays+"���ܹ�����"+this.AllPrice+"Ԫ");
		
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
		System.out.println("Ϊ����ṩ����ʳ��");
		System.out.println("���"+this.StayDays+"���ڳԷ�����Ҫ����"+(this.EatPrice*this.StayDays)+"Ԫ");
		
	}

	@Override
	public void Stay() {
		// TODO Auto-generated method stub
		System.out.println("Ϊ����ṩ��ͳ�׷�");
		System.out.println("���"+this.StayDays+"����ס�޷�����Ҫ����"+(this.StayPrice*this.StayDays)+"Ԫ");
		
	}

	@Override
	public void Trip() {
		// TODO Auto-generated method stub
		System.out.println("Ϊ����ṩ�ɻ�����");
		System.out.println("���"+this.StayDays+"�����г̷�����Ҫ����"+(this.TripPrice*2)+"Ԫ");
		
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
			System.out.println("��������");
			break;
		}
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.Present();
		this.AllPrice=this.StayDays*(this.StayPrice+this.EatPrice)+this.TripPrice*2+this.PresentPrice;
		System.out.println("����������"+this.StayDays+"���ܹ�����"+this.AllPrice+"Ԫ");
		
	}
	
}

/*
 *������ Operate1 
 *��������� ���ǿ��Զ����������в���
 * */
class Operate1{
	public	String name;//��ѯ�����
	public	double distance;//���صľ���
	public	int days;//ͣ��������
	public	String begin;//ʼ����
	public	String terminus;//Ŀ�ĵ�
	public	int grades;//�ȼ�
	public	int n;//���Ʋ��� 1Ϊ��ͨ����2Ϊ�߼�����
	
	
	public 	Operate1(String name) {
		System.out.println(name);
		switch (name) {
		case "��ѧ��":
			this.write(1);
			Undergraduate gra=new Undergraduate(this.days,this.begin,this.terminus);
			gra.show();
			break;
		case "��ʦ":
			this.write(1);
			Teacher tea=new Teacher(this.days,this.begin,this.terminus);
			tea.show();
			break;
		case"�ҳ�":
			this.write(1);
			Patriarch pat=new Patriarch(this.days,this.begin,this.terminus);
			pat.show();
			break;
		case "�쵼":
			this.write(2);
			Leader lead=new Leader(this.days,this.grades,this.begin,this.terminus);
			lead.show();
			break;
		case "���":
			this.write(2);
			Foreign foreign = new Foreign(this.days,this.grades,this.begin,this.terminus);
			foreign.show();
			break;
					
		default:
			System.out.println("�������!");
			break;
		}
	}
	/*��Ϣд�뷽�� ������Ҫ�Ĳ���д������������*/
	public void write(int n) {
		if(n==1) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������ͣ������");
			int d=scanner.nextInt();
			this.days=d;
			System.out.println("������ʼ����");
			String b=scanner.next();
			this.begin=b;
			System.out.println("������Ŀ�ĵ�");
			String t=scanner.next();
			this.terminus=t;
		}else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������ͣ������");
			int d=scanner.nextInt();
			this.days=d;
			System.out.println("���������ĵȼ�");
			int g=scanner.nextInt();
			this.grades=g;
			System.out.println("������ʼ����");
			String b=scanner.next();
			this.begin=b;
			System.out.println("������Ŀ�ĵ�");
			String t=scanner.next();
			this.terminus=t;
		}
	}
	
	
}



public class reception {
	public static void main(String[]args){
		System.out.println("���������ѯ�����");
		Scanner scanner = new Scanner(System.in);
		String name=scanner.next();
		Operate1 ope=new Operate1(name);
	}
	
}
/*
 * ���������ѯ�����
���
������ͣ������
3
���������ĵȼ�
2
������ʼ����
����
������Ŀ�ĵ�
����
����������3���ܹ�����10920.0Ԫ

 * 
 * 
 * */

