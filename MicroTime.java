package MicroTime;

public class MicroTime 
{
	public static double microtime()
	{
		return (System.currentTimeMillis());
	}
	
	public static String smicrotime ()
	{
		double fullTime = System.currentTimeMillis();
		double epochTime = fullTime / 1000;
		double microSecRemainder = fullTime - epochTime;
	
		return ("" + epochTime + "." + microSecRemainder);
	}
}