import java.util.Scanner;

//Location sınıfı, oyun içindeki farklı konumları temsil eden soyut bir sınıftır.
//Bu sınıf, genel olarak bir konumun adını ve o konumda gerçekleşecek olayları içerir.
public abstract class Location {
    private Player player; // Konumda bulunan oyuncuyu temsil eden değişken
    private String name; // Konumun adını temsil eden değişken
    public static Scanner scan = new Scanner(System.in);

    public Location(Player player,String name) {
        this.player = player;
        this.name=name;
    }

    //Konumda gerçekleşecek olayları işleyen metot.
    abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
