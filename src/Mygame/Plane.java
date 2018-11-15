package Mygame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{
	static boolean live =true;
	 static int speed=20;
	boolean left,right,up,down;
public void drawSelf(Graphics g) {
	if(live) {

		g.drawImage(img, (int)x, (int)y,null);
		if(left==true && x>20) {
			x-=speed;
		}
		if(right==true && x+speed<Constant.Game_Width-170) {
			x+=speed;
		}
	   if(up==true && y>=10) {
		   y-=speed;
	   }
	   if(down==true && y<Constant.Game_Height-170) {
		   y+=speed;
	   }

	}
}
public Plane(Image img,double x,double y) {
	this.img=img;
	this.x=x;
	this.y=y;
	this.height=img.getHeight(null);
	this.width=img.getWidth(null);
}
public void addDirection(KeyEvent e) {//按下某个键，增加相应的方向
	switch(e.getKeyCode()) {
	case KeyEvent.VK_LEFT:
		left=true;
		break;
	case KeyEvent.VK_RIGHT:
		right=true;
		break;
	case KeyEvent.VK_UP:
		up=true;
		break;
	case KeyEvent.VK_DOWN:
		down=true;
		break;
		
	}
	
}
public void  minuDirection(KeyEvent e) {//松开某个键，取消相应的方向
	switch(e.getKeyCode()) {
	case KeyEvent.VK_LEFT:
		left=false;
		break;
	case KeyEvent.VK_RIGHT:
		right=false;
		break;
	case KeyEvent.VK_UP:
		up=false;
		break;
	case KeyEvent.VK_DOWN:
		down=false;
		break;
		
	}
	
}
}
