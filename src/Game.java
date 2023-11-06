import java.util.Scanner;

public  class Game {
    public Scanner scan = new Scanner(System.in);


    public void start() {
        System.out.println("Macera oyununa hoş geldiniz. ");
        System.out.print("Lütfen bir isim giriniz :  ");
        //String playerName = scan.nextLine();
        Player player = new Player("Baver");
        System.out.println("Sayın " + player.getName() + " adaya hoşgeldiniz.");
        player.selectChar();


        Location location = null;
        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("-----Bölgeler : ");
            System.out.println("1 - Güveli Ev ---> Burası sizin için güvenli bir ev düşman yok.");
            System.out.println("2 - Mağaza --> Silah veya zırh satın alabilirsiniz.");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLocation = scan.nextInt();
            switch (selectLocation){
                case 1 :
                    location = new SafeHouse(player);
                    break;
                case 2 :
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if(!location.onLocation()){
                System.out.println("Game OVER !");
                break;
            }

        }

    }
}
