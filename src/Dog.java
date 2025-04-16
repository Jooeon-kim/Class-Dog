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
    int speed = 1;
    int strength = 1;
    int attractive = 1;
    int intelligence = 1;
    int loyalty = 50;
    //속성값+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Random random = new Random();
    Scanner sc = new Scanner(System.in);

    public void info() {
        System.out.println("이름:" + this.name + "종류:" + this.breed);
    }
    //동작 함수 ****************************************************************************
    void bark() {
        System.out.println("개소리");
    }
    public int attack() {
        return random.nextInt(this.strength);
    }
    public void hit(int damage) {
        this.health -= (damage - random.nextInt(this.strength));
        alarmHealth();
    }
    public void trySkills() {
        if (this.intelligence > 5 && this.loyalty > 70)
            sitDown();
        if (this.intelligence > 15 && this.loyalty > 70) {
            giveHand();
            waitMoment();
        }
        if (this.intelligence > 25 && this.loyalty > 70) {
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
        }
        alarmLoyalty();
    }
    public void increaseHealth(int heal) {
        this.health += heal;
        alarmHealth();
    }
    public void setAge(){
        this.age+=1;
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
    Samoyed(String name,int age){

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

