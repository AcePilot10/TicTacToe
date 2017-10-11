package me.acepilot10.tictactoe;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToeBoard extends JPanel {

	private GridLayout layout;

	private HashMap<Integer, Cell> cells;

	public TicTacToeBoard() {
		init();
	}

	private void init() {
		initLayout();
	}

	private void initLayout() {
		layout = new GridLayout(3, 3, 2, 2);
		setBackground(Color.BLACK);
		cells = new HashMap<Integer, Cell>();
		for (int i = 1; i <= 9; i++) {
			Cell c = new Cell();
			add(c);
			cells.put(i, c);
		}
		setLayout(layout);
	}

	private void checkWinVertical() {
		int[] starters = new int[] { 1, 2, 3 };
		for (int i : starters) {
			int piece = getCell(i).getPiece();
			if (piece != 0) {
				for (int next = 1; next <= 2; next++) {
					Cell currentCell;
					if (next == 1) {
						currentCell = getCell(i + 3);
						if (currentCell.getPiece() != piece)
							break;
					}
					if (next == 2) {
						currentCell = getCell(i + 6);
						if (currentCell.getPiece() != piece)
							break;
						// win
						// System.out.println("Detected win vertical!");
						int[] winPieces = new int[] { i, i + 3, i + 6 };
						win(winPieces);
					}
				}
			}
		}
	}

	private void checkWinHorizontal() {
		int[] starters = new int[] { 1, 4, 7 };
		for (int i : starters) {
			// System.out.println("Checking cell: " + i);
			int piece = getCell(i).getPiece();
			if (piece != 0) {
				for (int next = 1; next <= 2; next++) {
					if (getCell(i + next).getPiece() == piece) {
						// System.out.println("Advanced to cell: " + (i +
						// next));
						if (next == 2) {
							// Win vertical
							// System.out.println("Detected win horizontal!");
							int[] winPieces = new int[] { i, i + 1, i + 2 };
							win(winPieces);
						}
					} else
						break;
				}
			}
		}
	}

	private void checkWinDiagonal() {
		Cell cell7 = getCell(7);
		Cell cell9 = getCell(9);
		if (cell7.getPiece() != 0) {
			int piece = cell7.getPiece();
			if (getCell(5).getPiece() == piece) {
				if (getCell(3).getPiece() == piece) {
					// win diagonal
					// System.out.println("Won on down left diagonal");
					int[] winPieces = new int[] { 7, 5, 3 };
					win(winPieces);
				}
			}
		}

		if (cell9.getPiece() != 0) {
			int piece = cell9.getPiece();
			if (getCell(5).getPiece() == piece) {
				if (getCell(1).getPiece() == piece) {
					// win diagonal
					// System.out.println("Won on down right diagonal");
					int[] winPieces = new int[] { 9, 5, 1 };
					win(winPieces);
				}
			}
		}
	}

	public void checkWin() {
		checkWinHorizontal();
		checkWinVertical();
		checkWinDiagonal();
	}

	public Cell getCell(int cell) {
		return cells.get(cell);
	}

	public void win(int[] cells) {
		for (int i : cells) {
			getCell(i).setBackground(Color.YELLOW);
		}
		// JOptionPane.showMessageDialog(TicTacToe.instance.getFrame(),
		// TicTacToe.currentPiece + " Has Won!");
		int piece = TicTacToe.currentPiece;
		if (piece == 1) {
			int res = JOptionPane.showOptionDialog(TicTacToe.instance.getFrame(), "X Has Won!", "Winner!",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
			if (res == 0) {
				TicTacToe.instance.restart();
			}
		}
		if (piece == 2) {
			int res = JOptionPane.showOptionDialog(TicTacToe.instance.getFrame(), "O Has Won!", "Winner!",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
			if (res == 0) {
				TicTacToe.instance.restart();
			}
		}
	}
}