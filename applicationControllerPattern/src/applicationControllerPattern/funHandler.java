package applicationControllerPattern;

import java.util.HashMap;

public class funHandler implements Handler{

	@Override
	public void handleIt(HashMap<String, Object> data) {
		System.out.println("FUN FUN FUN");
		
	}
	
}
