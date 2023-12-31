# MineSweeper

MineSweeper, Java programlama dilinde geliştirilmiş basit bir Mayın Tarlası oyunudur.

## Oyun Açıklaması

Bu oyun, kullanıcının bir mayın tarlasındaki mayınları bulmaya çalıştığı klasik bir bilgisayar oyunudur. Kullanıcı, tarlanın herhangi bir hücresini seçer ve hücrede mayın varsa oyunu kaybeder, yoksa kaç tane komşu hücrede mayın olduğu bilgisini alır. Oyun, tüm mayınlar bulunana kadar devam eder.

## Nasıl Oynanır

Oyunu başlatmak için:

```java
public static void main(String[] args) {
    MineSweeper mineSweeper = new MineSweeper(10, 10); // Satır ve sütun sayısını belirleyerek oyunu başlatın
    mineSweeper.start();
}
Oyun sırasında kullanıcıya hangi hücreyi seçeceğini sorulur. Seçilen hücrede mayın varsa oyun kaybedilir, yoksa oyun devam eder.

Metodlar
start(): Oyunu başlatan metod.
preparationMineSweeper(): Mayın tarlasını hazırlayan metod.
countAdjacentMines(int actualRow, int actualColumn): Belirli bir hücredeki komşu mayın sayısını hesaplayan metod.
isValidPosition(int row, int column): Verilen satır ve sütunun geçerli bir konum olup olmadığını kontrol eden metod.
isWin(): Oyunun kazanılıp kazanılmadığını kontrol eden metod.
mainSweeperPrint(String[][] arr): Haritayı ekrana basan metod.

Katkıda Bulunma
Eğer bu oyunu geliştirmek veya hataları düzeltmek istiyorsanız, lütfen bir çekme isteği (pull request) gönderin. Katkılarınızı bekliyoruz!

