package org.example.spring_context;

public class CombatCat {
    private String name;
    private Integer strength;
    @CalculateCatStrength(minStrength = 10, maxStrength = 15)

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CombatCat{");
        sb.append("name='").append(name).append('\'');
        sb.append(", strength=").append(strength);
        sb.append('}');
        return sb.toString();
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
