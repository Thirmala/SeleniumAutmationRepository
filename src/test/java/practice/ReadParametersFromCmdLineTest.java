package practice;

import org.testng.annotations.Test;

public class ReadParametersFromCmdLineTest {
	

//public static void main(String[] args) {
//
//		System.out.println(args.length);
//		for(String var : args) {
//			System.out.println(var);
//		}
//	}
	
@Test
	public void testCase() {

		String url=System.getProperty("url");
		System.out.println(url);
}
	
}
