package com.github.liosha2007.android.kg.girldress.common;

/**
 * @autored by liosha on 30.06.2014.
 */
public enum ComponentType {
    BEAD(1), // Бусы
    DRESS(2), // Платье
    HEIR(3), // Волосы
    HOSE(4), // Чулки
    SKIRT(5), // Юбка
    EARRING(6), // Серьги
    BONNET(7), // Чепчик
    BANGLE(8), // Браслет
    SHOES(9), // Туфли
//    APRON(4), // Фартук
//    BLOUSE(5), // Кофта
//    PANTS(6), // Штаны
    ;

    private final int id;

    /**
     * Constructor
     *
     * @param id component type id
     */
    private ComponentType(int id) {
        this.id = id;
    }

    /**
     * Check if component type is equal
     *
     * @param id component type id to compare
     * @return
     */
    public boolean equalsName(int id) {
        return this.id == id;
    }

    /**
     * Convert id to string
     *
     * @return id
     */
    @Override
    public String toString() {
        return Integer.toString(this.id);
    }

    /**
     * Get component type by id
     *
     * @param id component type id
     * @return component type
     */
    public static ComponentType fromValue(int id) {
        return (id < 1 || id > 10) ? null : ComponentType.values()[id];
    }

    /**
     * Get id
     *
     * @return id
     */
    public int value() {
        return id;
    }
}
