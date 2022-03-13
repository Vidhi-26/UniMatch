/*
 * Names Vidhi Ruparel
 * Date: December 5th, 2021
 * Course: ICS4U1 - Mr. Fernandes
 * Description: This method controls the music that plays.
 * Cite: 
 * Music: Spark Of Inspiration by Shane Ivers - https://www.silvermansound.com
 * Licensed under Creative Commons Attribution 4.0 International License
 * https://creativecommons.org/licenses/by/4.0/
 * Music promoted by https://www.chosic.com/free-music/all/ 
 */


package controller;


//imports
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


/**
 * MusicController class begins to play, plays, and pauses music as required. 
 */
public class MusicController {
	

	//instance variable
	private static Clip inspirationalMusicClip;					//clip
	public String status = "paused";							//status of clip (pause/play)
	private static long currentFrame = 0;						//store song clip
		
	
	//constructor
	public void MainController() {
	   	
   		// begins here
   		beginMusic();
   				
   	}
	
	
	//utility methods
  	
	/**
	 * begins playing music
	 */
	public void beginMusic() {
		
		//plays the music
		play();
		
	}
	
   	/**
   	 *  method to play the music
   	 */
	private void play() {
	       
		   try {
			   	
			    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./sounds/uniMatchMusic.wav").getAbsoluteFile());
			    Clip clip = AudioSystem.getClip();
			    clip.open(audioInputStream);
	   
		 		// stores the clip in inspirationalMusicClip
			    inspirationalMusicClip = clip;
			   
				// changes the status of the clip to play from pause
				status = "play";
				
				// starts the song at where it ended
				clip.setMicrosecondPosition(currentFrame);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			
			    clip.start(); 										    		 	 
		   }
		   
		   catch(Exception error) {
		     System.out.println("Error with playing sound.");
		     error.printStackTrace( );
		   } 
		        
	}
	
	/**
	 *  method to pause the music
	 */
    private void pause() {
      
    	inspirationalMusicClip.stop();
		
		// stores the position of the clip 
		currentFrame = inspirationalMusicClip.getMicrosecondPosition();
	
		// changes the status of the clip to paused from play
		status = "paused";
    	
    } 
    
	
} // end of MusicController class