package main;

import java.io.IOException;

import mastCam.*;
import generic.RoverThreadHandler;

public class MastCamMain {
	public static void main(String[] args) {
		try {
			// create a thread for module one
			Server server = new Server((int)Ports.MASTCAM_PORT);
			Thread serverThread = RoverThreadHandler.getRoverThreadHandler().getNewThread(server);
			serverThread.start();
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
