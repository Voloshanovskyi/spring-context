package org.example.spring_context;

public class FightClubImpl implements FightClub {
    private CombatCat loriCat;
    private CombatCat baxterCat;
    public void setLoriCat(final CombatCat loriCat) {
        this.loriCat = loriCat;
    }
    public void setBaxterCat(final CombatCat baxterCat) {
        this.baxterCat = baxterCat;
    }
    @Override
    public void fight() {
        System.out.println("First cat: " + loriCat.toString());
        System.out.println("Second cat: " + baxterCat.toString());
        Integer loriCatStrength = loriCat.getStrength();
        Integer baxterCatStrength = baxterCat.getStrength();
        String loriCatName = loriCat.getName();
        String baxterCatName = baxterCat.getName();
        if (loriCatStrength > baxterCatStrength) {
            System.out.println(loriCatName + " cat win");
        } else if (baxterCatStrength > loriCatStrength) {
            System.out.println(baxterCatName + " cat win");
        } else {
            System.out.println("Cats strength is the same");
        }
    }
}

