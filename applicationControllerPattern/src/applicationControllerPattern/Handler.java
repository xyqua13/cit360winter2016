package applicationControllerPattern;

import java.util.HashMap;
public interface Handler {
	public void handleIt(HashMap<String, Object> data);
}