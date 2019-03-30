import java.util.HashMap;

public class EventEmitter {
	
	EventLoop eventLoop;
	HashMap<String, FunctionalInterface> events;
	public EventEmitter(EventLoop eventLoop) {
		this.eventLoop = eventLoop;
		this.events = new HashMap<String, FunctionalInterface>();
	}
	public void addEventListener(String type, FunctionalInterface f) {
		events.put(type, f);
	}
	public void emit(String type) {
		events.forEach((t, f) -> {
			if(t.equals(type))
				eventLoop.eventQueue.add(f);
		});
	}

}
