package homework;
/*
 * 引入这两个包后才能使用高级类型List
 * */
import java.util.ArrayList;
import java.util.List;
/*
 * 引入这个包可以进行键盘输入
 * */
import java.util.Scanner;

/*歌曲类
 * 公共类型的 SongName 歌名 Songer 歌手 double 类型的歌曲时长
 * 重写Object 中的toString 函数 使函数能符合Song类的输出方式
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
		return "这首歌的名称为:"+this.SongName+"\t演唱歌手为:"+this.Songer+"\t时长为:"+this.SongTime;
	}
}


/* 
 * SongDiver 类 作为歌曲控制类 可在类中定义一些Master和Player都能用到的方法，然后作为父类 让他们继承 在调用
 * 
 * */
class SongDiver{
    /*
     * 无参构造函数 使子类在构造的时候 无需编写super();
     * */
	public SongDiver() {
		
	}
	
	/*
	 * 添加歌曲函数 参数为String 类型的SongName 让Master和Player通过输入歌名即可添加歌曲进入歌单，而不需要输入整个对象实例;
	 * */
	public boolean addSong(String SongName) {
		int a=0;//判断变量
		for(int i=0;i<SongHouse.SongHouse.size();i++) {//在SongHouse类中声明的静态变量 不能直接实例化 只能通过类名+属性名调用,
			if(SongHouse.SongHouse.get(i).SongName.equals(SongName)) {//输入的SongName 与歌库中的进行逐项对比，相同了 进行下一步
				for(int j=0;j<Master.ListSong.size();j++) {//这个循环是来排除添加的歌曲与歌单中有重复的
					if(Master.ListSong.get(j).SongName.equals(SongName)) {
						System.out.println("请不要重复添加!");
						a++;//判断变量加+
					} 
				}
				if(a==0) {
				System.out.println("歌曲添加成功!");
				Master.ListSong.add(SongHouse.SongHouse.get(i));
				return true;
			    }else {
					return false;
				}
			}
				
			}
		System.out.println("对不起!歌库中没有您点的这首歌!");
		return false;
	}
	/*
	 * 输出歌单函数，这个函数 Master和Player都可以调用
	 * */
	public void show() {
		System.out.println("歌单的歌曲如下:");
		for(int i=0;i<Master.ListSong.size();i++) {
			System.out.println(Master.ListSong.get(i));
		}
	}

	
}

/*
 * Master类 主持人类型  继承SongDiver类 可以调用addSong方法和show方法
 * Master 独有的方法为Play播放方法 NextSong切歌方法 Stick歌曲置顶方法
 *  定义了一个静态变量 高级List类型的ListSong用于存放歌单
 * */


class Master extends SongDiver{
	
	public static List<Song>ListSong=new ArrayList<Song>();
	
	public 	Master() {
		System.out.println("DJ上场");
	}
	
	/*
	 * 切歌方法
	 * 在确定歌单不为空的情况下 去掉歌单中第一首歌
	 * */
	public void NextSong() {
		if(this.IsEmply()) {
		System.out.println("切歌成功!");	
		Master.ListSong.remove(0);
		this.Play();
	  }else {
		  System.out.println("歌单歌已空!");
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
	
	/*置顶方法 
	 * 首先将先找到置顶歌曲在歌单中的位置 如果存在 则将在歌单的开始插入该歌曲，并删除掉齐原始位置的歌曲，如果不存在则返回 false
	 * */
	public boolean stick(String SongName) {
		int j=0;
		for(int i=0;i<Master.ListSong.size();i++) {
			if(Master.ListSong.get(i).SongName.equals(SongName)) {
						System.out.println("歌曲置顶成功!");
				        Master.ListSong.add(0, Master.ListSong.get(i));
				        Master.ListSong.remove(i+1);
				        j=j+1;
				        return true;
					}
		}
		if(j==0) {
			System.out.println("对不起!歌库中没有您点的这首歌!");	
		    return false;
		}
		return false;
}
	
	public boolean Play() {
		System.out.println("开始播放!");
		System.out.println(Master.ListSong.get(0));
		return true;
	}
	
}

/*
 * 观众类型 观众的操作只有添加歌曲 所以放入他们的父类中；
 * */

class Player extends SongDiver{
	
	public Player() {
		System.out.println("观众入场");
	}

}


/*创建一个歌库 程序开始时 先列出歌库中的歌曲 让主持人和观众在歌库中选择*/
 class  SongHouse{
	public static List<Song>SongHouse=new ArrayList<Song>();
	public SongHouse() {
		SongHouse=new ArrayList<Song>();
		SongHouse.add(new Song("七里香","周杰伦",4.5));
		SongHouse.add(new Song("你把我灌醉","邓紫棋",3.5));
		SongHouse.add(new Song("月光","李建",3.5));
		SongHouse.add(new Song("神话","韩红/孙楠",4.2));
		SongHouse.add(new Song("陪你度过漫长岁月","陈奕迅",2.8));
		SongHouse.add(new Song("体面","于文文",3.4));
		SongHouse.add(new Song("凉凉","张碧晨/杨宗纬",3.5));
		SongHouse.add(new Song("All Night","Icona",3));
		SongHouse.add(new Song("Rather Be","Clean Bandit",4.5));
		SongHouse.add(new Song("童话镇","陈一发",3));
		SongHouse.add(new Song("That Love","Darin",3.6));
		SongHouse.add(new Song("Just Dance","Lady GaGa",3.6));
		SongHouse.add(new Song("I Am You","Kim Tarloy",4.2));
		SongHouse.add(new Song("红色高跟鞋","蔡健雅",2.8));
	}
	public void show() {
		System.out.println("请从歌库中点歌");
		for(int i=0;i<SongHouse.size();i++) {
			System.out.println(SongHouse.get(i));
		}
	}
}

public class disco {
  
	public static void main(String[]args) {
		SongHouse house=new SongHouse();//初始化一个歌库实例
		Player player=new Player();//初始化一个观众实例
		Master master=new Master();//初始化一个主持人实例
		house.show();//展示歌库中的歌曲
		Scanner scanner = new Scanner(System.in);
		master.addSong("凉凉");
		player.addSong("七里香");
		player.addSong("神话");
		player.addSong("七里香");
		master.addSong("Rather Be");
	    master.addSong(scanner.next());//手动 输入一个歌曲名字
		master.show();//主持人查看歌单
		master.Play();//主持人开始播放音乐
		master.NextSong();//主持人切歌
		master.stick("神话");//主持人切歌
		player.show();//观众查看歌单
	}
}
/*
 * 输出如下
 * 观众入场
DJ上场
请从歌库中点歌
这首歌的名称为:七里香	演唱歌手为:周杰伦	时长为:4.5
这首歌的名称为:你把我灌醉	演唱歌手为:邓紫棋	时长为:3.5
这首歌的名称为:月光	演唱歌手为:李建	时长为:3.5
这首歌的名称为:神话	演唱歌手为:韩红/孙楠	时长为:4.2
这首歌的名称为:陪你度过漫长岁月	演唱歌手为:陈奕迅	时长为:2.8
这首歌的名称为:体面	演唱歌手为:于文文	时长为:3.4
这首歌的名称为:凉凉	演唱歌手为:张碧晨/杨宗纬	时长为:3.5
这首歌的名称为:All Night	演唱歌手为:Icona	时长为:3.0
这首歌的名称为:Rather Be	演唱歌手为:Clean Bandit	时长为:4.5
这首歌的名称为:童话镇	演唱歌手为:陈一发	时长为:3.0
这首歌的名称为:That Love	演唱歌手为:Darin	时长为:3.6
这首歌的名称为:Just Dance	演唱歌手为:Lady GaGa	时长为:3.6
这首歌的名称为:I Am You	演唱歌手为:Kim Tarloy	时长为:4.2
这首歌的名称为:红色高跟鞋	演唱歌手为:蔡健雅	时长为:2.8
歌曲添加成功!
歌曲添加成功!
歌曲添加成功!
请不要重复添加!
歌曲添加成功!
红色高跟鞋
歌曲添加成功!
歌单的歌曲如下:
这首歌的名称为:凉凉	演唱歌手为:张碧晨/杨宗纬	时长为:3.5
这首歌的名称为:七里香	演唱歌手为:周杰伦	时长为:4.5
这首歌的名称为:神话	演唱歌手为:韩红/孙楠	时长为:4.2
这首歌的名称为:Rather Be	演唱歌手为:Clean Bandit	时长为:4.5
这首歌的名称为:红色高跟鞋	演唱歌手为:蔡健雅	时长为:2.8
开始播放!
这首歌的名称为:凉凉	演唱歌手为:张碧晨/杨宗纬	时长为:3.5
切歌成功!
开始播放!
这首歌的名称为:七里香	演唱歌手为:周杰伦	时长为:4.5
歌曲置顶成功!
歌单的歌曲如下:
这首歌的名称为:神话	演唱歌手为:韩红/孙楠	时长为:4.2
这首歌的名称为:七里香	演唱歌手为:周杰伦	时长为:4.5
这首歌的名称为:Rather Be	演唱歌手为:Clean Bandit	时长为:4.5
这首歌的名称为:红色高跟鞋	演唱歌手为:蔡健雅	时长为:2.8

 * */







