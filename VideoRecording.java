public class VideoRecording extends Recording {
		
		//added fields
		private double frameRate;
		
		//default constructor constructor
		VideoRecording() {
			super();
			frameRate = 0;
		}
			
		//parametrized constructor
		VideoRecording(String a, String n, int d, double video) {
			super(a, n, d);
				if ( a != null || n != null || d > 0 || video > 0.0) {
					this.frameRate = video;
				}
				else {
					frameRate = 0;
				}
		}
		
		VideoRecording(String t, String a, String n, int d, double audio) {
			super(t, a, n, d);
				if (t != null || a != null || n != null || d > 0 || audio > 0.0) {
					this.frameRate = audio;
				}
				else {
					frameRate = 0;
				}
		}
		
		//getter/accessor method
		public double getFrameRate() {
			return frameRate;
		}
		
		//toString
		@ Override
		public String toString() {
			return artist + " - " + recordingName + " [" + durationInSeconds/60 + "m " + durationInSeconds%60 +  "s] " + "[VIDEO | framerate: " + frameRate + " fps]";
		}

		@Override
		public double getBitrate() {
			// TODO Auto-generated method stub
			return 0;
		}
	}
