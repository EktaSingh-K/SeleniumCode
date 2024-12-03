import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> names = new ArrayList<String>();
		names.add("Ashish");
		names.add("Ekta");
		names.add("Aishwarya");
		names.add("Aeww");
		names.add("Andhan");
		
		Long cc = names.stream().filter(s->s.startsWith("E")).count();
		System.out.println(cc);

		
		Long finalcount = Stream.of("Bon" , "Jon" , "Pon").filter(a->
				{
					return a.endsWith("n");
					
				}).count();
		
		System.out.println(finalcount);
		
		names.stream().filter(s->s.length()>=5).limit(2).map(b->b.toLowerCase()).forEach(a->System.out.println(a));
		
//		Take two arraylists and combinedly sort them with uppercase
		
		String[] names2 = {"Langda" ,  "Behra" ,  "Deaf"};
        List<String> arraylist = Arrays.asList(names2);   
        
       Stream<String> newstream = Stream.concat(names.stream(), arraylist.stream());
//       newstream.sorted().map(c->c.toUpperCase()).forEach(d->System.out.println("Final String "+d));
//      Boolean result =  newstream.anyMatch(e->e.equalsIgnoreCase("Bandhan"));
//      Assert.assertTrue(result);

      List<String> newlist =  newstream.collect(Collectors.toList());
      System.out.println(" This is my new list "+newlist.get(1));
      
//    distinct() is used to remove the duplicate values from arraylist. 
//      E.g - 1 , 2 , 2 , 3, 5 , 1 after appliying distinct() method the output is 1 , 2 , 3 , 5 [duplicate numbers are removed]
      

	}
	
	
	
	
	

	
}
