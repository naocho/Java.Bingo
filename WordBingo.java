import java.util.Scanner;

public class WordBingo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//ビンゴのサイズを取得し、変数に格納
		int size = Integer.parseInt(sc.nextLine());

		//ビンゴカード用の配列を作成
		String[][] words = new String[size][size];

		//ビンゴワードを入力し、配列に格納する
		for(int i = 0;i < size;i++) {
			words[i] = sc.nextLine().split(" ");
		}

		//単語の数を取得し、変数に格納する
		int num = Integer.parseInt(sc.nextLine());

		//ビンゴカードの中に選ばれた単語が登場すれば「〇」という記号に置き換える
		for(int i = 0;i < num;i++) {
			String word = sc.nextLine();
			for(int j = 0;j < words.length;j++) {
				for(int k = 0;k < words[j].length;k++) {
					if(words[j][k].equals(word)) {
						words[j][k] = "〇";
					}
				}
			}
		}

		boolean b1 = horizontalCheck(words,size);	//横の列のビンゴを確認
		boolean b2 = verticalCheck(words,size);		//縦の列のビンゴを確認
		boolean b3 = diagonalCheck1(words,size);		//斜め(右肩下がり)の列のビンゴを確認
		boolean b4 = diagonalCheck2(words,size);		//斜め(左肩下がり)の列のビンゴを確認
		if(b1 || b2 || b3 || b4) {
			//揃った
			System.out.println("yes");
		}else {
			//揃わなあった
			System.out.println("no");
		}
	}

	//横の列のビンゴを確認
	static boolean horizontalCheck(String[][] words, int size) {
		int num = 0;
		for(int j = 0;j < size;j++) {
			for(int k = 0;k < size;k++) {
				if( words[j][k].equals("〇") ) {
					num++;
					continue;
				}
			}
			if(num == size) {
				return true;
			}
			num = 0;
		}
		return false;
	}

	//縦の列のビンゴを確認
	static boolean verticalCheck(String[][] words, int size) {
		int num = 0;
		for(int j = 0;j < size;j++) {
			for(int k = 0;k < size;k++) {
				if( words[k][j].equals("〇") ) {
					num++;
					continue;
				}
			}
			if(num == size) {
				return true;
			}
			num = 0;
		}
		return false;
	}

	//斜め(右肩下がり)の列のビンゴを確認
	static boolean diagonalCheck1(String[][] words, int size) {
		int num = 0;
		for(int j = 0;j < size;j++) {
			if( words[j][j].equals("〇") ) {
				num++;
				continue;
			}
		}
		if(num == size) {
			return true;
		}
		num = 0;
		return false;
	}

	//斜め(左肩下がり)の列のビンゴを確認
	static boolean diagonalCheck2(String[][] words, int size) {
		int num = 0;
		for(int j = 0;j < size;j++) {
			if( words[j][(size-1) - j].equals("〇") ) {
				num++;
				continue;
			}
		}
		if(num == size) {
			return true;
		}
		num = 0;
		return false;
	}

}
