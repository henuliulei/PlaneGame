package Mygame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
/**
 * 飞机主窗口
 * @author 19575
 *
 */
    public class MyGameWindow extends Frame {
    	
    	Image plane=GameUtil.getImage("Mygame/fly.png");
    	Image over=GameUtil.getImage("Mygame/over.jpg");
    	Image bg=GameUtil.getImage("Mygame/xingkong.jpg");
    	Plane plane1=new Plane(plane,450,700);
    	boolean flag=true;
    	Shell shell=new Shell();
    	FirstWindow firstWindow=new FirstWindow();
    	
    	Shell[]shells=new Shell[FirstWindow.sum];
        Date startTime=new Date();
        Date endTime;
        int period;
        int a=0;
	@Override
		public void paint(Graphics g) {//自动被调用，g相当于一个画笔
		g.drawImage(bg, 0, 0, null);
        
         plane1.drawSelf(g);
         for (int i = 0; i < shells.length; i++) {
        	 shells[i].draw(g);
        	 Boolean b=shells[i].getRect().intersects(plane1.getRect());//碰撞检测
        	 if(b) {
        		 Plane.live=false;
        		flag=false;
        		if(a==0)
        		a++;
        		endTime =new Date();
        		period=(int)((endTime.getTime()-startTime.getTime())/1000);
        		if(a==1) {
        			a=period;
        		}
        	 }
        	 if(flag==false) {
        		 g.drawImage(over, 400,400, null);
        		    Font f=new Font("宋体",Font.BOLD,40);
        			 g.setColor(Color.yellow);
        			 g.setFont(f);
        		if(a>100) {
        			a=100;
        		}
       		 g.drawString("时间:"+ a+"秒,"+"得分:"+a*FirstWindow.sum*FirstWindow.sp+"\n",300 ,100);
              g.drawString("\n击败全球"+(a*FirstWindow.sum*FirstWindow.sp)/40.0+"%"+"的玩家", 270, 150);
        		 
        	 }
        	 
		}
        
         
	}
class PaintThread extends Thread{
	@Override
	public void run() {
		while(true) {
			repaint();//重画
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
  public void launchFrame()
  {
	  this.setBackground(Color.yellow);
	  this.setTitle("飞机飞行");
	  this.setVisible(true);
	  this.setBounds(400, 50, Constant.Game_Height,Constant.Game_Width);
	  this.addWindowListener(new  WindowAdapter() {
		  @Override
		public void windowClosed(WindowEvent e) {//alt+?给出提示
			System.exit(1);
		}
	  });
	  new PaintThread().start();
	  addKeyListener(new KeyMonitor());
	//初始化多个子弹
      for (int i = 0; i < shells.length; i++) {
			shells[i]=new Shell();
		}
  }
  class KeyMonitor extends KeyAdapter{//定义键盘监听
	  @Override
	public void keyPressed(KeyEvent e) {
		plane1.addDirection(e);
	}
	  @Override
	public void keyReleased(KeyEvent e) {
			plane1.minuDirection(e);

	}
  }
  public static void main(String[] args) {
	MyGameWindow a=new MyGameWindow();
	a.launchFrame();
}
  private Image offScreenImage=null;
  public void update(Graphics g) {//利用双缓冲解决闪屏问题
	 
		  if(offScreenImage  == null)
			  offScreenImage =this.createImage(Constant.Game_Height,Constant.Game_Width);
		  Graphics gOff=offScreenImage.getGraphics();
		  paint(gOff);
		  g.drawImage(offScreenImage, 0, 0, null);
		}
  }

