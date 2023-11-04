import java.util.Scanner;

public class Player {


    private int damage;
    private int health;
    private int money;
    private String charName;

    private String name;
    public Scanner scan = new Scanner(System.in);


    public Player(String name) {
        this.name = name;
    }

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
        System.out.println("Karakter : " + this.getCharName() +
                "\t Hasar  : " + this.getDamage() +
                "\t Sağlık : " + this.getHealth() +
                "\t Para : " + getMoney());
    }

    public void selectLocation(){
        Location location = null;
        System.out.println("Bölgeler : ");
        System.out.println("1 - Güveli Ev");
        System.out.println("2 - Mağaza");
        System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
        int selectLocation = scan.nextInt();
        switch (selectLocation){
            case 1 :
                location = new SafeHouse(this);
                break;
            case 2 :
                location = new ToolStore(this);
                break;
            default:
                location = new SafeHouse(this);
        }

        location.onLocation();

    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
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
}
