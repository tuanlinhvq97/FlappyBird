/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fb_framework;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Zeno
 */
public class Keyboard implements KeyListener {
    private static Keyboard instance;

    private boolean[] keys;

    public Keyboard() {
        keys = new boolean[256];
    }

    public static Keyboard getInstance() {
        if (instance == null) {
            instance = new Keyboard();
        }

        return instance;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() >= 0 && e.getKeyCode() < keys.length) {
            keys[e.getKeyCode()] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() >= 0 && e.getKeyCode() < keys.length) {
            keys[e.getKeyCode()] = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public boolean isDown(int key) {
        if (key >= 0 && key < keys.length) {
            return keys[key];
        }

        return false;
    }
}
