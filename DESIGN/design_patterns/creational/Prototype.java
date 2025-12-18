// ===== PROTOTYPE INTERFACE =====
interface WeaponPrototype {
    Weapon cloneWeapon();
}

// ===== PRODUCT =====
class Weapon implements WeaponPrototype {

    private String name;
    private int damage;
    private String rarity;
    private Attachment attachment;

    // Constructor (used only once for prototype creation)
    Weapon(String name, int damage, String rarity, Attachment attachment) {
        this.name = name;
        this.damage = damage;
        this.rarity = rarity;
        this.attachment = attachment;
    }

    // Copy constructor = deep copy
    private Weapon(Weapon other) {
        this.name = other.name;
        this.damage = other.damage;
        this.rarity = other.rarity;
        this.attachment = new Attachment(other.attachment);
    }

    @Override
    public Weapon cloneWeapon() {
        return new Weapon(this);
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", rarity='" + rarity + '\'' +
                ", attachment=" + attachment +
                '}';
    }
}

// ===== NESTED OBJECT =====
class Attachment {
    private String type;

    Attachment(String type) {
        this.type = type;
    }

    // Copy constructor
    Attachment(Attachment other) {
        this.type = other.type;
    }

    @Override
    public String toString() {
        return type;
    }
}

// ===== CLIENT =====
public class Prototype {

    public static void main(String[] args) {

        // Base prototype weapon
        Weapon swordPrototype =
                new Weapon("Sword", 50, "Common", new Attachment("Steel Blade"));

        // Clone similar weapons
        Weapon sword1 = swordPrototype.cloneWeapon();
        Weapon sword2 = swordPrototype.cloneWeapon();
        Weapon sword3 = swordPrototype.cloneWeapon();

        System.out.println(sword1);
        System.out.println(sword2);
        System.out.println(sword3);
    }
}