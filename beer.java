public class beer{
   public static void main(String[]args){
         int  num=99;	
		 for(int i=num;i>=0;i--)
		{
			if(i==2||i==1)
			{
				System.out.println(i+"bottles of beer on the wall,"+i+"bottles of beer.\nTake one down\nPass it around \n"+(i-1)+"bottle of beer on the wall\n");
			}
	        else if(i==0)
			{
				
				System.out.println("no more bottles of beer on the wall");
			}
			else{
				
				System.out.println(i+"bottles of beer on the wall,"+i+"bottles of beer.\nTake one down\nPass it around "+(i-1)+"bottles of beer on the wall");
				
			}
			
			
		} 
	   
	 
	   
	   
   }


}