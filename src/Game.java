import java.util.Scanner;

// Game sınıfı, macera oyununu başlatan ve oyunun temel akışını kontrol eden bir sınıftır.
public class Game {
    public Scanner scan = new Scanner(System.in);


    // oyunu başlatan metot
    public void start() {
        System.out.println("Macera oyununa hoş geldiniz. ");
        System.out.print("Lütfen bir isim giriniz :  ");
        String playerName = scan.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " adaya hoşgeldiniz.");
        player.selectChar();


        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("-----Bölgeler : ");
            System.out.println("1 - Güvenli Ev ---> Burası sizin için güvenli bir ev düşman yok.");
            System.out.println("2 - Esya Dükkanı --> Silah veya zırh satın alabilirsiniz.");
            System.out.println("3 - Mağara --> Mağaraya git, ÖDÜL : " );
            System.out.println("4 - Orman ---> Ormana git, ÖDÜL  : ");
            System.out.println("5 - Nehir ---> Nehire git, ÖDÜL : ");
            System.out.println("0 - Çıkış yap,oyunu sonlandır.");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLocation = scan.nextInt();
            switch (selectLocation) {
                case 0:
                    location = null;
                    break;

                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz !");
            }

            if (location == null) {
                System.out.println("Oyun bitti yine bekleriz.");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game OVER !");
                break;
            }


        }

    }
}
