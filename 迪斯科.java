package homework;
/*
 * �����������������ʹ�ø߼�����List
 * */
import java.util.ArrayList;
import java.util.List;
/*
 * ������������Խ��м�������
 * */
import java.util.Scanner;

/*������
 * �������͵� SongName ���� Songer ���� double ���͵ĸ���ʱ��
 * ��дObject �е�toString ���� ʹ�����ܷ���Song��������ʽ
 * */
class Song {
	public String SongName;
	public String Songer;
	public double SongTime;
	public Song() {}
	public Song(String SongName,String Songer,double SongTime) {
		this.SongName=SongName;
		this.Songer=Songer;
		this.SongTime=SongTime;
	}
	public String toString() {
		return "���׸������Ϊ:"+this.SongName+"\t�ݳ�����Ϊ:"+this.Songer+"\tʱ��Ϊ:"+this.SongTime;
	}
}


/* 
 * SongDiver �� ��Ϊ���������� �������ж���һЩMaster��Player�����õ��ķ�����Ȼ����Ϊ���� �����Ǽ̳� �ڵ���
 * 
 * */
class SongDiver{
    /*
     * �޲ι��캯�� ʹ�����ڹ����ʱ�� �����дsuper();
     * */
	public SongDiver() {
		
	}
	
	/*
	 * ��Ӹ������� ����ΪString ���͵�SongName ��Master��Playerͨ���������������Ӹ�������赥��������Ҫ������������ʵ��;
	 * */
	public boolean addSong(String SongName) {
		int a=0;//�жϱ���
		for(int i=0;i<SongHouse.SongHouse.size();i++) {//��SongHouse���������ľ�̬���� ����ֱ��ʵ���� ֻ��ͨ������+����������,
			if(SongHouse.SongHouse.get(i).SongName.equals(SongName)) {//�����SongName �����еĽ�������Աȣ���ͬ�� ������һ��
				for(int j=0;j<Master.ListSong.size();j++) {//���ѭ�������ų���ӵĸ�����赥�����ظ���
					if(Master.ListSong.get(j).SongName.equals(SongName)) {
						System.out.println("�벻Ҫ�ظ����!");
						a++;//�жϱ�����+
					} 
				}
				if(a==0) {
				System.out.println("������ӳɹ�!");
				Master.ListSong.add(SongHouse.SongHouse.get(i));
				return true;
			    }else {
					return false;
				}
			}
				
			}
		System.out.println("�Բ���!�����û����������׸�!");
		return false;
	}
	/*
	 * ����赥������������� Master��Player�����Ե���
	 * */
	public void show() {
		System.out.println("�赥�ĸ�������:");
		for(int i=0;i<Master.ListSong.size();i++) {
			System.out.println(Master.ListSong.get(i));
		}
	}

	
}

/*
 * Master�� ����������  �̳�SongDiver�� ���Ե���addSong������show����
 * Master ���еķ���ΪPlay���ŷ��� NextSong�и跽�� Stick�����ö�����
 *  ������һ����̬���� �߼�List���͵�ListSong���ڴ�Ÿ赥
 * */


class Master extends SongDiver{
	
	public static List<Song>ListSong=new ArrayList<Song>();
	
	public 	Master() {
		System.out.println("DJ�ϳ�");
	}
	
	/*
	 * �и跽��
	 * ��ȷ���赥��Ϊ�յ������ ȥ���赥�е�һ�׸�
	 * */
	public void NextSong() {
		if(this.IsEmply()) {
		System.out.println("�и�ɹ�!");	
		Master.ListSong.remove(0);
		this.Play();
	  }else {
		  System.out.println("�赥���ѿ�!");
	  }
	}
	
	public boolean IsEmply() {
		if(Master.ListSong.get(0)==null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/*�ö����� 
	 * ���Ƚ����ҵ��ö������ڸ赥�е�λ�� ������� ���ڸ赥�Ŀ�ʼ����ø�������ɾ������ԭʼλ�õĸ���������������򷵻� false
	 * */
	public boolean stick(String SongName) {
		int j=0;
		for(int i=0;i<Master.ListSong.size();i++) {
			if(Master.ListSong.get(i).SongName.equals(SongName)) {
						System.out.println("�����ö��ɹ�!");
				        Master.ListSong.add(0, Master.ListSong.get(i));
				        Master.ListSong.remove(i+1);
				        j=j+1;
				        return true;
					}
		}
		if(j==0) {
			System.out.println("�Բ���!�����û����������׸�!");	
		    return false;
		}
		return false;
}
	
	public boolean Play() {
		System.out.println("��ʼ����!");
		System.out.println(Master.ListSong.get(0));
		return true;
	}
	
}

/*
 * �������� ���ڵĲ���ֻ����Ӹ��� ���Է������ǵĸ����У�
 * */

class Player extends SongDiver{
	
	public Player() {
		System.out.println("�����볡");
	}

}


/*����һ����� ����ʼʱ ���г�����еĸ��� �������˺͹����ڸ����ѡ��*/
 class  SongHouse{
	public static List<Song>SongHouse=new ArrayList<Song>();
	public SongHouse() {
		SongHouse=new ArrayList<Song>();
		SongHouse.add(new Song("������","�ܽ���",4.5));
		SongHouse.add(new Song("����ҹ���","������",3.5));
		SongHouse.add(new Song("�¹�","�",3.5));
		SongHouse.add(new Song("��","����/���",4.2));
		SongHouse.add(new Song("����ȹ���������","����Ѹ",2.8));
		SongHouse.add(new Song("����","������",3.4));
		SongHouse.add(new Song("����","�ű̳�/����γ",3.5));
		SongHouse.add(new Song("All Night","Icona",3));
		SongHouse.add(new Song("Rather Be","Clean Bandit",4.5));
		SongHouse.add(new Song("ͯ����","��һ��",3));
		SongHouse.add(new Song("That Love","Darin",3.6));
		SongHouse.add(new Song("Just Dance","Lady GaGa",3.6));
		SongHouse.add(new Song("I Am You","Kim Tarloy",4.2));
		SongHouse.add(new Song("��ɫ�߸�Ь","�̽���",2.8));
	}
	public void show() {
		System.out.println("��Ӹ���е��");
		for(int i=0;i<SongHouse.size();i++) {
			System.out.println(SongHouse.get(i));
		}
	}
}

public class disco {
  
	public static void main(String[]args) {
		SongHouse house=new SongHouse();//��ʼ��һ�����ʵ��
		Player player=new Player();//��ʼ��һ������ʵ��
		Master master=new Master();//��ʼ��һ��������ʵ��
		house.show();//չʾ����еĸ���
		Scanner scanner = new Scanner(System.in);
		master.addSong("����");
		player.addSong("������");
		player.addSong("��");
		player.addSong("������");
		master.addSong("Rather Be");
	    master.addSong(scanner.next());//�ֶ� ����һ����������
		master.show();//�����˲鿴�赥
		master.Play();//�����˿�ʼ��������
		master.NextSong();//�������и�
		master.stick("��");//�������и�
		player.show();//���ڲ鿴�赥
	}
}
/*
 * �������
 * �����볡
DJ�ϳ�
��Ӹ���е��
���׸������Ϊ:������	�ݳ�����Ϊ:�ܽ���	ʱ��Ϊ:4.5
���׸������Ϊ:����ҹ���	�ݳ�����Ϊ:������	ʱ��Ϊ:3.5
���׸������Ϊ:�¹�	�ݳ�����Ϊ:�	ʱ��Ϊ:3.5
���׸������Ϊ:��	�ݳ�����Ϊ:����/���	ʱ��Ϊ:4.2
���׸������Ϊ:����ȹ���������	�ݳ�����Ϊ:����Ѹ	ʱ��Ϊ:2.8
���׸������Ϊ:����	�ݳ�����Ϊ:������	ʱ��Ϊ:3.4
���׸������Ϊ:����	�ݳ�����Ϊ:�ű̳�/����γ	ʱ��Ϊ:3.5
���׸������Ϊ:All Night	�ݳ�����Ϊ:Icona	ʱ��Ϊ:3.0
���׸������Ϊ:Rather Be	�ݳ�����Ϊ:Clean Bandit	ʱ��Ϊ:4.5
���׸������Ϊ:ͯ����	�ݳ�����Ϊ:��һ��	ʱ��Ϊ:3.0
���׸������Ϊ:That Love	�ݳ�����Ϊ:Darin	ʱ��Ϊ:3.6
���׸������Ϊ:Just Dance	�ݳ�����Ϊ:Lady GaGa	ʱ��Ϊ:3.6
���׸������Ϊ:I Am You	�ݳ�����Ϊ:Kim Tarloy	ʱ��Ϊ:4.2
���׸������Ϊ:��ɫ�߸�Ь	�ݳ�����Ϊ:�̽���	ʱ��Ϊ:2.8
������ӳɹ�!
������ӳɹ�!
������ӳɹ�!
�벻Ҫ�ظ����!
������ӳɹ�!
��ɫ�߸�Ь
������ӳɹ�!
�赥�ĸ�������:
���׸������Ϊ:����	�ݳ�����Ϊ:�ű̳�/����γ	ʱ��Ϊ:3.5
���׸������Ϊ:������	�ݳ�����Ϊ:�ܽ���	ʱ��Ϊ:4.5
���׸������Ϊ:��	�ݳ�����Ϊ:����/���	ʱ��Ϊ:4.2
���׸������Ϊ:Rather Be	�ݳ�����Ϊ:Clean Bandit	ʱ��Ϊ:4.5
���׸������Ϊ:��ɫ�߸�Ь	�ݳ�����Ϊ:�̽���	ʱ��Ϊ:2.8
��ʼ����!
���׸������Ϊ:����	�ݳ�����Ϊ:�ű̳�/����γ	ʱ��Ϊ:3.5
�и�ɹ�!
��ʼ����!
���׸������Ϊ:������	�ݳ�����Ϊ:�ܽ���	ʱ��Ϊ:4.5
�����ö��ɹ�!
�赥�ĸ�������:
���׸������Ϊ:��	�ݳ�����Ϊ:����/���	ʱ��Ϊ:4.2
���׸������Ϊ:������	�ݳ�����Ϊ:�ܽ���	ʱ��Ϊ:4.5
���׸������Ϊ:Rather Be	�ݳ�����Ϊ:Clean Bandit	ʱ��Ϊ:4.5
���׸������Ϊ:��ɫ�߸�Ь	�ݳ�����Ϊ:�̽���	ʱ��Ϊ:2.8

 * */







