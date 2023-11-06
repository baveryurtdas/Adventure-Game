import java.util.Random;

public abstract class BattleLoc extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLoc(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    boolean onLocation() {
        int monstNumber = this.randomMonsterNumber();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol, burada " + monstNumber + " tane " + this.getMonster().getName() + " yaşıyor.");
        System.out.print("Savaşmak için <S> harfine bas, Kaçmak için <K> harfine bas : ");
        String selectBattle = scan.nextLine();
        selectBattle = selectBattle.toUpperCase();
        if(selectBattle.equals("S")){
            System.out.println("Savaşma İşlemleri");
        }
        return true;
    }

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
