package MastcamModule.testmainMastCam;

import generic.RoverThreadHandler;

import java.io.IOException;

import MastcamModule.Client;
import MastcamModule.Ports;
import MastcamModule.Server;

public class MastCam_testmain {

	public static void main(String[] args) {
		try {
			// create a thread for module one
			Server server = new Server((int)Ports.MASTCAM_PORT);
			Thread serverThread = RoverThreadHandler.getRoverThreadHandler().getNewThread(server);
			serverThread.start();
			
			Client client = new Client((int)Ports.MASTCAM_PORT, null,1);
			Thread clientThread = RoverThreadHandler.getRoverThreadHandler().getNewThread(client);
			clientThread.start();
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
