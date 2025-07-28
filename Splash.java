
package university_management_system;

import java.awt.Image;
import javax.swing.*;

public class Splash extends JFrame implements Runnable {

    Thread t;

    Splash() {
        // Load and scale image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // Start the animation thread
        t = new Thread(this);
        t.start();

        setUndecorated(true); // Optional: removes window borders
        setVisible(true);

        int x = 1;
        for (int i = 2; i <= 600; i += 4, x += 1) {
            setLocation(600 - ((i + x) / 2), 350 - (i / 2));
            setSize(i + 3 * x, i + x / 2);
            try {
                Thread.sleep(10); // ✅ FIXED HERE
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        try {
            Thread.sleep(7000); // Show splash screen for 7 seconds
            setVisible(false);
            new Login(); // Launch login screen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
