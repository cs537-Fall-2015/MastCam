package mastCam;

public enum Commands {

	// Turns instrument on
	MCAM_PWR_ON{
		public String toString(){
			return "MCAM_PWR_ON";
		}
	},
	// Turns instrument off
	MCAM_PWR_OFF{
		public String toString(){
			return "MCAM_PWR_OFF";
		}
	},
	// Captures a still image
	MCAM_CAPTR_STILL{
		public String toString(){
			return "MCAM_CAPTR_STILL";
		}
	},
	// Captures a panaroma
	MCAM_CAPTR_PANRMA{
		public String toString(){
			return "MCAM_CAPTR_PANRMA";
		}
	},
	// Captures a video
	MCAM_CAPTR_VID{
		public String toString(){
			return "MCAM_CAPTR_VID";
		}
	},
	// Returns the thumbnail of the image - JPEG
	MCAM_RTN_THBMNL{
		public String toString(){
			return "MCAM_RTN_THBMNL";
		}
	},
	// Returns a compressed image - JPEG
	MCAM_RTN_CMPRSD{
		public String toString(){
			return "MCAM_RTN_CMPRSD";
		}
	},
	// Returns original high resolution image - PNG
	MCAM_RTN_ORIG{
		public String toString(){
			return "MCAM_RTN_ORIG";
		}
	},
	// Returns the video data - MPEG
	MCAM_RTN_VID{
		public String toString(){
			return "MCAM_RTN_VID";
		}
	},
	// Returns status: BUSY or READY
	MCAM_RTN_STAT{
		public String toString(){
			return "MCAM_RTN_STAT";
		}
	},
	// Select a filter
	MCAM_SLCT_FLTR{
		public String toString(){
			return "MCAM_SLCT_FLTR";
		}
	},
	// Select MastCam-100
	MCAM_SLCT_CAM_100{
		public String toString(){
			return "MCAM_SLCT_CAM_100";
		}
	},
	//Select MastCam-34
	MCAM_SLCT_CAM_34{
		public String toString(){
			return "MCAM_SLCT_CAM_34";
		}
	},
	// Clears the memory buffer
	MCAM_CLR{
		public String toString(){
			return "MCAM_CLR";
		}
	}

}
