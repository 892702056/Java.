package homework;
import java.util.*;//������������ܵ���java�����뷽����

class game{
	/*
	 * ��������˽������ String��name Ϊ�������;
	 *          int��grade Ϊ��ҷ���;
	 * */
	private String name;
	private int grade;
	Scanner scanner1=new Scanner(System.in);
	/**
	 * 
	 */
	/*
	 * �޲ι��캯�����ڹ��캯���ڲ���java����ķ�ʽ�����Ը�ֵ,���Ҹ�ÿ����ҵ�grade����ֵΪ0;
	 * 
	 * 
	 * */
	public game() {
		
	    System.out.println("�������������");
	    this.name=scanner1.next();
	    this.grade=0;
	}
	/*
	 *      ʵ�ֲ�����Ϸ����������
	 *  ����ʵ����������������� ����Ϊ��Math.random()���������������0.0~1.0֮���С��������Ҫ*10����Χ�Ŵ�ʮ������Χ��0~10ȡ����10  ���ǲ����� ֻ������������Ҫ
	 *  ǿ��ת����int���� �ټ���+ʹ�÷�Χ��Ϊ1~10;
	 *  �ڶ��������ж�����������������Ƿ���ͬ
	 * 
	 * */
	public void play() {
		int ranDomNum=1+(int)(Math.random()*10);
		Scanner scanner2=new Scanner(System.in);
		int num=scanner2.nextInt();
		if(num==ranDomNum) {
			System.out.println("����������"+ranDomNum+"\n��ϲ��¶���");
			this.Grade(true);
		}else {
			System.out.println("����������"+ranDomNum+"\n���ź���´���");
			this.Grade(false);
		}
	}
	/*
	 * ������������Ϊ ���ݲ����ֵ��������ҵķ������п��ƣ��¶Լӷ� �´��ӷ֣�
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
	 * ������� �����������͵�ǰ������
	 * */
	public void show() {
		System.out.println("����:"+this.name+"\t ���ķ���Ϊ:"+this.grade);
	}
	
	
}





public class test2 {
   public static void main(String []args) {
	   Scanner scanner = new Scanner(System.in);
	   int personNum=0;//�����������
	   int num=0;//������Ϸ����
	  
	   System.out.println("�����������Ϸ�����");
	   personNum = scanner.nextInt();
	   System.out.println("��������Ϸ������"); 
	   num=scanner.nextInt();
	   
	   
	   game []array=new game[personNum];//����һ��game����ʵ�������ÿһ��game��ʵ��
	   for(int i=0;i<personNum;i++) {
		   array[i]=new game();//ʵ����
	   }
	 
	  for(int i=0;i<num;i++) {
		  for(int j=0;j<personNum;j++) {
			  array[j].play();
		}
		System.out.println("��"+(i+1)+"�ֽ�����");  
	  }
	  for(int i=0;i<personNum;i++) {
		   array[i].show();
	   }
	  
	  
	}
}
