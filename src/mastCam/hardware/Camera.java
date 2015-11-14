package mastCam.hardware;

public class Camera {
	private CameraTypes type;
	private String focalLength;
	private String lens;
	private String fov;
	private String resolution;
	private int currentFilter;
	private int numberOfFilters;
	private int photoCount;
	private String capturedImagePath;
	private String returnedImagePath;
	private String capturedVideoPath;
	private String returnedVideoPath;
	private boolean on;
	
	public Camera(CameraTypes _Type){
		this.type = _Type;
		this.on = false;
		if(_Type == CameraTypes.MastCam100){
			focalLength = "100 mm";
			lens = "f/10";
			fov = "5.1 degrees";
			resolution = "1200 x 1200";
		}
		else if(_Type == CameraTypes.MastCam34){
			focalLength = "34 mm";
			lens = "f/8";
			fov = "15 degrees";
			resolution = "1200 x 1200";
		}
		currentFilter = 1;
		numberOfFilters = 8;
		photoCount = 0;
	}

	public CameraTypes getType() {
		return type;
	}

	public void setType(CameraTypes type) {
		this.type = type;
	}

	/**
	 * @return the focalLength
	 */
	public String getFocalLength() {
		return focalLength;
	}

	/**
	 * @param focalLength the focalLength to set
	 */
	public void setFocalLength(String focalLength) {
		this.focalLength = focalLength;
	}

	/**
	 * @return the lens
	 */
	public String getLens() {
		return lens;
	}

	/**
	 * @param lens the lens to set
	 */
	public void setLens(String lens) {
		this.lens = lens;
	}

	/**
	 * @return the fov
	 */
	public String getFov() {
		return fov;
	}

	/**
	 * @param fov the fov to set
	 */
	public void setFov(String fov) {
		this.fov = fov;
	}

	/**
	 * @return the resolution
	 */
	public String getResolution() {
		return resolution;
	}

	/**
	 * @param resolution the resolution to set
	 */
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	/**
	 * @return the currentFilter
	 */
	public int getCurrentFilter() {
		return currentFilter;
	}

	/**
	 * @param currentFilter the currentFilter to set
	 */
	public void setCurrentFilter(int currentFilter) {
		this.currentFilter = currentFilter;
	}

	/**
	 * @return the numberOfFilters
	 */
	public int getNumberOfFilters() {
		return numberOfFilters;
	}

	/**
	 * @param numberOfFilters the numberOfFilters to set
	 */
	public void setNumberOfFilters(int numberOfFilters) {
		this.numberOfFilters = numberOfFilters;
	}

	
	/**
	 * @return the photoCount
	 */
	public int getPhotoCount() {
		return photoCount;
	}

	/**
	 * @param photoCount the photoCount to set
	 */
	public void setPhotoCount(int photoCount) {
		this.photoCount = photoCount;
	}

	/**
	 * @return the returnedImagePath
	 */
	public String getreturnedImagePath() {
		return returnedImagePath;
	}

	/**
	 * @param returnedImagePath the returnedImagePath to set
	 */
	public void setreturnedImagePath(String returnedImagePath) {
		this.returnedImagePath = returnedImagePath;
	}

	/**
	 * @return the capturedVideoPath
	 */
	public String getCapturedVideoPath() {
		return capturedVideoPath;
	}

	/**
	 * @param capturedVideoPath the capturedVideoPath to set
	 */
	public void setCapturedVideoPath(String capturedVideoPath) {
		this.capturedVideoPath = capturedVideoPath;
	}

	/**
	 * @return the returnedVideoPath
	 */
	public String getReturnedVideoPath() {
		return returnedVideoPath;
	}

	/**
	 * @param returnedVideoPath the returnedVideoPath to set
	 */
	public void setReturnedVideoPath(String returnedVideoPath) {
		this.returnedVideoPath = returnedVideoPath;
	}

	/**
	 * @return the on
	 */
	public boolean isOn() {
		return on;
	}

	/**
	 * @param on the on to set
	 */
	public void setOn(boolean on) {
		this.on = on;
	}

	public void capturePhoto(String type){
		String filePath = "";
		if(type.equalsIgnoreCase("panorama")) filePath = "images/mastcam/panorama.jpg";
		if(type.equalsIgnoreCase("still")) filePath = "images/mastcam/still.jpg";
		this.capturedImagePath = filePath;
	}
	
	public void returnPhoto(String type){
		String filePath = "";
		if(capturedImagePath.length() > 0){
			String[] splitStrings = capturedImagePath.split(".jpg");
			filePath += splitStrings[0];
		}
		if(type.equalsIgnoreCase("thumbnail")) filePath += "-thumbnail.jpg";
		if(type.equalsIgnoreCase("compressed")) filePath += "-compressed.jpg";
		if(type.equalsIgnoreCase("original")) filePath += "-original.jpg";
		this.returnedImagePath = filePath;
	}
	
	public void captureVideo(){
		this.capturedVideoPath = "videos/mastcam/video.mpg";
	}
	
	public void returnVideo(){
		this.returnedVideoPath = "videos/mastcam/video.mpg";
	}
	
	public void clearMemory(){
		photoCount = 0;
		this.capturedImagePath = "";
		this.capturedVideoPath = "";
		this.returnedImagePath = "";
		this.returnedVideoPath = "";
	}
}
