public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("-----------Mağazaya Hoşgeldiniz-------- ");
        System.out.println("1- Silahlar");
        System.out.println("2- Zırhlar");
        System.out.println("3- Çıkış yap");
        System.out.print("Seçiminiz : ");
        int selectCase = scan.nextInt();
        while (selectCase < 1 || selectCase > 3) {
            System.out.println("Geçersiz değer, tekrar giriniz. ");
            selectCase = scan.nextInt();
        }
        switch (selectCase) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Tekrar bekleriz");
                return true;

        }

        return true;
    }

    public void printWeapon() {
        System.out.println("-----------Silahlar-----------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(+w.getId() + "- " + w.getName() + " Para : " + w.getPrice() + " Hasar : " + w.getDamage());
        }
        System.out.println();
    }

    public void buyWeapon() {
        System.out.print("Bir silah seçiniz : ");
        int selectWeaponID = scan.nextInt();
        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Geçersiz değer, tekrar giriniz. ");
            selectWeaponID = scan.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);


        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır.");
            } else {
                //Satın alma gerçekleşmesi
                System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }

    public void printArmor() {
        System.out.println("-----------Zırhlar-----------");
    }
}
