/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fb_framework;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Zeno
 */
public class Util {
    private static HashMap<String, Image> cache = new HashMap<String, Image>();

    public static Image loadImage(String path) {
        Image image = null;

        if (cache.containsKey(path)) {
            return cache.get(path);
        }

        try {
            image = ImageIO.read(new File(path));

            if (!cache.containsKey(path)) {
                cache.put(path, image);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
}
