
public class MethodsDemo {

	public static void main(String[] args) {
		
		MethodsDemo d = new MethodsDemo();
		String name =  d.getData();
		System.out.println(name);
		MethodsDemo2 d1 = new MethodsDemo2();
		String name2 = d1.getUserData();
		//System.out.println(name2);
		getData2();
	}
	
	public String getData() {
		System.out.println("Hello World 1");
		return "Rahul Shetty";
	}
   //static keyword will make your method to move to class level without creating object
	public static String getData2() {
		System.out.println("Hello World 3");
		return "Rahul Shetty";
	}
	
}
