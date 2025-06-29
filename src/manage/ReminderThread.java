/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manage;

/**
 *
 * @author Ihsan
 */
public class ReminderThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000); // reminder setiap 10 detik
                System.out.println(LanguageManager.get("app.reminder"));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
