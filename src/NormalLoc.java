//NormalLoc sınıfı, oyuncunun karşılaşabileceği normal konumları temsil eden soyut bir sınıftır.
// Bu sınıf, genel olarak olay olmayan, sadece bilgi içeren konumları ifade eder.

public abstract class NormalLoc extends Location {
    public NormalLoc(Player player, String name) {
        super(player, name);
    }


    // Normal konumda gerçekleşecek olayları işleyen metot.
    @Override
    public boolean onLocation() {
        return true;
    }
}
