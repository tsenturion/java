import java.util.Random;
import java.util.Scanner;

abstract class Character {
    protected String name;
    protected int health;
    protected int attackPower;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // Общий метод attack() - но он абстрактный!
    // Почему? Потому что каждый персонаж атакует ПО-РАЗНОМУ.
    public abstract void attack(Character target);

    // Общий метод takeDamage(int damage) – здесь уже есть базовая логика
    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(name + " получает " + damage + " урона. Осталось здоровья: " + Math.max(health, 0));
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }
}

class Warrior extends Character {
    public Warrior(String name) {
        super(name, 150, 25); // Много здоровья, средняя атака
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " наносит мощный удар мечом по " + target.getName() + "!");
        target.takeDamage(attackPower);
    }
}

class Mage extends Character {
    public Mage(String name) {
        super(name, 80, 15); // Мало здоровья, слабая базовая атака
    }

    @Override
    public void attack(Character target) {
        boolean isCritical = Math.random() > 0.7; // 30% шанс на критическую атаку
        int finalDamage = attackPower;

        if (isCritical) {
            finalDamage *= 3; // Утраиваем урон!
            System.out.println(name + " выпускает огненный шар по " + target.getName() + "! КРИТИЧЕСКИЙ УРОН!");
        } else {
            System.out.println(name + " бросает магическую стрелу в " + target.getName() + ".");
        }

        target.takeDamage(finalDamage);
    }
}

class Archer extends Character {
    public Archer(String name) {
        super(name, 100, 20); // Среднее здоровье, хорошая атака
    }

    @Override
    public void attack(Character target) {
        boolean doubleShot = Math.random() > 0.6; // 40% шанс на двойной выстрел
        int finalDamage = attackPower;

        if (doubleShot) {
            finalDamage *= 2; // Двойной выстрел!
            System.out.println(name + " делает двойной выстрел из лука по " + target.getName() + "!");
        } else {
            System.out.println(name + " стреляет из лука в " + target.getName() + ".");
        }

        target.takeDamage(finalDamage);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 1. Выбор персонажа игроком
        System.out.println("Выбери своего бойца: 1 - Воин, 2 - Маг, 3 - Лучник");
        int choice = scanner.nextInt();
        Character player = createCharacter(choice, "Игрок");

        // 2. Случайный враг
        Character enemy = createCharacter(random.nextInt(3) + 1, "Враг");

        System.out.println("Ваш персонаж: " + player.getName() + " vs " + enemy.getName() + "\nБой начинается!\n");

        // 3. Игровой цикл
        boolean isPlayerTurn = true;
        while (player.isAlive() && enemy.isAlive()) {
            Character attacker = isPlayerTurn ? player : enemy;
            Character target = isPlayerTurn ? enemy : player;

            attacker.attack(target);
            isPlayerTurn = !isPlayerTurn; // Передаем ход
            
            // Пауза между ходами для удобства чтения
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 4. Определение победителя и награда
        Character winner = player.isAlive() ? player : enemy;
        System.out.println("\nПобедитель: " + winner.getName() + "!");

        // 5. Появление зелья
        int healthPotion = random.nextInt(50) + 1;
        int strengthPotion = random.nextInt(10) + 1;
        System.out.println("После боя вы нашли зелье! Восстановлено здоровья: " + healthPotion + ", Сила увеличена на: " + strengthPotion);
        
        scanner.close();
    }

    // Полиморфизм в действии! Метод возвращает Character, но создает конкретного наследника.
    private static Character createCharacter(int type, String baseName) {
        switch (type) {
            case 1: return new Warrior(baseName + "-Воин");
            case 2: return new Mage(baseName + "-Маг");
            case 3: return new Archer(baseName + "-Лучник");
            default: return new Warrior(baseName + "-Боец");
        }
    }
}