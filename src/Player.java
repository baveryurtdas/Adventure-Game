import java.util.Scanner;

//Player sınıfı, oyuncu karakterini temsil eden bir sınıftır.
//Oyuncunun hasar, sağlık, para, karakter adı gibi özellikleri ve envanteri bulunur.


public class Player {


    private int damage; // Oyuncunun verdiği hasarı temsil eden değişken
    private int health; // Oyuncunun sağlık puanını temsil eden değişken
    private int originalHealth; // Oyuncunun orijinal sağlık puanını temsil eden değişken
    private int money; // Oyuncunun sahip olduğu para miktarını temsil eden değişken
    private String charName; // Oyuncunun karakter adını temsil eden değişken

    private String name; // Oyuncunun adını temsil eden değişken
    public Scanner scan = new Scanner(System.in);
    private Inventory inventory; // Oyuncunun envanterini temsil eden değişken



    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    //Oyuncunun karakter seçimini gerçekleştiren metot.
    public void selectChar() {

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Karakterler : ");
        System.out.println("---------------------------------------------------------------------------");
        for (GameChar gameChar : charList) {

            System.out.println("ID : " + gameChar.getId() +
                    "\t\t Karakter : " + gameChar.getName() +
                    "\t\t Hasar : " + gameChar.getDamage() +
                    "\t\t Sağlık : " + gameChar.getHealth() +
                    "\t\t Para : " + gameChar.getMoney());

        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.print("Lütfen oyuna başlamak için bir karakter seçin : ");

        int selectChar = scan.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
            default:
                initPlayer(new Samurai());
        }
    }


    //Oyuncunun başlangıç bilgilerini ayarlayan metot.
    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }


    //Oyuncunun bilgilerini ekrana yazdıran metot.
    public void printInfo() {
        System.out.println("------------------------------------------------------------");
        System.out.println(
                " Silah : " + this.getInventory().getWeapon().getName() +
                        "\t Zırh : " + this.getInventory().getArmor().getName() +
                        "\t Blok : " + this.getInventory().getArmor().getDefence() +
                        "\t Hasar  : " + this.getTotalDamage() +
                        "\t Sağlık : " + this.getHealth() +
                        "\t Para : " + this.getMoney() +
                        "\t Yemek  : " + this.getInventory().getFoodCount() +
                        "\t Odun  : " + this.getInventory().getFireWoodCount() +
                        "\t Su : " + this.getInventory().getWaterCount());
        System.out.println("-----------------------------------------------------------");

    }

    //Oyuncunun toplam hasarını hesaplayan metot.
    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();

    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        // Sağlık puanı negatif olmaması için kontrol eklenmiştir.
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon() {
        return this.getInventory().getWeapon();
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
