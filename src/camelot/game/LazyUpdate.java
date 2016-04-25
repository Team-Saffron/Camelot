/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camelot.game;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abhishek
 */
public class LazyUpdate implements Runnable {
    @Override
    public void run()
    {
        System.out.print("Inside Thread");
        synchronized(this){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LazyUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        notify();
        }
    }
}
