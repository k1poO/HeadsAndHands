import java.util.Random;

// Абстрактный класс существ
abstract class Creature {
    protected final int attack;
    protected final int defense;
    protected int health;
    protected final int damageMin;
    protected final int damageMax;
    protected int playerMaxHealth;
    protected String name;

    // Конструктор для существ
    protected Creature(String name) {
        this.name = name;
        this.attack = getRandomNumber(1, 30);
        this.defense = getRandomNumber(1, 30);
        this.health = getRandomNumber(0, 80);
        this.damageMin = getRandomNumber(5, 15);
        this.damageMax = getRandomNumber(20, 35);
    }

    // Метод для выбора случайного числа из нужного диапазона
    protected int getRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    // Метод для реализации атаки существом
    protected void attack(Creature defender) {
        int modifier = attack - defender.defense + 1; // Расчет модификатора
        modifier = Math.max(modifier, 1); // Минимальное значение модификатора - 1
        int diceRolls = modifier;
        boolean flag = false;

        System.out.println("Атакующий бросает " + diceRolls + " кубик(-ов/-а).");
        for (int i = 0; i < diceRolls; i++) {
            int diceResult = getRandomNumber(1, 6);
            System.out.println("Результат " + (i + 1) + " броска " + diceResult);

            if (diceResult >= 5) {
                int damageDealt = getRandomNumber(damageMin, damageMax);
                System.out.println("Атака прошла успешно и нанесла " + damageDealt + " урона.");
                takeDamage(defender, damageDealt);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Атака была не успешной");
        }
    }

    // Метод для вывода информации о существе
    protected void getInfo() {
        System.out.println("Характеристики " + name + ":");
        System.out.println("Атака: " + attack);
        System.out.println("Защита: " + defense);
        System.out.println("Здоровье: " + health);
        System.out.println("Урон: " + damageMin + "-" + damageMax + "\n");
    }

    // Метод для получения урона существом
    protected void takeDamage(Creature defender, int damage) {
        defender.health -= damage;
        if (defender.health < 0) {
            defender.health = 0;
        }
    }

    // Метод для проверки живо ли существо
    protected boolean isAlive() {
        return health > 0;
    }

    // Геттер дял здоровья существа
    protected int getHealth() {
        return health;
    }

    // Геттер для имени существа
    protected String getName() {
        return name;
    }

}
