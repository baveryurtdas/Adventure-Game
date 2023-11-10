public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player, "Güvenli ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz.");
        System.out.println("Canınız yenilendi.");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());

        if(getPlayer().getInventory().getFoodCount() == 1 && getPlayer().getInventory().getWaterCount() == 1 && getPlayer().getInventory().getFireWoodCount()==1){
            System.out.println("Oyunu kazandınız.");
        }else{
            System.out.println("Oyunu kazanmak için tüm bölgelerin ödüllerini toplayıp tekrar güvenli eve dön.");
        }
        return true;
    }
}
