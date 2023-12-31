import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(">>>>>>>>>>MENU<<<<<<<<<<");
        System.out.print("Oyunun satır sayısını giriniz: ");//Kullanıcıdan satır boyutunu alır
        int rowSize = input.nextInt();
       while ((rowSize < 2)) {//Kullanıcı 2 den küçük satır boyutu girerse hata alır ve 2 den büyük satır boyutu girmesini ister
            System.out.print("Girdiğiniz satır sayısı 2'den küçük olamaz... Lütfen 2'den büyük değer giriniz : ");
            rowSize = input.nextInt();
        }
        System.out.print("Oyunun sütun sayısını giriniz: ");//Kullanıcıdan sütun boyutunu alır
        int columnSize = input.nextInt();
        while ((columnSize < 2)) {//Kullanıcı 2 den küçük sütun boyutu girerse hata alır ve 2 den büyük satır boyutu girmesini ister
            System.out.print("Girdiğiniz sütun sayısı 2'den küçük olamaz... Lütfen 2'den büyük değer giriniz : ");
            columnSize = input.nextInt();
        }

        MineSweeper mineSweeperGame = new MineSweeper(rowSize, columnSize);
        mineSweeperGame.start();//Oyunu başlatır.
    }
}