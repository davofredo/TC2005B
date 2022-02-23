import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio
{
	public void reproducir(){
		String song;
		File songFile;
		AudioInputStream audioStream;
		Clip clip;

		try
		{
			// 1. Obtener la cancion a reproducir
			song = "DeadInside.mp3";

			// 2. Relacionar la cancion con un archivo File
			songFile = new File(song);

			// 3. Preparar un Buffer de RAM para el stream de audio
			audioStream = AudioSystem.getAudioInputStream(songFile);

			// 4. Reproducir la cancion
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			
			while(true)
				clip.start();
		}
		catch(Exception e){
			System.out.println("Error: " + e);
		}
	}

	public static void main(String args[])
	{
		Audio audio = new Audio();

		audio.reproducir();
	}
}