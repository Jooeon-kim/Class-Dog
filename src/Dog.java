import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dog implements Attackers, showInfo {
    //옵저버 리스트
    private List<DogObserver> observers = new ArrayList<>();

    //속성값+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    String name;
    String type;
    int age = 0;
    String breed;
    int health = 10;
    int maxHealth = 10;
    int speed = 1;
    int strength = 1;
    int attractive = 1;
    int intelligence = 1;
    int loyalty = 20;
    //속성값+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    Owner owner;
    public void info() {
        System.out.println(
                        "___________________________________"+"\n"+
                        "이름: " + this.name + "\n" +
                        "종류: " + this.breed + "\n" +
                        "타입: " + this.type + "\n" +
                        "나이: " + this.age + "살\n" +
                        "체력: " + this.health + "\n" +
                        "힘: " + this.strength + "\n" +
                        "스피드: " + this.speed + "\n" +
                        "귀여움: " + this.attractive + "\n" +
                        "지능: " + this.intelligence + "\n" +
                        "애정: " + this.loyalty+"\n"+
                        "___________________________________"
        );

    }

    //동작 함수 ****************************************************************************
    void bark() {
        System.out.println("개소리");
    }

    public int attack() {
        int damage = 1+random.nextInt(Math.max(1, this.strength / 2));
        return damage;
    }

    public void hit(int damage) {
        int actualDamage = damage + random.nextInt(3) - 1;
        actualDamage = Math.max(1, actualDamage);
        decreaseHealth(actualDamage);

    }

    public void trySkills() {
        if (this.intelligence > 5 && this.loyalty > 30){
            sitDown();}
        else{
            System.out.println("아무일도 일어나지 않았습니다. 지능이 낮거나 애정이 낮습니다");
        }

        if (this.intelligence > 15 && this.loyalty > 40) {
            giveHand();
            waitMoment();
        }
        if (this.intelligence > 25 && this.loyalty > 50) {
            turnAround();
            bang();
        }
        if (this.intelligence > 100 && this.loyalty > 100)
            javaCoding();

    }

    public void sitDown() {
        System.out.println(this.name + "가 앉았다");
    }

    public void giveHand() {
        System.out.println(this.name + "가 앞발을 줬다");
    }

    public void waitMoment() {
        System.out.println(this.name + "가 기다린다");
    }

    public void turnAround() {
        System.out.println(this.name + "가 한바퀴 돌았다");
    }

    public void bang() {
        System.out.println(this.name + "가 총맞은척 한다");
    }

    public void javaCoding() {
        System.out.println(this.name + "가 자바 코딩을 대신 해준다");
    }

    public Dog EnterField() {
        return this;
    }
    void setOwner(Owner owner){
        this.owner = owner;
    }
    void recover(){
        this.health = this.maxHealth;
    }
    public void increaseLoyalty(int heart) {
        this.loyalty += heart;
        if (this.loyalty > 100) {
            this.loyalty = 100;
        }
        alarmLoyalty();
    }

    public void decreaseLoyalty(int decrease) {
        this.loyalty -= decrease;
        if (this.loyalty < 0) {
            this.loyalty = 0;
            System.out.println("충성도가 0이 되었습니다");
            this.owner.lostDog();
        }
        alarmLoyalty();
    }

    public void increaseHealth(int heal) {
        this.health += heal;
        if(this.health>this.maxHealth){
            this.health = maxHealth;
        }
        alarmHealth();
    }
    public void decreaseHealth(int damage){
        this.health -=damage;
        if(this.health<0 && this.owner!=null){
            this.health=0;
            System.out.println("개의 체력이 다했습니다. 충성도 감소!");
            decreaseLoyalty(10);
        }
        alarmHealth();
    }

    public void setAge() {
        this.age += 1;
    }

    private void alarmHealth() {
        for (DogObserver o : observers) {
            o.onHealthChanged(this, health);
        }
    }

    private void alarmLoyalty() {
        for (DogObserver o : observers) {
            o.onLoyaltyChanged(this, loyalty);
        }
    }
    public void addObserver(DogObserver observer) {
        if(!observers.contains(observer))
            observers.add(observer);
    }

    public void removeObserver(DogObserver observer) {
        observers.remove(observer);
    }
}


class Maltese extends Dog {
    Maltese(String name) {
        this.name = name;
        this.breed = "말티즈";
        this.type = "small";
        this.speed += 1;
        this.attractive += 3;
    }
}

class Pomeranian extends Dog {
    Pomeranian(String name) {
        this.name = name;
        this.breed = "포메라니안";
        this.type = "small";
        this.speed += 1;
        this.attractive += 3;
    }
}

class YorkshireTerrier extends Dog {
    YorkshireTerrier(String name) {
        this.name = name;
        this.breed = "요크셔테리어";
        this.type = "small";
        this.speed += 1;
        this.attractive += 3;
    }
}

class PitBull extends Dog {
    PitBull(String name) {
        this.name = name;
        this.breed = "핏불";
        this.type = "Medium";
        this.strength += 4;
        this.speed += 1;
    }
}

class BorderCollie extends Dog {
    BorderCollie(String name) {
        this.name = name;
        this.breed = "보더콜리";
        this.type = "Medium";
        this.strength += 2;
        this.speed += 2;
        this.intelligence += 3;
    }
}

class JinDo extends Dog {
    JinDo(String name) {
        this.name = name;
        this.breed = "진돗개";
        this.type = "Medium";
        this.strength += 2;
        this.speed += 1;
        this.loyalty += 30;
    }
}

class SiberianHusky extends Dog {
    SiberianHusky(String name) {
        this.name = name;
        this.breed = "시베리안허스키";
        this.type = "Large";
        this.strength += 3;
    }
}

class Samoyed extends Dog {
    Samoyed(String name) {
        this.name = name;
        this.breed = "사모예드";
        this.type = "Large";
        this.strength += 3;
        this.attractive += 1;
    }
}

class GoldenRetriever extends Dog {
    GoldenRetriever(String name) {
        this.name = name;
        this.breed = "골든리트리버";
        this.type = "Large";
        this.strength += 1;
        this.attractive += 2;
        this.intelligence = -1;
    }
}

class DogFactory {
    static Scanner sc = new Scanner(System.in);

    static Dog Maker() {
        System.out.print("당신의 개의 이름을 입력하세요: ");
        String name = sc.next();
        while (true) {
            System.out.println("원하는 종을 입력하세요: ");
            String breed = sc.next();
            switch (breed) {
                case "시베리안허스키":
                    return new SiberianHusky(name);
                case "사모예드":
                    return new Samoyed(name);
                case "골든리트리버":
                    return new GoldenRetriever(name);
                case "말티즈":
                    return new Maltese(name);
                case "포메라니안":
                    return new Pomeranian(name);
                case "요크셔테리어":
                    return new YorkshireTerrier(name);
                case "핏불":
                    return new PitBull(name);
                case "보더콜리":
                    return new BorderCollie(name);
                case "진돗개":
                    return new JinDo(name);
                default:
                    System.out.println("해당 종이 존재하지 않습니다");
                    break;
            }

        }
    }
    Dog EnemyDogCreator(Dog userDog){
        String [] name1array ={ "강한", "눈치보는", "겁많은", "귀여운", "똑똑한", "배고픈", "잠꾸러기", "용감한", "졸린", "장난꾸러기" };
        String [] name2array ={ " 바둑이", " 초코", " 까미", " 콩이", " 몽실이", " 해피", " 보리", " 루비", " 달콩", " 멍순이" };
        String[] dogBreeds = {"시베리안허스키", "사모예드", "골든리트리버", "말티즈", "포메라니안", "요크셔테리어", "핏불", "보더콜리", "진돗개"};
        Random random = new Random();
        Dog dog = new Dog();
        dog.name=name1array[random.nextInt(name1array.length)]+name2array[random.nextInt(name2array.length)];
        dog.breed = dogBreeds[random.nextInt(dogBreeds.length)];
        int health = Math.max(1, userDog.maxHealth+ random.nextInt(15)-10);
        dog.health = health;
        dog.maxHealth = health;
        dog.speed = Math.max(1, userDog.speed + random.nextInt(15)-10);
        dog.strength = Math.max(1, userDog.strength + random.nextInt(15)-8);
        dog.attractive = Math.max(1, userDog.attractive + random.nextInt(15)-10);
        dog.intelligence = Math.max(1, userDog.intelligence + random.nextInt(15)-10);
        dog.loyalty = 100;
        return dog;
    }
}
