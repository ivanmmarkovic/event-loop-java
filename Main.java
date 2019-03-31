
public class Main {

	public static void main(String[] args) {
		
		EventLoop eventLoop = new EventLoop();
		new Thread(eventLoop).start();
		
		EventEmitter emitter1 = new EventEmitter(eventLoop);
		emitter1.addEventListener("click", () -> {
			System.out.println("Click event on emitter1");
		});
		
		EventEmitter emitter2 = new EventEmitter(eventLoop);
		emitter2.addEventListener("click", () -> {
			System.out.println("Click event on emitter2");
		});
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				emitter2.emit("click");
				
			}
		}).start();
		
		emitter2.emit("click");
		emitter2.addEventListener("click", () -> {
			System.out.println("Second click event on emitter2");
		});
		emitter1.emit("click");
		

	}

}
