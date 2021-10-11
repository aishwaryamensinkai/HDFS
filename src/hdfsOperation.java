import java.util.Timer;
import java.util.TimerTask;

public class hdfsOperation {

	public static void main(String[] args){
		 Timer timer =new Timer();
	     TimerTask task = new Helper();
	     timer.schedule(task, 2000, 30000);
	}
	
}
