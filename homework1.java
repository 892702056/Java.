package homework;

import java.util.Scanner;//���������  ���Ե���Scanner���� 

/**
 * @author ʩչ ��11601 
 * @time  9.20
 *
 */

class car{
	/*
	 * �����ĸ�˽������ ��type Ϊ�ַ����������ڴ�ų�������;
	 * tank ���� �����������������
	 * OilCouter ������ ��¼����ÿСʱ��������
	 * myCaocaity ������ ��¼����������ʣ������
	 *  CAPACITY Ϊȫ�־�̬���� ��ֵ�޷��ı䣬���ڼ�¼һ������Ĵ���������
	 * */
	private String type;
	private int tank;
	private double OilCounter;
	private double myCaoacity;
	public static final int CAPACITY=50;
	
	
	/* �ڹ��캯���У��������Ա���Ը�ֵ�����Ҹ�����������������õ� ����������ֵ
	 * @param type �������� tank �������� OilCounter ÿСʱ������
	 * @return ���캯�� �޷���ֵ
	 * */
	public car(String type,int tank,double OilCounter) {
		this.type=type;
		this.tank=tank;
		this.OilCounter=OilCounter;
		this.myCaoacity=CAPACITY*this.tank;
	}
	/*
	 * �����޲ι��캯����ʹ��java�����뺯�����ü��̼�������ֵ��
	 * */
	public car () {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����복��");
		this.type=scanner.next();
		System.out.println("�����복������");
		this.tank=scanner.nextInt();
		System.out.println("�����복�ͺ���");
		this.OilCounter=scanner.nextDouble();
		this.myCaoacity=CAPACITY*this.tank;
		}
	/*
	 * �ú����������� ����������ͣ�������myCaoacity����ֵ���»ع鹹�캯��ʱ����ֵ��
	 * */
	public void gas() {
		System.out.println("��װ����");
		this.myCaoacity=CAPACITY*this.tank;
	}
	
	/*
	 * @param time ʱ�� 
	 * @return �������true ��˵���������ͣ�����false �������Ѿ���
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
	 * Oil()�����������Ƿ��ص�ǰ��ʵ����ʣ��������
	 * */
	public void Oil() {
		 System.out.println(this.myCaoacity);
		
	}
	
	/*
	 * @param time ʱ��
	 * �����ж� ��ʱ���£�ʣ�������Ƿ��㹻 ����Ϊtrue ����� ʱ�� ʣ�������������� ��Ϊfalse �����ʣ������������ʹ��ʱ��;
	 * 
	 * */
	public void run(double time) {
		if(this.isEnough(time)) {
			this.myCaoacity=this.myCaoacity-time*this.OilCounter;
			  System.out.println( "��ʻ��"+time+"Сʱ������"+(time*this.OilCounter)+"L��,��ʣ"+this.myCaoacity+"L��");
		}else {
			System.out.println("�ﳵֻ����ʻ"+(this.myCaoacity/this.OilCounter)+"Сʱ");
		}
	}
	/*
	 *  �ú���������������Ļ������ԣ�
	 * */
	public void show() {
		System.out.println("���������������:"+this.type+"\t��"+this.tank+"������\tÿСʱ�ͺ�Ϊ��"+this.OilCounter+"L");
	}
	
}


public class test1 {
    public static void main(String []args) {
         
    	car car1=new car("����",2,20);
    	car car2=new car("����",3,25);
    	car car3=new car("·��",4,30);
    	car car4=new car();//������������ֵ
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
 * �ó�������Ľ��Ϊ:
 * ���������������:����	��2������	ÿСʱ�ͺ�Ϊ��20.0L
  ���������������:����	��3������	ÿСʱ�ͺ�Ϊ��25.0L
  ���������������:·��	��4������	ÿСʱ�ͺ�Ϊ��30.0L
  ���������������:�ݱ�	��2������	ÿСʱ�ͺ�Ϊ��10.0L
��ʻ��2.0Сʱ������40.0L��,��ʣ60.0L��
��ʻ��5.0Сʱ������125.0L��,��ʣ25.0L��
��װ����
100.0

 * 
 * 
 * */
