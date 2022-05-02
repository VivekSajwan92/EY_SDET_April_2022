package datastrucutresAndAlgorithms.ey.training.week5.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class DestinationCity {
	
	@Test
	public void test() {
		List<List<String>> paths = new ArrayList<List<String>>();
		paths.add(Arrays.asList(new String[] {"London","New York"}));
		paths.add(Arrays.asList(new String[] {"New York","Lima"}));
		paths.add(Arrays.asList(new String[] {"Lima","Sao Paulo"}));
		paths.add(Arrays.asList(new String[] {"Lima","Chennai"}));
		System.out.println(destCity(paths));
	}
	
	 public String destCity(List<List<String>> paths) {
		 HashSet<String> set = new HashSet<>();
		 
		 for(List<String> source: paths) {
			 set.add(source.get(0));
		 }
		 
		 for(List<String> destination: paths) {
			 if(!set.contains(destination.get(1))) return destination.get(1);
		 }
		 return null;
	 }

}
