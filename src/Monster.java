import java.util.Random;

// Класс монстров
class Monster extends Creature {

    // Конструктор для экзэмпляра класса Monster
    public Monster(String name) {
        super(name);
    }

    // Метод для создания монстра с именем
    public static Monster createNewMonster() {
        String[] monsterNames = {"Гоблин", "Орк", "Вампир", "Зомби", "Ведьма", "Скелет", "Разбойник"};
        Random rand = new Random();
        String randomName = monsterNames[rand.nextInt(monsterNames.length)];
        return new Monster(randomName);
    }
}