public class AudioRecording extends Recording {
	
	private double bitrate;
	
	// default constructor
	AudioRecording() { //use super to extend from Recording 
		super();
		bitrate = 0;
	}
	// nondefault constructor
	AudioRecording(String a, String n, int d, double audio) {
		super(a, n, d); //extends from Recording
		if ( a != null || n != null || d > 0 || audio > 0.0) {
			this.bitrate = audio;
		}
		else {
			bitrate = 0;
		} 	}
	// nondefault constructor
	AudioRecording(String t, String a, String n, int d, double audio) {
		super(t, a, n, d);
			if ( a != null || n != null || d > 0 || audio > 0.0) {
				this.bitrate = audio;
			}
			else {
				bitrate = 0;
			}
	}
	
	public double getBitrate() { return bitrate;}
	
	//Make sure to override toString and getFramerate from Recording 
	
	@ Override
	public String toString() {
			return artist + " - " + recordingName + " [" + durationInSeconds/60 + "m " + durationInSeconds%60 +  "s] " + "[AUDIO | bitrate: " + bitrate + " kbps]";
	}
	@Override
	public double getFramerate() { return -1;}
}
