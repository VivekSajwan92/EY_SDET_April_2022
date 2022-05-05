package datastrucutresAndAlgorithms.ey.training.week5.day21;

import java.util.Stack;

import org.junit.Test;

public class SimplifiedPath {
	
	@Test
	public void td1() {
		System.out.println(simplifyPath("/a/./b/../../c/"));
	}
	
	public String simplifyPath(String path) {
		Stack<String> pathStack = new Stack<String>();
		String[] inputArray = path.split("/");

		for(String eachWord: inputArray){
			if(eachWord.equals("..")){
				if(!pathStack.isEmpty())
					pathStack.pop();
			}else if(!(eachWord.isEmpty()||eachWord.equals("."))){
				pathStack.push(eachWord);
			}
		}

		if(pathStack.isEmpty())
			return "/";
		else{
			String output ="";
			for(String pathBuild:pathStack){
				output +="/"+pathBuild;
			}
			return output;
		}
	}   
}
