import java.util.Random;

public class Cat implements Attackers, showInfo {
    int health;
    int strength;
    int speed;
    String breed;
    String name;
    Random random = new Random();

    public Cat(String breed, String name) {
        this.breed = breed;
        this.name = name;
    }

    public int attack() {
        int damage = 1 + random.nextInt(Math.max(1, this.strength / 2));
        return damage;
    }

    public void hit(int damage) {
        int dodgeChance = random.nextInt(100);
        if (dodgeChance < 20) {
            System.out.println(this.name + "(이)가 회피했습니다!");
            return;
        } else {
            this.health -= damage;
        }
    }
    public Cat died(){
        System.out.println(this.name+"(이)가 죽었습니다");
        return this;
    }
    public void info() {
        System.out.println(this.name + " (" + this.breed + ")");
    }
}
class CatFactory{
    Random random = new Random();

    Cat RandomCat(Dog userDog){
        String [] names = {"더러운","못생긴","검은","버림받은","상처있는","냄새나는","멍청한","뚱뚱한"};
        String [] breeds = {" 길고양이"," 샴"," 러시안블루"," 페르시안"," 노르웨이숲"," 먼치킨"};
        String randomName = names[random.nextInt(5)]+breeds[random.nextInt(7)];
        Cat cat = new Cat(breeds[random.nextInt(7)],randomName );
        cat.health=userDog.health+random.nextInt(5)-20;
        cat.speed= userDog.speed+ random.nextInt(5)+1;
        cat.strength = userDog.strength+ random.nextInt(5)-20;
        return cat;
    }
}
