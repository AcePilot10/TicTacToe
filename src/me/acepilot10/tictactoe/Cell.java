package me.acepilot10.tictactoe;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cell extends JPanel implements MouseListener {

	public static int BLANK = 0;
	public static int X = 1;
	public static int O = 2;
	
	private int piece = BLANK;
	
	private JLabel label;
	
	public Cell() {
		init();
	}
	
	private void init() {
		label = new JLabel();
		label.setFont(new Font("Serif", Font.PLAIN, 50));
		add(label);
		addMouseListener(this);
	}
	
	public int getPiece() {
		return this.piece;
	}
	
	public void setPiece(int piece) {
		this.piece = piece;
	}
	
	public JLabel getLabel() {
		return this.label;
	}
	
	private void mouseClicked() {
		//System.out.println("Clicked: " + getLabel().getText());
		if(piece == BLANK) {
			switch(TicTacToe.currentPiece) {
			case 1:
				//X
				label.setText("X");
				piece = X;
				break;
			case 2:
				//O
				label.setText("O");
				piece = O;
				break;
			}
			TicTacToe.instance.nextPlayer();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseClicked();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}