public class Armor {
    private String name;
    private int id;
    private int defence;
    private int price;

    public Armor(String name, int id, int defence, int price) {
        this.name = name;
        this.id = id;
        this.defence = defence;
        this.price = price;
    }

    public static Armor[] armors() {
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Hafif", 1, 1, 15);
        armorList[1] = new Armor("Orta", 2, 3, 25);
        armorList[2] = new Armor("Ağır", 3, 5, 40);
        return armorList;
    }

    public static Armor getArmorObjByID(int id) {
        for (Armor a : Armor.armors()) {
            if (a.getId() == id) {
                return a;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
