package C1001_GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Gui06Drawing {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Gui Drawing Test");
		frame.setPreferredSize(new Dimension(500,500));
		frame.setLocation(500,500);
		Container ct = frame.getContentPane();
		DrawingPanel drawingPanel = new DrawingPanel();
		ct.add(drawingPanel);
		
		myMouseEvent e = new myMouseEvent(drawingPanel);
		drawingPanel.addMouseMotionListener(e);
		drawingPanel.addMouseListener(e);
		
		frame.pack();
		frame.setVisible(true);

	}

}
class Point {
	int x, y;
	boolean skip;
	
	public Point(int x, int y, boolean skip) {
		this.x = x;
		this.y = y;
		this.skip = skip;
	}
}

class DrawingPanel extends JPanel{
	ArrayList<Point> arr;
	
	public DrawingPanel() {
		arr = new ArrayList<Point>();
	}
	
	@Override
	public void paint(Graphics g) {
		
		for(int i=0;i<arr.size()-1;i++) {
			Point start = arr.get(i);
			if(start.skip) {
				continue;
			}
			Point end = arr.get(i+1);
			g.drawLine(start.x, start.y, end.x, end.y);
		
		}
		
	}
}


class myMouseEvent implements MouseMotionListener, MouseListener{
	DrawingPanel pan;
	int x, y;
	
	public myMouseEvent(DrawingPanel pan) {
		this.pan = pan;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		x = e.getX();
		y = e.getY();
		pan.arr.add(new Point(x,y,false));
		pan.repaint();
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		pan.arr.add(new Point(x, y, true));
		pan.repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
