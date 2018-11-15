package Mygame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * 游戏物体的父类
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
public Rectangle getRect() {//返回物体所在的矩形，判断物体是否相撞
	return new Rectangle((int)x,(int)y,width,height);
}
}
