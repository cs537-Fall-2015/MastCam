package MastcamModule;

import java.io.IOException;
import java.io.ObjectInputStream;

import generic.RoverServerRunnable;

public class Server extends RoverServerRunnable {

	public Server(int port) throws IOException {
		super(port);
	}

	public static void main(String[] args) {
		System.out.println("Hi, This is server file.");

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			while (true) {

				System.out
						.println("MastCam Server: Waiting for client request");

				// creating socket and waiting for client connection
				getRoverServerSocket().openSocket();

				// read from socket to ObjectInputStream object
				ObjectInputStream inputFromAnotherObject = new ObjectInputStream(
						getRoverServerSocket().getSocket().getInputStream());

				// convert ObjectInputStream object to String
				String message = (String) inputFromAnotherObject.readObject();
				System.out
						.println("MastCam Server: Message Received from Client - "
								+ message.toUpperCase());
			}
		} catch (Exception error) {
			System.out.println("Server: Error: " + error.getMessage());
		}

	}

}
