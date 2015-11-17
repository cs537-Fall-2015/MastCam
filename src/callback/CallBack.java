package callback;

import java.net.UnknownHostException;

public class CallBack {
	
public CallBack() {
		
	}
	
	public void done() {
		CallBackClient client = null;
		try {
			client = new CallBackClient(9009, null);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.run();
	}
}
