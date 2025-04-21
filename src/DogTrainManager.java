import java.util.Random;
import java.util.Scanner;

public class DogTrainManager {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    Owner owner;
void trainDog(Dog dog){
        System.out.println("훈련시킬 종목을 선택하세요");
        System.out.println("------------------------------------------------------");
        System.out.println("1. 🐾최대체력증가🐾");
        System.out.println("2. 🏃‍♀️스피드 증가🏃‍♂️");
        System.out.println("3. 💪힘 증가💪");
        System.out.println("4. 🏃💪‍스피드 , 힘 증가(확룰50%)🏃💪");
        System.out.println("5. 😻매력 증가😍");
        System.out.println("6. 🗿지능 증가🗿");
        System.out.println("7. 😲랜덤 증가 (50%확률로 대폭 상승 , 50%확률로 충성도 하락");
        System.out.println("------------------------------------------------------");

    int select = sc.nextInt();
    int rnNumber = 0;
    switch(select){
            case 1:
                int plusHealth = random.nextInt(10);
                dog.maxHealth+=plusHealth;
                System.out.println("최대체력증가! : "+plusHealth);
                dog.recover();
                break;
            case 2:
                int plusSpeed = random.nextInt(10);
                dog.speed+=plusSpeed;
                System.out.println("스피드 증가! : "+plusSpeed);
                break;
            case 3:
                int plusStrength = random.nextInt(10);
                dog.strength+=plusStrength;
                System.out.println("근력 증가! : "+plusStrength);
                break;
            case 4:
                rnNumber = random.nextInt(100);
                if(rnNumber<50) {
                    plusSpeed = random.nextInt(10)+5;
                    plusStrength = random.nextInt(10)+5;
                    dog.speed +=plusSpeed;
                    dog.strength += plusStrength;
                    System.out.println("근력 ,스피드 증가! : "+plusStrength+" "+plusSpeed);
                }else{
                    System.out.println("실패!");
                }
                break;
            case 5:
                int plusAttractive=random.nextInt(10);
                dog.attractive+=plusAttractive;
                System.out.println("귀여움 증가! : "+plusAttractive);
                break;
            case 6:
                int plusIntelligence=random.nextInt(10);
                dog.intelligence+=plusIntelligence;
                System.out.println("지능 증가! : "+plusIntelligence);
                break;
            case 7:
                rnNumber = random.nextInt(100);
                if(rnNumber<50){
                    dog.strength+=10;
                    dog.speed+=10;
                    dog.maxHealth+=5;
                    System.out.println("힘증가 10 스피드 증가 10 체력 증가 5");
                }else{
                    dog.decreaseLoyalty(10);
                }
                break;
        }
    }
    void spendTimeWithDog(Owner user){
        System.out.println("""
                월말이 되었습니다
                실행할 행동을 선택하세요
                1.🦮🦮개와 산책
                2.🐩개 미용실 방문
                3.💰개와 알바가기
                4.😾뒷골목 방문
                5.🤏푹 쉬기
                """);
        int select = sc.nextInt();
        switch (select){
            case 1:
                user.walkWithDog();
                break;
            case 2:
                user.visitPetHairShop();
                break;
            case 3:
                DogWorkPlace DWP = new DogWorkPlace();
                DWP.setOwner(owner);
                DWP.chooseWorkplace();
                break;
            case 4:
                BackStreet BS = new BackStreet();
                BS.setOwner(owner);
                BS.EnterBackStreet();
                break;
            case 5:
                user.getRest();
                break;
        }
    }
    void setOwner(Owner owner){
        this.owner = owner;
    }
}
