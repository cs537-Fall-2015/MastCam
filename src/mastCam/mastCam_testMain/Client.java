package mastCam.mastCam_testMain;

import generic.RoverClientRunnable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client extends RoverClientRunnable {

	int outgoingCommandNumber;
	public Client(int port, InetAddress host, int commandNumber)
			throws UnknownHostException {
		super(port, host);
		outgoingCommandNumber = commandNumber; 
	}
	
	 @Override
	    public void run() {
		 
		 File appBase = new File("src/mastCam/mastCam_testMain/Commands.txt");                 //to determine current directory
		 String path = appBase.getAbsolutePath();
		 
		 try(    BufferedReader br = new BufferedReader(new FileReader(path))) {
			    
			    String line = br.readLine();	    	
				 
			    while (line != null) {			        
			        sendMessage(line);
			        line = br.readLine();
			    }
			    closeAll();
			    //String everything = sb.toString();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    
	        
	    /*    sendMessage("MCAM_PWR_ON");
	        
	        sendMessage("MCAM_SLCT_CAM");
	        
	        sendMessage("MCAM_CAPTR_PANRMA");
	        
	        sendMessage("MCAM_RTN_THBMNL");
	        
	        sendMessage("MCAM_RTN_CMPRSD");
	        
	        sendMessage("MCAM_RTN_ORIG");
	        
	        sendMessage("MCAM_CAPTR_STILL");
	        
	        sendMessage("MCAM_CAPTR_VID");
	        
	        sendMessage("MCAM_RTN_VID");
	        
	        sendMessage("MCAM_CLR");
	        
	        sendMessage("MCAM_PWR_OFF");
	        
	        sendMessage("exit");*/
	        
	        try {
	            closeAll();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	    
	    void sendMessage(String msg) {
	        try {
	            ObjectOutputStream outputToAnotherObject = null;
	            ObjectInputStream inputFromAnotherObject = null;
	            Thread.sleep(500);
	            
	            // Send 5 messages to the Server
	            
	            // write to socket using ObjectOutputStream
	            outputToAnotherObject = new ObjectOutputStream(getRoverSocket()
	                                                           .getNewSocket().getOutputStream());
	            
	            System.out
	            .println("=================================================");
	            System.out
	            .println("MastCam Client: Sending request to Socket Server");
	            System.out
	            .println("=================================================");
	            
	            outputToAnotherObject.writeObject(msg);
	            
	            // read the server response message
	            inputFromAnotherObject = new ObjectInputStream(getRoverSocket()
	                                                           .getSocket().getInputStream());
	            String message = (String) inputFromAnotherObject.readObject();
	            System.out.println("MastCam Client received: "
	                               + message.toUpperCase());
	            
	            // close resources
	            inputFromAnotherObject.close();
	            outputToAnotherObject.close();
	            Thread.sleep(100);
	            closeAll();
	            
	        } catch (UnknownHostException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (Exception error) {
	          //  System.out.println("Client: Error:" + error.getMessage());
	        }
	    }
}
