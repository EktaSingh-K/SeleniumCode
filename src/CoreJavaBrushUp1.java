import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int myNum = 5;
		String website = "Rahul sheety Academy";
		char letter = 'r';
		double dec = 5.99;
		boolean myCard = true;
		
		System.out.println(myNum+ " is the value stored in the myNum variable");
		System.out.println(website);
		
		//Arrays- 
		
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 5;
		arr[4] = 6;
		
//		or
		
		int[] arr2 = {1,2,4,5,6};
		
		System.out.println(arr2[0]);
		
// for loop arr.length - 5
		
		for(int i=0; i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
	
// 
	for (int i=0; i<arr2.length;i++) 
	{
		System.out.println(arr2[i]);
	}
	
	
	String[] name = {"rahul","shetty","selenium"};
	for(int i=0;i<name.length;i++)
	{
		System.out.println(name[i]);
	}
	
	for( String s:name)
	{
		System.out.println(s);
	}
	
	ArrayList<String> a = new ArrayList<String>();
	a.add("rahul");
	a.add("shetty");
	a.add("academy");
	a.add("selenium");
//  a.remove(2);
	System.out.println(a.get(3));
	
	for(int i=0; i<a.size();i++)
	
	{
		System.out.println(a.get(i)); //retrieves the item from array list
	}
	
	System.out.println("*******");
	
	//enhanced for loop
	
	for(String val:a) {
		System.out.println(val);
	}
	
	// item is present in the array list
	System.out.println(a.contains("selenium"));
	String[] name2 = {"rahul" , "shetty" , "academy"};
	List<String> name2ArrayList = Arrays.asList(name2); //converting normal  array to ArrayList
	name2ArrayList.contains("selenium");
	
	
	
	
	
	
  }
}
