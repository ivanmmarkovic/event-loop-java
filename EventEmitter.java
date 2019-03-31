import java.util.ArrayList;

public class EventEmitter {
	
	EventLoop eventLoop;
	ArrayList<Event> events;
	public EventEmitter(EventLoop eventLoop) {
		this.eventLoop = eventLoop;
		this.events = new ArrayList<Event>();
	}
	public void addEventListener(String type, FunctionalInterface f) {
		events.add(new Event(type, f));
	}
	public void emit(String type) {
		for(Event e: this.events)
			if(e.type.equals(type))
				eventLoop.eventQueue.add(e.f);
	}

}
