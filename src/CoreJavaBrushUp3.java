
public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		//String is an object that represents characters  //String literal
		
		
//		String s1= "Rahul Shetty Academy";
		String s5 = "hello";
		//In string literal if you have same multiple values it will refer to the old value but in this no matter we have same string values it will still explicitey create new memory
		
		
		//new memory allocated
		String s2 = new String("Welcome");
		String s3 = new String("Welcome");
		
		String s = "Rahul Shetty Academy";
		String [] splittedstring = s.split("Shetty");
		System.out.println(splittedstring[0]);
		System.out.println(splittedstring[1]);
		System.out.println(splittedstring[1].trim()); //trim() trims left and right spaces
		 
		for(int i=0;i<s.length();i++) {
			System.out.println(s.charAt(i)); //it will retrieve the character present at that index.
		}
		
		//print the string in reverse order
		
		for (int i=s.length()-1;i>=0;i--)
		{
			System.out.println(s.charAt(i));
		}
		
		
	}

}
