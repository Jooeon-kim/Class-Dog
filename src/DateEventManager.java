public class DateEventManager {
    int week = 1;
    int month = 1;
    int year = 1;
    DogTrainManager TM = new DogTrainManager();
    Owner currentUser;
    void setCurrentUser(Owner user){
        this.currentUser =user;
    }
    void doSchedule(){
        showDate();
        if(this.week==5){
            this.month++;
            this.week=1;
        }
        if(month ==13){
            this.currentUser.age++;
            this.currentUser.dog.age++;
            this.year++;

        }
        do {
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
