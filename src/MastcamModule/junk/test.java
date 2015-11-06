package MastcamModule.junk;

import generic.RoverThreadHandler;

import java.io.IOException;

import MastcamModule.Ports;
import MastcamModule.Server;

public class test {

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
