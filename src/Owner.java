import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Owner implements DogObserver,showInfo{
    Scanner sc = new Scanner(System.in);
    String name;
    int age;
    Dog dog;
    ArrayList<Dog> supportDogs = new ArrayList<>();
    int championCount;
    ArrayList <String> championCup = new ArrayList<>();
    ArrayList <String> killedCats = new ArrayList<>();
    int money = 1000;
    Random random = new Random();
    Owner(String name){
        this.name = name;
        this.age = 20;
    }
    public void setDog(Dog dog){
        this.dog = dog;
        dog.addObserver(this);
    }
    public void spendMoney(int money){
        if(this.money<money){
            System.out.println("보유금액이 부족합니다");
        }else{
            System.out.println(money+"사용!");
        this.money-=money;
        }
    }
    public void getMoney(int money){
        this.money+=money;
        System.out.println(money+" 획득!");
    }
    public void info(){
        System.out.println("이름: "+this.name+" 나이: "+this.age+" 트로피 갯수: "+this.championCount+"\n"+
                "보유 돈: "+this.money);
    }
    public void championCupInfo(){
        System.out.println("🏆우승 목록 정보🏆");
        for(String c : championCup){
            System.out.println(c);
        }
    }
    public void walkWithDog(){
        System.out.println(this.dog.name+"(와)과 산책을 합니다");
        int giveJoy = random.nextInt(10);
        this.dog.increaseLoyalty(giveJoy);
    }
    public void visitPetHairShop(){
        System.out.println("펫 미용실을 방문했습니다");
        this.dog.loyalty+=10;
        this.dog.attractive+=5;
        spendMoney(200);
        System.out.println(" 남은돈: "+this.money);
    }
    public void getRest(){
        this.dog.recover();
        System.out.println(dog.name+"(이)가 휴식을 취했습니다.");
    }
    public void showHuntedList(){
        System.out.println("잡은 고양이 리스트");
        for(String a : killedCats){
            System.out.println(a);
        }
    }
    public void lostDog(){
        this.dog = null;
    }
    public void onLoyaltyChanged(Dog dog,int newLoyalty){
        System.out.println("!알림! "+dog.name+"충성도 변경 :"+newLoyalty);
        if(newLoyalty<=20){
            System.out.println("경고!"+dog.name+"의 충성도 낮음!");
        }
    }
    public void onHealthChanged(Dog dog,int newHealth){
        System.out.println(dog.name+"의 체력 :"+newHealth);
        if(newHealth<5){
            System.out.println("경고!"+dog.name+"의 체력 낮음!");
        }
    }
}
