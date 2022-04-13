package datastrucutresAndAlgorithms.ey.training.week2.day3;

import java.util.Arrays;

import org.junit.Test;
import org.openjdk.jol.vm.VM;

public class StingInternals {

	private void initialisation() {
		String literal = "type 1";

		String init = new String("type 1");

		String charArray = new String(new char[] {'t','e','s','t'});

		System.out.println(init+" "+charArray);
	}

	private void internals() {
		String[] array = {"test","test","test","test","test"};

		printarr(array);

		array[0] += "1";

		printarr(array);

		String a = new String();
		a ="test";
	}


	private void memory() {
		String one = "test";
		String two = new String("test");

		System.out.println(one == two);
		System.out.println(VM.current().addressOf(one));
		System.out.println(VM.current().addressOf(two));

		// accessing a method inside an class through object
		// one is the object -> equals in the string class
		System.out.println(one.equals(two));

		String three = "test";
		System.out.println(one.equals(three));
		if(one==three)
			System.out.println("equalling ref");




	}


	private void methods() {
		String a  ="test";


		System.out.println(Arrays.toString(a.toCharArray()));

		System.out.println(Arrays.toString(a.split("")));
		System.out.println(a.toCharArray().getClass());

		System.out.println(a.split("").getClass());

		String b = new String("test");

		System.out.println(a==b.intern());


		System.out.println(VM.current().addressOf(a));
		System.out.println(VM.current().addressOf(b));
		System.out.println(VM.current().addressOf(b.intern()));



		System.out.println(a.charAt(2));
		System.out.println(a.codePointAt(2));
		System.out.println(a.contains("ese"));
		System.out.println(a.equals("test"));
		System.out.println(a.equalsIgnoreCase("TEST"));
		System.out.println(a.length());
		System.out.println("   te  st     ".trim());
		
		String.valueOf('c');
		System.out.println(a.substring(0, 2));
		
		System.out.println("test".replace("te", "*"));
		System.out.println("test".replace("[a-z]", "*"));
		System.out.println("test".replaceAll("[a-z]", "*"));
		System.out.println("test".replaceAll("te", "*"));

	}

	private void printarr(String[] array) {
		System.out.println(VM.current().addressOf(array[0]));
		System.out.println(VM.current().addressOf(array[1]));
		System.out.println(VM.current().addressOf(array[2]));
		System.out.println(VM.current().addressOf(array[3]));
	}


	@Test
	public void tc() {
		methods();
	}
}
