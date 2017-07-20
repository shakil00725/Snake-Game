
public class dataArray {
	
	public String name;
	public int number;
	
	
	public static dataArray[] dataArrayset(int size) {
		 dataArray[] p= new dataArray[size];
	        for(int i=0; i<size; i++)
	            p[i] = new dataArray();
	        return p;
	   }
	void main()
	{
		
		dataArray[] p = dataArray.dataArrayset(11);
		p[0].name="shakil";
		
	}
	

}
