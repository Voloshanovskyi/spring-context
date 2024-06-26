package org.example.spring_context;

public class CombatCat {
    private String name;
    @CalculateCatStrength(minStrength = 10, maxStrength = 15)

    private Integer strength;
    @Override
    public String toString() {
        return "CombatCat{" + "name='" + name + '\'' +
               ", strength=" + strength +
               '}';
    }
    public Integer getStrength() {
        return strength;
    }
    public void setStrength(final Integer strength) {
        this.strength = strength;
    }
    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
}
