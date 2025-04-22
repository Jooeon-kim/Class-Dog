import java.util.Random;
import java.util.Scanner;

public class BackStreet {
    Owner owner;
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    Cat enemy;
    void SetEnemies(){
        CatFactory factory = new CatFactory();
        this.enemy = factory.RandomCat(owner.dog);
    }
    void EnterBackStreet(){
        System.out.println("뒷골목에 들어왔습니다...");
        int roll = random.nextInt(2);
        switch (roll){
            case 0:
                FindCat();
                break;
            case 1:
                int roll2 = random.nextInt(2);
                switch (roll2){
                    case 0:
                        NothingFind();
                        break;
                    case 1:
                        Lucky();
                        break;
                }
                break;
            default:
        }
    }
    void FindCat(){
        BattleManager BM = new BattleManager();

        System.out.println("고양이와 마주쳤습니다!");
        SetEnemies();
        enemy.info();
        Cat hunted = BM.CatVsDog(owner.dog, enemy);
        owner.dog.recover();
        if(hunted!=null){
            owner.killedCats.add(hunted.name+" ("+hunted.breed+")"+"😿");
        }
    }
    void NothingFind(){
        System.out.println("뒷골목을 돌아다녔지만 아무 소득이 없었네요 ...");
    }
    void Lucky(){
        System.out.println("길가다가 돈을 발견했습니다!");
        owner.money+=(random.nextInt(5)+1)*100;
        System.out.println("Lucky");
    }
    void setOwner(Owner owner){
        this.owner = owner;
    }
}
