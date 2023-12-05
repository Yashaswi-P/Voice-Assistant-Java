package minivoice;

import java.io.IOException;
//Importing Library functions
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class VoiceAssistant {

	@SuppressWarnings("deprecation")
	public static void main(String[] st) {
		
		Configuration config = new Configuration();
// Calling the resources of the Sphinx libraries
// http://www.speech.cs.cmu.edu/tools/lmtool-new.html
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath("src\\main\\resources\\2074.dic");
		config.setLanguageModelPath("src\\main\\resources\\2074.lm");
//Code to recognize LiveSpeech and capture the inputs
		try {
			LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
			speech.startRecognition(true);
			
			SpeechResult speechResult = null;
//Code to validate the results
			while ((speechResult = speech.getResult()) != null) {
				String voiceCommand = speechResult.getHypothesis();
				System.out.println("Voice Command is " + voiceCommand);
//Basic command lists
				if (voiceCommand.equalsIgnoreCase("Open Chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome www.google.com");
				} else if (voiceCommand.equalsIgnoreCase("Close Chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				}
				if (voiceCommand.equalsIgnoreCase("Open Notepad")) {
					Runtime.getRuntime().exec("cmd.exe /c start notepad");
				} else if (voiceCommand.equalsIgnoreCase("Close Notepad")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM Notepad.exe");
				}
				if (voiceCommand.equalsIgnoreCase("Open Whatsapp")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome https://web.whatsapp.com/");
				} else if (voiceCommand.equalsIgnoreCase("Close Whatsapp")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				}
				if (voiceCommand.equalsIgnoreCase("Open Spotify")) {
					Runtime.getRuntime().exec("cmd.exe /c start Spotify");
				} else if (voiceCommand.equalsIgnoreCase("Close Spotify")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM Spotify.exe");
				}
				if (voiceCommand.equalsIgnoreCase("Open Teams")) {
					Runtime.getRuntime().exec("cmd.exe /c start Teams");
				} else if (voiceCommand.equalsIgnoreCase("Close Teams")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM Teams.exe");
				}
				if (voiceCommand.equalsIgnoreCase("Open Moodle")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome http://guru.nmamit.in/login/index.php");
				} else if (voiceCommand.equalsIgnoreCase("Close Moodle")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}