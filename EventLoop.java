import java.util.ArrayList;

public class EventLoop implements Runnable{
	
	ArrayList<EventInterface> eventQueue;
	public EventLoop() {
		this.eventQueue = new ArrayList<EventInterface>();
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(eventQueue.size() > 0)
				eventQueue.remove(0).run();
		}
		
	}
	
	

}
