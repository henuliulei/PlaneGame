package Mygame;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * ����ָ��ͼƬ��λ��
 * @author 19575
 *
 */
public class GameUtil {
private GameUtil() {
	
}
public static Image getImage(String path) {
	BufferedImage bi=null;
	try {
		URL u=GameUtil.class.getClassLoader().getResource(path);
		bi=ImageIO.	read(u);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return bi;
}
}
