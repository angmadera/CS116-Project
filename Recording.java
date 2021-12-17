public abstract class Recording {
	protected String artist;
	protected String recordingName;
	protected String type; 
	protected int durationInSeconds;
	protected int numberOfPlays = 0;
	
	Recording(){
		this.artist = "Unknown";
		this.recordingName = "Unknown";
		this.durationInSeconds = 0;
		this.numberOfPlays = 0;
	}
	
	Recording(String artist, String recordingName, int durationInSeconds){
		if (artist != null && recordingName != null && durationInSeconds > 0){
			this.artist = artist;
			this.recordingName  = recordingName;
			this.durationInSeconds = durationInSeconds;
		} else {
			this.artist = "Unknown";
			this.recordingName  = "Unknown";
			this.durationInSeconds = 0;
		}
		this.numberOfPlays = 0;
	}
	
	Recording(String type, String artist, String recordingName, int durationInSeconds){
			if (artist != null && recordingName != null && durationInSeconds > 0){
				this.type = type;
				this.artist = artist;
				this.recordingName  = recordingName;
				this.durationInSeconds = durationInSeconds;
			} else {
				this.type = "unknown";
				this.artist = "Unknown";
				this.recordingName  = "Unknown";
				this.durationInSeconds = 0;
			}
			this.numberOfPlays = 0;
		}
	//2 abstract methods, these will be inherited from audioRecording and videoRecording 
	public abstract double getFramerate();
	public abstract double getBitrate();
	
	public String getartist(){
		return this.artist;
	}
	
	public String getName(){ return this.recordingName ;}

	public int getDuration(){ return this.durationInSeconds;}

	public int getNumberOfPlays(){ return this.numberOfPlays; }
	
	public void play(){
		if (this.durationInSeconds > 0){
			System.out.println("Now playing: " + this.toString());
			numberOfPlays++;
		} else {
			System.out.println("ERROR: Cannot play this recording.");
		}
	}

	public void incrementPlays() { numberOfPlays++;}

	public String statistics(){
		return toString() + ", "+ numberOfPlays;
	}
	public String toString(){
		return this.artist + " - " + this.recordingName  + " [" + ((int) Math.floor(this.durationInSeconds/60)) + "m" + (this.durationInSeconds % 60) + "s]";	
	}

}