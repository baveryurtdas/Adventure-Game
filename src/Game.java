

public  class Game {

    public void start() {
        System.out.println("Macera oyununa hoş geldiniz. ");
        System.out.print("Lütfen bir isim giriniz :  ");
        //String playerName = scan.nextLine();
        Player player = new Player("Baver");
        System.out.println("Sayın " + player.getName() + " adaya hoşgeldiniz.");
        player.selectChar();
        player.selectLocation();

    }
}
