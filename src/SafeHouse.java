public class SafeHouse extends NormalLoc {
    //SafeHouse sınıfı, oyuncunun güvenli ev konumunu temsil eden bir sınıftır.
    //Oyuncunun sağlığını yeniler ve oyunu kazanıp kazanmadığını kontrol eder.

    public SafeHouse(Player player) {
        super(player, "Güvenli ev");
    }



    //Güvenli evde gerçekleşen olayları işleyen metot.
    //Oyuncunun sağlığını yeniler ve tüm ödülleri toplamışsa oyunu kazanmıştır.
    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz.");
        System.out.println("Canınız yenilendi.");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        // Tüm ödüller toplandı mı kontrolü
        if(getPlayer().getInventory().getFoodCount() == 1 && getPlayer().getInventory().getWaterCount() == 1 && getPlayer().getInventory().getFireWoodCount()==1){
            System.out.println("Oyunu kazandınız.");
        }else{
            System.out.println("Oyunu kazanmak için tüm bölgelerin ödüllerini toplayıp tekrar güvenli eve dön.");
        }
        return true;
    }
}
