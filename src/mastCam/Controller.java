package mastCam;

import mastCam.hardware.Camera;
import mastCam.hardware.CameraTypes;

public class Controller {
	private Camera mastCam34;
	private Camera mastCam100;
	public Camera currentMastCam;
	
	public Controller(){
		mastCam34 = new Camera(CameraTypes.MastCam34);
		mastCam100 = new Camera(CameraTypes.MastCam100);
		currentMastCam = mastCam100;
	}
	
	public void setCurrentCamera(CameraTypes type){
		if(type == CameraTypes.MastCam34) currentMastCam = mastCam34;
		else if(type == CameraTypes.MastCam100) currentMastCam = mastCam100;
	}
	
	public void selectCamera100(boolean selection){
		if(selection) currentMastCam = mastCam100;
		else currentMastCam = mastCam34;
		
	}
}
