import java.io.FileInputStream;
import java.io.IOException;

import sun.audio.*;

public class Music {

	public static void sound(){
		
		AudioPlayer MGP = AudioPlayer.player;
		AudioStream BGM;
		AudioData MD;
		ContinuousAudioDataStream loop = null;
		try{
		BGM = new AudioStream(new FileInputStream("C:\\Users\\wings\\Downloads\\11 - Rage Awakened.mp3"));
		MD = BGM.getData();
		loop = new ContinuousAudioDataStream(MD);
		}catch(IOException error){
		System.out.print("file not found");
		}
		MGP.start(loop);
		}
	
	
}
