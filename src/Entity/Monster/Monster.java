// Monster sınıfı, oyun içindeki düşman karakterlerini temsil eden bir sınıftır.
// Her bir canavarın benzersiz bir kimliği, ismi, verdiği hasar, sağlık puanı, ödül parası gibi özellikleri bulunur.
public class Monster {
    private int id; // Canavarın benzersiz kimliğini temsil eden değişken
    private String name; // Canavarın adını temsil eden değişken

    private int damage; // Canavarın verdiği hasarı temsil eden değişken
    private int health; // Canavarın sağlık puanını temsil eden değişken
    private int awardMoney; // Canavarın ödül parasını temsil eden değişken
    private int orginalHealth; // Canavarın orijinal sağlık puanını temsil eden değişken

    public Monster(int id, String name, int damage, int health, int awardMoney) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.orginalHealth = health;
        this.awardMoney = awardMoney;
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

    public int getAwardMoney() {
        return awardMoney;
    }

    public void setAwardMoney(int awardMoney) {
        this.awardMoney = awardMoney;
    }

    public int getOrginalHealth() {
        return orginalHealth;
    }

    public void setOrginalHealth(int orginalHealth) {
        this.orginalHealth = orginalHealth;
    }
}
