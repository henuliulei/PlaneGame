package Mygame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * ��Ϸ����ĸ���
 * @author 19575
 *
 */
public class GameObject {
        Image img;
         double x,y;
         int speed;
         int height,width;
    public void drawSelf(Graphics g) {
	g.drawImage(img, (int)x, (int)y,null);
}
public GameObject() {
	super();
}
public GameObject(Image img, double x, double y) {
	super();
	this.img = img;
	this.x = x;
	this.y = y;
}
public Rectangle getRect() {//�����������ڵľ��Σ��ж������Ƿ���ײ
	return new Rectangle((int)x,(int)y,width,height);
}
}
