package Mygame;

import java.awt.Color;
import java.awt.Graphics;

public class Shell extends GameObject{
   double degree;
   public Shell() {
	   x=200;
	   y=200;
	   width=20;
	   height=20;
	   speed=FirstWindow.sp;
	   
	   degree = Math.random()*Math.PI*2;
   }
   public void draw(Graphics g) {
	   Color c=g.getColor();
	   g.setColor(c.RED);
	   g.fillOval((int)x,(int) y, width, height);
	   y+=speed*Math.sin(degree);//炮弹沿着任意角度飞
	   x+=speed*Math.cos(degree);
	   if(x<0 || x>Constant.Game_Width-20) {
		   degree=Math.PI-degree;
		   
	   }
	   if(y<0 || y>Constant.Game_Height-20) {
		   degree=-degree;
		   
	   }
			   
   }
}
