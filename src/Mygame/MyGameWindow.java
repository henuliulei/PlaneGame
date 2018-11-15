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
 * �ɻ�������
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
		public void paint(Graphics g) {//�Զ������ã�g�൱��һ������
		g.drawImage(bg, 0, 0, null);
        
         plane1.drawSelf(g);
         for (int i = 0; i < shells.length; i++) {
        	 shells[i].draw(g);
        	 Boolean b=shells[i].getRect().intersects(plane1.getRect());//��ײ���
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
        		    Font f=new Font("����",Font.BOLD,40);
        			 g.setColor(Color.yellow);
        			 g.setFont(f);
        		if(a>100) {
        			a=100;
        		}
       		 g.drawString("ʱ��:"+ a+"��,"+"�÷�:"+a*FirstWindow.sum*FirstWindow.sp+"\n",300 ,100);
              g.drawString("\n����ȫ��"+(a*FirstWindow.sum*FirstWindow.sp)/40.0+"%"+"�����", 270, 150);
        		 
        	 }
        	 
		}
        
         
	}
class PaintThread extends Thread{
	@Override
	public void run() {
		while(true) {
			repaint();//�ػ�
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
	  this.setTitle("�ɻ�����");
	  this.setVisible(true);
	  this.setBounds(400, 50, Constant.Game_Height,Constant.Game_Width);
	  this.addWindowListener(new  WindowAdapter() {
		  @Override
		public void windowClosed(WindowEvent e) {//alt+?������ʾ
			System.exit(1);
		}
	  });
	  new PaintThread().start();
	  addKeyListener(new KeyMonitor());
	//��ʼ������ӵ�
      for (int i = 0; i < shells.length; i++) {
			shells[i]=new Shell();
		}
  }
  class KeyMonitor extends KeyAdapter{//������̼���
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
  public void update(Graphics g) {//����˫��������������
	 
		  if(offScreenImage  == null)
			  offScreenImage =this.createImage(Constant.Game_Height,Constant.Game_Width);
		  Graphics gOff=offScreenImage.getGraphics();
		  paint(gOff);
		  g.drawImage(offScreenImage, 0, 0, null);
		}
  }

