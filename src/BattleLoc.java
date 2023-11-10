import java.util.Random;

//BattleLoc sınıfı, savaş alanlarını temsil eden soyut bir sınıftır.
//Bu sınıf, oyuncunun canavarlarla savaştığı ve ödüller kazandığı özel bir konum türünü tanımlar.
public abstract class BattleLoc extends Location {
    private Monster monster; // Savaş alanındaki canavarı temsil eden değişken
    private String award; // Savaş sonrası kazanılacak ödülün adını tutan değişken
    private int maxMonster; // Savaş alanındaki maksimum canavar sayısını belirten değişken


    public BattleLoc(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }


    //BattleLoc sınıfının üzerine yazılmış olan soyut metot.
    //Bu metot, savaş alanındaki olayları işler ve savaşın sonucunu belirler.
    @Override
    boolean onLocation() {
        int monstNumber = this.randomMonsterNumber();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol, burada " + monstNumber + " tane " + this.getMonster().getName() + " yaşıyor.");
        System.out.print("Savaşmak için <S> harfine bas, Kaçmak için <K> harfine bas : ");
        String selectBattle = scan.nextLine().toUpperCase();
        if (selectBattle.equals("S") && combat(monstNumber)) {
            System.out.println(this.getName() + " bölgesinin tüm düşmanları öldürdünüz.");
            return true;
        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz.");
            return false;
        }
        return true;
    }

    // Oyuncunun canavalarla savaştığı metot
    public boolean combat(int monstNumber) {
        for (int i = 1; i <= monstNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getOrginalHealth());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println();
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat = scan.nextLine().toUpperCase();

                if (selectCombat.equals("V")) {
                    System.out.println("Siz vurdunuz.");
                    this.monster.setHealth(this.monster.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println();
                        System.out.println("Canavar size vurdu.");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getDefence();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();

                    }
                } else {
                    return false;
                }
            }
            if (this.getMonster().getHealth() < this.getPlayer().getHealth()) {
                int count = 0;
                System.out.println("Düşmanı yendiniz.");
                System.out.println(this.getMonster().getAwardMoney() + " para kazandınız.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAwardMoney());
                System.out.println("Güncel paranız : " + this.getPlayer().getMoney());
                if (i == monstNumber && this.getMonster().getName().equals("Zombi")) {
                    this.getPlayer().getInventory().setFood(true);
                    count++;
                    System.out.println("Tebrikler yemek kazandınız.");
                    this.getPlayer().getInventory().setFoodCount(count);
                } else if (i == monstNumber && this.getMonster().getName().equals("Vampir")) {
                    this.getPlayer().getInventory().setFireWood(true);
                    count++;
                    System.out.println("Tebrikler odun kazandınız.");
                    this.getPlayer().getInventory().setFireWoodCount(count);
                } else if (i == monstNumber && this.getMonster().getName().equals("Ayı")) {
                    this.getPlayer().getInventory().setWater(true);
                    count++;
                    System.out.println("Tebrikler su kazandınız.");
                    this.getPlayer().getInventory().setWaterCount(count);

                } else {
                    System.out.println("Buradan hiç birşey kazanamadınız.");
                }
            }


        }
        return true;
    }

    //Her vuruş sonrasında ekrana canavar ve oyuncunun güncel sağlık durumlarını yazdıran metot.

    public void afterHit() {
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + " canı : " + this.getMonster().getHealth());
        System.out.println("------------");
    }


    //Oyuncunun genel istatiklerini ekrana yazdıran metot.
    public void playerStats() {
        System.out.println("Oyuncu değerleri : ");
        System.out.println("------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getDefence());
        System.out.println("Toplam Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println();


    }

    // Canavarın genel özelliklerini ekrana yazdıran metot.

    public void monsterStats(int i) {
        System.out.println(i + ". " + this.getMonster().getName() + " Değerleri");
        System.out.println("-------------------");
        System.out.println("Sağlık : " + this.getMonster().getHealth());
        System.out.println("Hasar : " + this.getMonster().getDamage());
        System.out.println("Para Ödülü : " + this.getMonster().getAwardMoney());
    }

    //Bölgede çıkacak olan canavarların random değerini atama.
    public int randomMonsterNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
