package applicationControllerPattern;

import java.util.HashMap;

public class boringHandler implements Handler{

	@Override
	public void handleIt(HashMap<String, Object> data) {
		System.out.println(data.get("Number"));
		System.out.println("Boring stuff....");
	}

}
