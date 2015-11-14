package mastCam.mastCam_testMain;

import generic.RoverThreadHandler;

import java.io.IOException;

import mastCam.Ports;
import mastCam.Server;

public class TestMain {
	public static void main(String[] args) {
		try {
	
			
			Server server = new Server((int) Ports.MASTCAM_PORT);
			Thread serverThread = RoverThreadHandler.getRoverThreadHandler()
					.getNewThread(server);
			serverThread.start();

			Client client = new Client((int) Ports.MASTCAM_PORT, null, 1);
			Thread clientThread = RoverThreadHandler.getRoverThreadHandler()
					.getNewThread(client);
			clientThread.start();

		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
