import java.util.Random;
import java.util.Scanner;

public class DogWorkPlace {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    Owner owner;
    public void chooseWorkplace(){
        System.out.println("""
                알바를 시작합니다. 알바 장소를 고르세요
                1.애견카페
                2.막노동
                3.개썰매 알바
                4.취소
                """);
        int select = sc.nextInt();
        switch (select){
            case 1:
                DogCafe();
                break;
            case 2:
                HardWork();
                break;
            case 3:
                SnowSleigh();
                break;
            default:
                System.out.println("일정을 취소했습니다");
        }
    }
    public void DogCafe(){
        System.out.println("애견 카페 알바를 시작했습니다");
        owner.dog.increaseLoyalty(Math.max(1,(random.nextInt(8)-5)));
        int getMoney=(random.nextInt(10)+1)*100;
        System.out.println("알바비 획득! :"+getMoney);
        owner.money+=getMoney;
        owner.dog.attractive+=random.nextInt(5)+1;
        System.out.println("귀여움이 상승했습니다");
    }
    public void HardWork(){
        System.out.println("막노동을 시작합니다. 소대신 쟁기를 끌고있습니다");
        owner.dog.increaseLoyalty(Math.max(1,(random.nextInt(8)-5)));
        int getMoney=(random.nextInt(10)+1)*100;
        System.out.println("알바비 획득! :"+getMoney);
        owner.money+=getMoney;
        owner.dog.strength+=random.nextInt(5)+1;
        System.out.println("힘이 상승했습니다");
    }
    public void SnowSleigh(){
        System.out.println("개썰매 알바를 시작합니다.");
        owner.dog.increaseLoyalty(Math.max(1,(random.nextInt(8)-5)));
        if(owner.dog.breed.equals("시베리안허스키")){
            System.out.println(owner.dog.name+"(이)가 즐거워합니다 ");
            owner.dog.increaseLoyalty(Math.max(1,(random.nextInt(8))));
            owner.dog.speed+=random.nextInt(5)+5;
            System.out.println("허스키라 적성에 맞나봅니다");
        }else {
            int getMoney = (random.nextInt(10) + 1) * 100;
            System.out.println("알바비 획득! :" + getMoney);
            owner.money += getMoney;
            owner.dog.speed += random.nextInt(5) + 1;
        }
    }
    void setOwner(Owner owner){
        this.owner = owner;
    }
}
