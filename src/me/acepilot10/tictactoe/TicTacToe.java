package me.acepilot10.tictactoe;

import javax.swing.JFrame;

public class TicTacToe {

	private JFrame frame;
	private TicTacToeBoard board;
	
	public static TicTacToe instance;
	
	public static int currentPiece = Cell.X;
	
	public TicTacToe() {
		instance = this;
		init();
	}
	
	private void init() {
		frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Current Player: X");
		board = new TicTacToeBoard();
		frame.add(board);
	
		frame.setVisible(true);
	}	
	
	public void nextPlayer() {
		board.checkWin();
		switch(currentPiece) {
		case 1:
			currentPiece = 2;
			frame.setTitle("Current Player: O");
			break;
		case 2:
			currentPiece = 1;
			frame.setTitle("Current Player: X");
			break;
		}
	}
	
	public void restart() {
		getFrame().getContentPane().removeAll();
		board = new TicTacToeBoard();
		frame.add(board);
		frame.validate();
		frame.repaint();
	}
		
	public JFrame getFrame() {
		return this.frame;
	}
	
	public TicTacToeBoard getBoard() {
		return this.board;
	}
}