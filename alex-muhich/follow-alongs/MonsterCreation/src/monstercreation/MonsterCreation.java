
package monstercreation;

/**
 *
 * @author Alex Muhich
 */
public class MonsterCreation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //double height, double weight, int scareFactor, int speed, String name, String sound
        Monster stoneGolem = new Monster(6.2, 500.1, 25, 3, "Stone Golem", "sentry.wav");
        Monster slowGiant = new Monster(100.0, 1000.0, 75, 1, "Slow Giant", "step.wav");
        Monster nightCrawler = new Monster(5.5, 150.0, 50, 10, "Nightcrawler", "tardis.wav");
        
        System.out.println(stoneGolem.toString());
        stoneGolem.makeSound();
        goToSleep();
        
        System.out.println(slowGiant.toString());
        slowGiant.makeSound();
        goToSleep();
        
        System.out.println(nightCrawler.toString());
        nightCrawler.makeSound();
        goToSleep();
        
        
    }
    public static void goToSleep()
    {
        try
        {
            Thread.sleep(6000);
        }
            catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
