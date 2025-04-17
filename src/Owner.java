import java.util.Random;
import java.util.Scanner;

public class Owner implements DogObserver,showInfo{
    String name;
    int age;
    Dog [] dogs = new Dog [1];
    int championCount;
    Random random = new Random();
    Owner(String name){
        this.name = name;
        this.age = 20;
    }
    public void setDog(Dog dog){
        this.dogs [0] = dog;
    }
    public void showDogInfo(){
        for(Dog d : dogs){
           d.info();
        }
    }
    public void info(){
        System.out.println("이름: "+this.name+" 나이: "+this.age+" 트로피 갯수: "+this.championCount);
    }
    public void walkWithDog(){
        int giveJoy = random.nextInt(10);
    }
    public void onLoyaltyChanged(Dog dog,int newLoyalty){
        System.out.println("!알림! "+dog.name+"충성도 변경 :"+newLoyalty);
        if(newLoyalty<=20){
            System.out.println("경고!"+dog.name+"의 충성도 낮음!");
        }
    }
    public void onHealthChanged(Dog dog,int newHealth){
        System.out.println(dog.name+"의 체력 :"+newHealth);
        if(newHealth<2){
            System.out.println("경고!"+dog.name+"의 체력 낮음!");
        }
    }
}
