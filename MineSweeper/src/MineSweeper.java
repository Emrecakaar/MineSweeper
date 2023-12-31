import java.util.Random;//Mayınları random bir şekilde atayabilmek için yardım aldım.
import java.util.Scanner;//Kullanıcıdan giriş alabilmek için yardım aldım.

public class MineSweeper {//Mayın tarlamı bu sınıf içerisinde tasarladım.
    Random random = new Random();
    Scanner input = new Scanner(System.in);
    int mineSweeperRowSize;//Mayın tarlamın satır boyutunu belirtir.
    int mineSweeperColumnSize;//Mayın tarlamın sütun boyutunu belirtir.
    int mineSweeperSize;//Mayın tarlamın toplam boyutunu belirtir.
    String[][] map;//Mayın tarlamda mayınların konumunu gösteren map
    String[][] board;//Kullanıcının oyunu oynadığı map


    MineSweeper(int mineSweeperRowSize, int mineSweeperColumnSize) {
        // Kurucu metod, parametreleri alır ve sınıfın özelliklerine atar
        this.mineSweeperRowSize = mineSweeperRowSize;
        this.mineSweeperColumnSize = mineSweeperColumnSize;
        this.map = new String[mineSweeperRowSize][mineSweeperColumnSize];
        this.board = new String[mineSweeperRowSize][mineSweeperColumnSize];
        this.mineSweeperSize = mineSweeperColumnSize * mineSweeperRowSize;
    }


    void start() {
        // Oyunu başlatan metod
        preparationMineSweeper();
        mainSweeperPrint(map);
    }

    void preparationMineSweeper() {
        // Mayın tarlasını hazırlayan metod
        for (int mineSweeperRow = 0; mineSweeperRow < mineSweeperRowSize; mineSweeperRow++) {
            for (int mineSweeperColumn = 0; mineSweeperColumn < mineSweeperColumnSize; mineSweeperColumn++) {
                board[mineSweeperRow][mineSweeperColumn] = " - ";// Kullanıcının gördüğü haritayı belirlemek için
                map[mineSweeperRow][mineSweeperColumn] = " - ";// Mayın olmayan yerleri belirlemek için
            }
        }
        int mineNumbers = 0;
        while (mineNumbers < (this.mineSweeperSize / 4)) { // Mayınları yerleştir
            int randomRow = random.nextInt(mineSweeperRowSize);
            int randomColumn = random.nextInt(mineSweeperColumnSize);
            if (!" * ".equals(map[randomRow][randomColumn])) {
                (map[randomRow][randomColumn]) = " * ";
                mineNumbers++;
            }
        }
        System.out.println("Mayın haritası : ");
        mainSweeperPrint(map);
        System.out.println("=======================");

        mainSweeperPrint(board);
        while (!isWin()) {
            System.out.println("=======================");
            System.out.print("Seçtiğiniz sütunun numarasını giriniz : ");
            int userRow = input.nextInt();
            while (0 > userRow || userRow > mineSweeperRowSize - 1) {
                System.out.println("Seçtiğiniz sütun sayısı 0 - " + (mineSweeperRowSize - 1) + " arasında olmalıdır.");
                System.out.print("Lütfen tekrar bir değer giriniz : ");
                userRow = input.nextInt();
            }
            System.out.print("Seçtiğiniz satır numarasını giriniz : ");
            int userColumn = input.nextInt();
            while (0 > userColumn || userColumn > mineSweeperColumnSize - 1) {
                System.out.println("Seçtiğiniz satır sayısı 0 - " + (mineSweeperColumnSize - 1) + " arasında olmalıdır.");
                System.out.print("Lütfen tekrar bir değer giriniz : ");
                userColumn = input.nextInt();
            }
            System.out.println("=======================");
            if (" * ".equals(map[userRow][userColumn])) {//Kullanıcı mayına bastığında kullandığım koşul
                System.out.println("Oyunu kaybettiniz !!! Mayına bastınız.");
                break;
            } else if (!" - ".equals(board[userRow][userColumn])) {//Kullanıcı daha önce seçtiğinde hata vermek için kullandığım koşul
                System.out.println("Bu hücre zaten seçildi. Lütfen farklı bir hücre seçin.");
            } else {//Kullanıcı mayına basmaz ve daha önce girdiği hücreyi girmezse kullandığım koşul
                board[userRow][userColumn] = " " + countAdjacentMines(userRow, userColumn) + " ";
            }
            mainSweeperPrint(board);
        }
        if (isWin()) {//Kullanıcı mayına basmadan haritayı gezip bitirdiğinde kullandığum koşul
            System.out.println("Tebrikler! Oyunu kazandınız.");
        }
    }

    int countAdjacentMines(int actualRow, int actualColumn) {// Belirli bir hücredeki komşu mayın sayısını hesaplayan metod
        int mineCount = 0;

        for (int controlRow = -1; controlRow <= 1; controlRow++) {
            for (int controlColumn = -1; controlColumn <= 1; controlColumn++) {
                int newRow = actualRow + controlRow;
                int newColumn = actualColumn + controlColumn;

                if (isValidPosition(newRow, newColumn) && " * ".equals(map[newRow][newColumn])) {
                    mineCount++;
                }
            }
        }

        return mineCount;
    }

    boolean isValidPosition(int row, int column) {// Verilen satır ve sütunun geçerli bir konum olup olmadığını kontrol eden metod

        return row >= 0 && row < mineSweeperRowSize && column >= 0 && column < mineSweeperColumnSize;
    }

    boolean isWin() {// Oyunun kazanılıp kazanılmadığını kontrol eden metod

        int uncoveredSafeCells = 0;

        for (int row = 0; row < mineSweeperRowSize; row++) {
            for (int column = 0; column < mineSweeperColumnSize; column++) {
                if (!" * ".equals(map[row][column]) && !" - ".equals(board[row][column])) {
                    uncoveredSafeCells++;
                }
            }
        }
        return uncoveredSafeCells == (mineSweeperSize - mineSweeperSize / 4);
    }


    void mainSweeperPrint(String[][] arr) {// Haritayı ekrana basan metod
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[0].length; column++) {

                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }
    }
}