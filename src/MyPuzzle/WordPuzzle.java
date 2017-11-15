package MyPuzzle;

//@author Akash Bharadwaj

import MyPuzzle.MyHashTable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class WordPuzzle {
	static int counter = 1;
	static int wordCounter = 0;

	public char[][] createGrid(int row, int col, char grid[][]) {
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				grid[x][y] = randomSeriesForThreeCharacter();

			}

		}

		return grid;
	}

	public static char randomSeriesForThreeCharacter() {
		Random r = new Random();

		char random_3_Char = (char) (r.nextInt(26) + 'a');

		return random_3_Char;
	}

	public void printGrid(int row, int col, char a[][]) {
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				System.out.print(a[x][y]);
				System.out.print("   ");
			}
			System.out.println();
		}
	}

	public int printWords(int rows, int cols, char a[][], MyHashTable<String> H, boolean enhancement) {
		System.out.println();
		System.out.println("Horizontal :");

		for (int i = 0; i < rows; i++) {
			String s = "";
			for (int j = 0; j < cols; j++) {
				for (int k = j; k < cols; k++) {
					if (k == j)
						s = "" + a[i][k];

					else if (k != j) {
						s += a[i][k];
					}
					if (enhancement) {
						if ((H.contains(s) && H.isPrefix(s)) || (H.contains(s) && (!H.isPrefix(s)))) {
							if (H.contains(s) && (!H.isPrefix(s))) {
								wordCounter++;
								System.out.println(s);
							}
						} else {
							k = cols;
						}
					} else {

						if (H.contains(s)) {
							wordCounter++;
							System.out.println(s);
						} // else {
							// k = cols;
							// }

					}
				}

			}
		}
		System.out.println();
		System.out.println("Horizontal Reverse :");

		for (int i = 0; i < rows; i++) {

			String s = "";

			for (int j = cols - 1; j > 0; j--) {

				for (int k = j; k > 0; k--) {

					if (k == j) {
						s = "" + a[i][k];

					} else if (k != j) {
						s += a[i][k];
					}

					if (enhancement) {
						if ((H.contains(s) && H.isPrefix(s)) || (H.contains(s) && (!H.isPrefix(s)))) {
							if (H.contains(s) && (!H.isPrefix(s))) {
								wordCounter++;
								System.out.println(s);
							}
						} else {
							k = 0;
						}
					} else {

						if (H.contains(s)) {
							wordCounter++;
							System.out.println(s);
						} // else {
							// k = 0;
							// }

					}

				}
			}

		}
		System.out.println();
		System.out.println("Vertical :");

		for (int i = 0; i < cols; i++) {
			String s = "";
			for (int j = 0; j < rows; j++) {
				for (int k = j; k < rows; k++) {
					if (k == j)
						s = "" + a[k][i];

					else if (k != j) {
						s += a[k][i];
					}

					if (enhancement) {
						if ((H.contains(s) && H.isPrefix(s)) || (H.contains(s) && (!H.isPrefix(s)))) {
							if (H.contains(s) && (!H.isPrefix(s))) {
								wordCounter++;
								System.out.println(s);
							}
						} else {
							k = cols;
						}
					} else {

						if (H.contains(s)) {
							wordCounter++;
							System.out.println(s);
						} // else {
							// k = cols;
							// }

					}
				}

			}
		}
		System.out.println();
		System.out.println("Vertical Reverse :");

		for (int i = 0; i < cols; i++) {

			String s = "";

			for (int j = rows - 1; j > 0; j--) {

				for (int k = j; k > 0; k--) {

					if (k == j) {
						s = "" + a[k][i];

					} else if (k != j) {
						s += a[k][i];
					}

					if (enhancement) {
						if ((H.contains(s) && H.isPrefix(s)) || (H.contains(s) && (!H.isPrefix(s)))) {
							if (H.contains(s) && (!H.isPrefix(s))) {
								wordCounter++;
								System.out.println(s);
							}
						} else {
							k = 0;
						}
					} else {

						if (H.contains(s)) {
							wordCounter++;
							System.out.println(s);
						}

					}
				}
			}

		}
		System.out.println();
		System.out.println("Non Leading Diagonal :");

		// boolean isPrinted = false;
		for (int i = 0; i < rows; i++) {
			String temp = "";
			int x = i;
			int l = i;
			for (int j = 0; j < cols; j++, l--) {
				temp = "";
				int y = j;
				x = l;
				if (l >= 0) {
					while (x >= 0 && y < cols) {

						temp += a[x--][y++];

						if (enhancement) {
							if ((H.contains(temp) && H.isPrefix(temp)) || (H.contains(temp) && (!H.isPrefix(temp)))) {
								if (H.contains(temp) && (!H.isPrefix(temp))) {
									wordCounter++;
									System.out.println(temp);
								}
							} else {
								break;
							}
						} else {

							if (H.contains(temp)) {
								wordCounter++;
								System.out.println(temp);
							}

						}
					}

				} else
					break;

			}
		}

		for (int i = rows - 1, k = 1; k < cols; k++) {
			String temp = "";

			int x = i;
			int l = i;
			for (int j = k; l >= 0; l--, j++) {
				temp = "";
				x = l;
				int y = j;
				while (x >= 0 && y < cols) {

					temp += a[x--][y++];

					if (enhancement) {
						if ((H.contains(temp) && H.isPrefix(temp)) || (H.contains(temp) && (!H.isPrefix(temp)))) {
							if (H.contains(temp) && (!H.isPrefix(temp))) {
								wordCounter++;
								System.out.println(temp);
							}
						} else {
							break;
						}
					} else {

						if (H.contains(temp)) {
							wordCounter++;
							System.out.println(temp);
						}

					}

				}

			}
		}

		System.out.println();
		System.out.println("Non Leading Diagonal Reverse :");

		for (int i = 0; i < cols; i++) {
			String temp = "";
			int x = i;
			int l = i;
			for (int j = 0; j < rows; j++, l--) {
				temp = "";
				int y = j;
				x = l;
				if (l >= 0) {
					while (x >= 0 && y < rows) {

						temp += a[y++][x--];

						if (enhancement) {
							if ((H.contains(temp) && H.isPrefix(temp)) || (H.contains(temp) && (!H.isPrefix(temp)))) {
								if (H.contains(temp) && (!H.isPrefix(temp))) {
									wordCounter++;
									System.out.println(temp);
								}
							} else {
								break;
							}
						} else {

							if (H.contains(temp)) {
								wordCounter++;
								System.out.println(temp);
							}

						}
					}

				} else
					break;

			}
		}

		for (int i = cols - 1, k = 1; k < rows; k++) {
			String temp = "";

			int x = i;
			int l = i;
			for (int j = k; l >= 0; l--, j++) {
				temp = "";
				x = l;
				int y = j;
				while (x >= 0 && y < rows) {

					temp += a[y++][x--];

					if (enhancement) {
						if ((H.contains(temp) && H.isPrefix(temp)) || (H.contains(temp) && (!H.isPrefix(temp)))) {
							if (H.contains(temp) && (!H.isPrefix(temp))) {
								wordCounter++;
								System.out.println(temp);
							}
						} else {
							break;
						}
					} else {

						if (H.contains(temp)) {
							wordCounter++;
							System.out.println(temp);
						}

					}

				}

			}
		}

		System.out.println();
		System.out.println("Leading Diagonal :");

		for (int i = rows - 1; i >= 0; i--) {
			String s = "";
			int x = i;
			int l = i;
			for (int j = 0; j < cols; j++, l++) {
				s = "";
				int y = j;
				x = l;
				while ((x < rows && y >= 0) && (x >= 0 && y < cols)) {

					s += a[x++][y++];

					if (enhancement) {
						if ((H.contains(s) && H.isPrefix(s)) || (H.contains(s) && (!H.isPrefix(s)))) {
							if (H.contains(s) && (!H.isPrefix(s))) {
								wordCounter++;
								System.out.println(s);
							}
						} else {
							break;
						}
					} else {

						if (H.contains(s)) {
							wordCounter++;
							System.out.println(s);
						}

					}

				}
				if (counter == 1) {
					counter++;
					break;
				}

			}
		}

		for (int i = 0, k = 1; k < cols; k++) {
			String temp = "";

			int x = i;
			int l = i;
			for (int j = k; j < cols; j++, l++) {
				temp = "";
				// if (l < rows - 1)
				x = l;
				// else
				// x = i;
				int y = j;
				while (x < rows && y < cols) {

					temp += a[x++][y++];

					if (enhancement) {
						if ((H.contains(temp) && H.isPrefix(temp)) || (H.contains(temp) && (!H.isPrefix(temp)))) {
							if (H.contains(temp) && (!H.isPrefix(temp))) {
								wordCounter++;
								System.out.println(temp);
							}
						} else {
							break;
						}
					} else {

						if (H.contains(temp)) {
							wordCounter++;
							System.out.println(temp);
						}

					}

				}

			}
		}
		System.out.println();
		System.out.println("Leading Diagonal Reverse :");

		for (int i = rows - 1, k = 0; k < rows; k++) {
			String s = "";
			int x = i;
			int l = i;
			for (int j = k; j < cols; j--, l--) {
				s = "";
				int y = j;
				x = l;
				if (l >= 0 && k >= 0) {
					while ((x < rows) && y >= 0) {

						s += a[x--][y--];

						if (enhancement) {
							if ((H.contains(s) && H.isPrefix(s)) || (H.contains(s) && (!H.isPrefix(s)))) {
								if (H.contains(s) && (!H.isPrefix(s))) {
									wordCounter++;
									System.out.println(s);
								}
							} else {
								break;
							}
						} else {

							if (H.contains(s)) {
								wordCounter++;
								System.out.println(s);
							}

						}

					}
					if (counter == 2) {
						counter++;
						break;
					}

				} else
					break;
			}
		}

		for (int i = 0; i < rows - 1; i++) {
			String s = "";
			int x = i;
			int l = i;
			for (int j = cols - 1; j < cols; j--, l--) {
				s = "";
				int y = j;
				x = l;
				if (l >= 0 && j >= 0) {
					while ((x >= 0) && y >= 0) {

						s += a[x--][y--];

						if (enhancement) {
							if ((H.contains(s) && H.isPrefix(s)) || (H.contains(s) && (!H.isPrefix(s)))) {
								if (H.contains(s) && (!H.isPrefix(s))) {
									wordCounter++;
									System.out.println(s);
								}
							} else {
								break;
							}
						} else {

							if (H.contains(s)) {
								wordCounter++;
								System.out.println(s);
							}

						}

					}
					if (counter == 3) {
						counter++;
						break;
					}
				} else
					break;
			}
		}
		return wordCounter;
	}

}

class WordPuzzleMain {
	public static void main(String s[]) {
		WordPuzzle a = new WordPuzzle();
		MyHashTable<String> H = new MyHashTable<>();
		boolean enhancement = true;
		Scanner scanner2 = new Scanner(System.in);
		System.out.print("Do need the Enhancement (true/false): ");

		try {
			enhancement = scanner2.nextBoolean();
			String fileName = "dictionary.txt";
			boolean prefix = false;

			String line = null;

			try {

				FileReader fileReader = new FileReader(fileName);

				BufferedReader bufferedReader = new BufferedReader(fileReader);

				while ((line = bufferedReader.readLine()) != null) {
					if (enhancement) {
						String c = "";

						for (int i = 0; i < line.length(); i++) {

							if (line.length() == 1) {
								c = line;
								prefix = false;
							} else if (line.length() != 1 && (i != line.length() - 1)) {
								c += line.charAt(i);
								prefix = true;
							} else if (i == line.length() - 1) {
								c = line;
								prefix = false;
							}

							H.insert(c, prefix);
						}
					} else {
						String c = line;

						H.insert(c, prefix);
					}

				}

				bufferedReader.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + fileName + "'");
				System.exit(1);
			} catch (IOException ex) {
				System.out.println("Error reading file '" + fileName + "'");
				System.exit(1);
			}

			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the number of rows: ");
			int rows = scanner.nextInt();
			// System.out.println();

			Scanner scanner1 = new Scanner(System.in);
			System.out.print("Enter the number of columns: ");
			int cols = scanner.nextInt();

			// int rows = 50;
			// int cols = 50;
			if (rows > 0 && cols > 0)

			{

				char grid[][] = new char[rows][cols];

				System.out.println();
				char grid1[][] = a.createGrid(rows, cols, grid);

				a.printGrid(rows, cols, grid1);
				System.out.println();

				System.out.println();
				long startTime = System.currentTimeMillis();
				int wordCount = a.printWords(rows, cols, grid1, H, enhancement);

				System.out.println("Word Count: " + wordCount);
				long endTime = System.currentTimeMillis();

				System.out.println("Elapsed time: " + (endTime - startTime));

				scanner.close();
				scanner1.close();
				scanner2.close();

			}

		}

		catch (Exception o) {
			System.out.println("Your input is NOT correct, enter either true/false");
		}

	}
}