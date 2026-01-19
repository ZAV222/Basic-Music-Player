import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "src\\A Caring Friend - Bad Snacks.wav";
        File fl = new  File(filePath);
        try (Scanner sc = new Scanner(System.in);
             AudioInputStream ais = AudioSystem.getAudioInputStream(fl)){

            Clip clip = AudioSystem.getClip();
            clip.open(ais);


            String response = "";

            while (!(response.equals("Q"))) {
                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");

                System.out.print("Enter your choice: ");
                response = sc.next().toUpperCase();

                switch (response) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid choice");
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported Audio File");
        }
        catch (LineUnavailableException e) {
            System.out.println("Line not available");
        }
        catch (IOException e) {
            System.out.println("Something went wrong");
        }
        finally {
            System.out.println("Bye!!!");

        }
    }
}