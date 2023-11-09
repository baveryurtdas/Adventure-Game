public class Inventory {

    private Weapon weapon;
    private Armor armor;
    private String hasFood, hasFireWood, hasWater;

    public Inventory() {
        this.weapon = new Weapon("Yumruk", -1, 0, 0);
        this.armor = new Armor("Çıplak", -1, 0, 0);
    }


    public String getHasFood() {
        return hasFood;
    }

    public void setHasFood(String hasFood) {

        this.hasFood = hasFood;
    }

    public String getHasFireWood() {
        return hasFireWood;
    }

    public void setHasFireWood(String hasFireWood) {
        this.hasFireWood = hasFireWood;
    }

    public String getHasWater() {
        return hasWater;
    }

    public void setHasWater(String hasWater) {
        this.hasWater = hasWater;
    }



    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }


}
