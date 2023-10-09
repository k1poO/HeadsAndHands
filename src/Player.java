// Класс для игрока
class Player extends Creature {
    private int healCount = 4;

    // Конструктор для экзэмпляра класса Player
    public Player(String name) {
        super(name);
        this.health = 100;
        this.playerMaxHealth = this.health;
    }

    // Метод для лечения игрока
    public void heal() {
        if (healCount > 0) {
            int maxHeal = (int) (health + (playerMaxHealth * 0.3));
            health = Math.min(maxHeal, playerMaxHealth);
            healCount--;
            System.out.println("♥♥♥♥♥ Вы исцелились на " + (int) (playerMaxHealth * 0.3) + " единиц здоровья. Осталось исцелений: " + healCount + " ♥♥♥♥♥");
        } else {
            System.out.println("У вас больше нет возможности исцеляться в этой игре, Вы пропускаете ход");
        }
    }

}