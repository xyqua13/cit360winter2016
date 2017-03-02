package threadsRunnablesExecutorsSandbox;

public class runnableSandbox implements Runnable{
	private String inputString;
	public runnableSandbox (String in){inputString = in;}
	public void run(){
		for (int i=0; i < 10; i++)
		{System.out.println("Runnable Counter "+inputString+" "+i);}
		System.out.println(Thread.currentThread().getName());
	}
}
