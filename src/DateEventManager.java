import java.util.Scanner;

public class DateEventManager {
    int week = 1;
    int month = 1;
    int year = 1;
    DogTrainManager TM = new DogTrainManager();
    Owner currentUser;
    Scanner sc = new Scanner(System.in);
    void setCurrentUser(Owner user){
        this.currentUser =user;
    }
    void doSchedule(){
        if(this.week==5){
            this.month++;
            this.week=1;
        }
        if(month ==13) {
            this.currentUser.age++;
            this.currentUser.dog.age++;
            this.year++;
            this.month = 1;
        }
            if(month%3==0 && month!=0){
            showDate();
            DogChampionship DC = new DogChampionship();
            DC.setOwner(this.currentUser);
            DC.setDM(this);
            System.out.println("""
                    대회 시즌이 되었습니다 출전 종목을 선택하세요
                    1. ⚔⚔DFC⚔⚔
                    2. 🏇DogRacer🏇
                    3. 🤸‍♀️‍️DogShow🤸‍
                    4. 이번시즌 포기
                    """);
            int select = sc.nextInt();
            switch (select){
                case 1:
                    DC.FighterChampionship(currentUser.dog,true);
                    DC.RacerChampionShip(currentUser.dog, false);
                    DC.DogShowChampionShip(currentUser.dog, false);
                    break;
                case 2:
                    DC.FighterChampionship(currentUser.dog,false);
                    DC.RacerChampionShip(currentUser.dog, true);
                    DC.DogShowChampionShip(currentUser.dog, false);
                    break;
                case 3:
                    DC.FighterChampionship(currentUser.dog, false);
                    DC.RacerChampionShip(currentUser.dog, false);
                    DC.DogShowChampionShip(currentUser.dog, true);
                    break;
                default:
                    System.out.println("이번 시즌은 포기했습니다");
                    DC.FighterChampionship(currentUser.dog, false);
                    DC.RacerChampionShip(currentUser.dog, false);
                    DC.DogShowChampionShip(currentUser.dog, false);
            }
            System.out.println("대회 기간이 끝났습니다");
        }


        do {
            showDate();
            System.out.println(this.week + "주차 훈련을 선택하세요");
            TM.trainDog(this.currentUser.dog);
            this.week++;
        } while (this.week != 5);
        TM.spendTimeWithDog(this.currentUser);
        System.out.println(this.month+"월의 훈련일정이 끝났습니다");
    }

    void showDate(){
        System.out.println(this.year+"년차/"+this.month+"월 /"+this.week+"주차");
    }
}
