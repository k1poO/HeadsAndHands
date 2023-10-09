import java.util.Scanner;

// Основной класс игры
public class Game {
    // Метод для получения числа от пользователя с проверкой на правильность ввода
    public static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Неверный ввод. Пожалуйста, введите число.");
            scanner.next(); // Считываем неправильный ввод
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создание сканнера для считывания информации через консоль

        // Ввод имени игрока
        System.out.print("Введите ваше имя: ");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName); // Создание объекта класса Player
        Monster currentMonster = Monster.createNewMonster(); // Создание объекта класса Monster

        player.getInfo(); // Вывод информации об игроке
        currentMonster.getInfo(); // Вывод информации о монстре

        int turn = 1; // Счетчик хода1
        while (player.isAlive()) {
            // Информация о ходе и здоровье противника и игрока
            System.out.println("\n--------Ход " + turn + "--------");
            System.out.println("Здоровье игрока " + playerName + ": " + player.getHealth());
            System.out.println("Здоровье противника: " + currentMonster.getHealth());

            // Начало хода
            if (turn % 2 == 1) {
                int choice;
                System.out.println("\n!   Ваш ход   !");
                System.out.print("Выберите действие (1 - Атаковать, 2 - Исцелиться): ");
                while (true) {
                    // Проверка на ввод случайных символов
                    choice = getIntInput(scanner);
                    if (choice == 1 || choice == 2) {
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("Неверный выбор, Введите 1 или 2.");
                    }
                }

                if (choice == 1) {
                    // Атака игрока
                    player.attack(currentMonster);
                } else {
                    // Лечение игрока
                    player.heal();
                }

            } else {
                // Атака монстра
                System.out.println("\n!   Атака монстра   !");
                currentMonster.attack(player); // Ход Противника
            }

            // Проверка на то жив ли монстр, если нет, то создаем нового
            if (!currentMonster.isAlive()) {
                System.out.println("\n*****  Монстр побежден!  *****");
                currentMonster = Monster.createNewMonster();
                System.out.println("\nВаш новый противник " + currentMonster.getName());
                currentMonster.getInfo();
            }

            // Проверка на то жив ли игрок
            if (!player.isAlive()) {
                System.out.println("\n+++++ " + playerName + " проиграл. Игра окончена. +++++");
                break; // Завершить игру при смерти игрока
            }

            turn++; // Счетчик хода

            // Ждем нажатия клавиши для продолжением
            System.out.print("Нажмите Enter, чтобы продолжить...");
            scanner.nextLine();
        }
        scanner.close();
    }
}