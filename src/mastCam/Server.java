package mastCam;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import callback.CallBack;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import json.MyWriter;
import generic.RoverServerRunnable;

public class Server extends RoverServerRunnable {
Controller cameraController;
	
	public Server(int port) throws IOException {
		super(port);
	}

	
	@Override
	public void run() {

		cameraController = new Controller();
		
		try {

			while (true) {
				
				System.out.println("MastCam Server: Waiting for client request");
				
				// creating socket and waiting for client connection
				getRoverServerSocket().openSocket();
				
				// read from socket to ObjectInputStream object
				ObjectInputStream inputFromAnotherObject = new ObjectInputStream(getRoverServerSocket().getSocket().getInputStream());
				
				// convert ObjectInputStream object to String
				String message = (String) inputFromAnotherObject.readObject();
				Thread.sleep(1000);
				System.out.println("MastCam Server: Message Received from Client - "+ message.toUpperCase());
				
				// create ObjectOutputStream object
				ObjectOutputStream outputToAnotherObject = new ObjectOutputStream(
						getRoverServerSocket().getSocket().getOutputStream());
				
				
				// getRoverServerSocket().closeSocket();
				// terminate the server if client sends exit request
				if(message.equalsIgnoreCase(Commands.MCAM_PWR_ON.toString())){
					// Call Power: request power
					Thread.sleep(1000);
					System.out.println("MastCam powered on");
					cameraController.currentMastCam.setOn(true);
					//savePrintAndCallBack();
					
				/*	Client mastCamAsClient = new Client((int)Ports.POWER_ENERGY_PORT, null, 1);
					Thread mastCamClientThread = RoverThreadHandler.getRoverThreadHandler().getNewThread(mastCamAsClient);
					mastCamClientThread.start();
*/				}
				else if(message.equalsIgnoreCase(Commands.MCAM_PWR_OFF.toString())){
					Thread.sleep(1000);
					// Call Power: turn off
					System.out.println("MastCam powered off");
					cameraController.currentMastCam.setOn(false);
					//savePrintAndCallBack();
					
/*					Client mastCamAsClient = new Client((int)Ports.POWER_ENERGY_PORT, null, 2);
					Thread mastCamClientThread = RoverThreadHandler.getRoverThreadHandler().getNewThread(mastCamAsClient);
					mastCamClientThread.start();
*/				}
				else if(message.equalsIgnoreCase(Commands.MCAM_CAPTR_STILL.toString())){
					Thread.sleep(3000);
					System.out.println("MastCam captured still image");
					if(cameraController.currentMastCam.isOn()){
						cameraController.currentMastCam.capturePhoto("still");
					}
					else {
						System.out.println("ERROR: Camera is off");
					}

					//savePrintAndCallBack();					
				}
				else if(message.equalsIgnoreCase(Commands.MCAM_CAPTR_PANRMA.toString())){
					Thread.sleep(3000);
					System.out.println("MastCam captured panorama");
					if(cameraController.currentMastCam.isOn()){
						cameraController.currentMastCam.capturePhoto("panorama");
					}
					else {
						System.out.println("ERROR: Camera is off");
					}
					
					//savePrintAndCallBack();
				}
				else if(message.equalsIgnoreCase(Commands.MCAM_CAPTR_VID.toString())){
					Thread.sleep(3000);
					System.out.println("MastCam captured video");
					if(cameraController.currentMastCam.isOn()){
						cameraController.currentMastCam.captureVideo();
					}
					else {
						System.out.println("ERROR: Camera is off");
					}
					
					//savePrintAndCallBack();
				}
				else if(message.equalsIgnoreCase(Commands.MCAM_RTN_THBMNL.toString())){
					System.out.println("MastCam creating thumbnail");
					Thread.sleep(3000);
					System.out.println("MastCam returned thumbnail");
					if(cameraController.currentMastCam.isOn()){
						cameraController.currentMastCam.returnPhoto("thumbnail");
					}
					else {
						System.out.println("ERROR: Camera is off");
					}
					
				//	savePrintAndCallBack();
				}
				else if(message.equalsIgnoreCase(Commands.MCAM_RTN_CMPRSD.toString())){
					Thread.sleep(3000);
					System.out.println("MastCam creating compressed image");
					
					Thread.sleep(1000);
					System.out.println("MastCam returned compressed image");
					if(cameraController.currentMastCam.isOn()){
						cameraController.currentMastCam.returnPhoto("compressed");
					}
					else {
						System.out.println("ERROR: Camera is off");
					}
					
					//savePrintAndCallBack();
				}
				else if(message.equalsIgnoreCase(Commands.MCAM_RTN_ORIG.toString())){
					Thread.sleep(3000);
					System.out.println("MastCam returned raw image");
					if(cameraController.currentMastCam.isOn()){
						cameraController.currentMastCam.returnPhoto("original");
					}
					else {
						System.out.println("ERROR: Camera is off");
					}
					
					//savePrintAndCallBack();
				}
				else if(message.equalsIgnoreCase(Commands.MCAM_RTN_VID.toString())){
					Thread.sleep(3000);
					System.out.println("MastCam returned video");
					if(cameraController.currentMastCam.isOn()){
						cameraController.currentMastCam.returnVideo();
					}
					else {
						System.out.println("ERROR: Camera is off");
					}
					
					//savePrintAndCallBack();
				}
				else if(message.toLowerCase().contains((Commands.MCAM_SLCT_FLTR.toString().toLowerCase()))){
					Thread.sleep(3000);
					System.out.println("MastCam selected filter");
					if(cameraController.currentMastCam.isOn()){
						String[] messageArray = message.toLowerCase().split(" ");
						if(messageArray.length == 2 && messageArray[1] != null){
							int filterNumber = Integer.parseInt(messageArray[1]);
							if(filterNumber > 0 && filterNumber < 8){
								cameraController.currentMastCam.setCurrentFilter(filterNumber);
							}
						}
					}
					else {
						System.out.println("ERROR: Camera is off");
					}
					
					//savePrintAndCallBack();
				}
				else if(message.toLowerCase().contains((Commands.MCAM_SLCT_CAM_100.toString().toLowerCase()))){
					Thread.sleep(3000);
					System.out.println("MastCam selected camera 100");
					if(message.toLowerCase().contains((Commands.MCAM_SLCT_CAM_100.toString().toLowerCase()))) cameraController.selectCamera100(true);
				//	if(message.toLowerCase().contains("34")) cameraController.selectCamera100(false);
					cameraController.currentMastCam.setOn(true);
					
					savePrintAndCallBack();
				}
				else if(message.toLowerCase().contains((Commands.MCAM_SLCT_CAM_34.toString().toLowerCase()))){
					Thread.sleep(3000);
					System.out.println("MastCam selected camera 34");
					//if(message.toLowerCase().contains("100")) cameraController.selectCamera100(true);
					if(message.toLowerCase().contains((Commands.MCAM_SLCT_CAM_34.toString().toLowerCase()))) cameraController.selectCamera100(false);
					//cameraController.currentMastCam.setOn(true);
					
					savePrintAndCallBack();
				}
				else if(message.equalsIgnoreCase(Commands.MCAM_CLR.toString())){
					Thread.sleep(4000);
					System.out.println("MastCam cleared memory");
					if(cameraController.currentMastCam.isOn()){
						cameraController.currentMastCam.clearMemory();
					}
					else {
						System.out.println("ERROR: Camera is off");
					}
					
				//	savePrintAndCallBack();
				}else if(message.equalsIgnoreCase("EXIT")){
					break;
				}
				else{
					System.out.println("Invalid Command");
				}
				
				// write object to Socket
				outputToAnotherObject.writeObject("MastCam Server response - "
						+ message);

				// close resources
				inputFromAnotherObject.close();
				outputToAnotherObject.close();
				
				/*if (message.equalsIgnoreCase("exit"))
					break;*/
				
			}
			System.out.println("Server: Shutting down Socket server!!");
			// close the ServerSocket object
			closeAll();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception error) {
			System.out.println("Server: Error: " + error.getMessage());
		}

	}
	
	private void savePrintAndCallBack(){
		@SuppressWarnings("unused")
		//MyWriter JSONWriter = new MyWriter(cameraController, 6);
		MyWriter JSONWriter = new MyWriter(cameraController.currentMastCam, 6);
		
		// Gson is used to create a json object that is spaced nicely
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		// Object is converted to a JSON String
		String jsonString = gson.toJson(cameraController.currentMastCam);
		System.out.println(jsonString);
		
		CallBack cb = new CallBack();
		//cb.done();
	}

}
