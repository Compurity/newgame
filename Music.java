import java.io.FileInputStream;
import java.io.IOException;

import sun.audio.*;

public class Music {

	public static void sound(){
		
		AudioPlayer MGP = AudioPlayer.player;
		AudioStream BGM;
		try{
			BGM = new AudioStream(new FileInputStream("song.wav"));
			MGP.start(BGM);
		}catch(IOException error){
			System.out.println(error);
		}
		}
	
	
}
