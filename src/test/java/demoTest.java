import java.io.IOException;
import java.util.ArrayList;

public class demoTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dataDriven d =new dataDriven();
		
		ArrayList testData = d.getData("Add Profile");
		
		System.out.println(testData.get(0));
		System.out.println(testData.get(1));
		System.out.println(testData.get(2));
		System.out.println(testData.get(3));

		
		
	}

}
