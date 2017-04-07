package finalProject;
import java.util.HashMap;
public class commandManager {
	private HashMap<String,Handler> handlerMap = new HashMap();
	
	public HashMap<String, Object> handleRequest(String command, HashMap<String,Object> data){
		Handler theCommandHandler = handlerMap.get(command);
		if (theCommandHandler != null){
			data = theCommandHandler.handleIt(data);
		}
		return data;
	}
	public void mapCommand(String theCommand, Handler theHandler){
		handlerMap.put(theCommand,theHandler);
	}
	
}
