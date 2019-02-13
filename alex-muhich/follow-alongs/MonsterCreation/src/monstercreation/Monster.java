
package monstercreation;

import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Alex Muhich
 */
public class Monster {
    private double height;
    private double weight;
    private int scareFactor;
    private int speed;
    private String name;
    private String sound;
    
    public Monster(double height, double weight, int scareFactor, int speed, String name, String sound){
        this.height = height;
        this.weight = weight;
        this.scareFactor = scareFactor;
        this.speed = speed;
        this.name = name;
        this.sound = sound;
        
    }
    @Override
    public String toString(){
        return "Hi, I'm: " + name + ".\nHeight: " + height + "\nWeight: " + weight
                + "\nScare Factor: " + scareFactor + "\nSpeed: " + speed;
    }
    public void makeSound(){
        InputStream inputStream;
        
        try 
        {
            inputStream = getClass().getResourceAsStream(sound);
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
