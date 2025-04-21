import java.util.Scanner;

public class DogMakerManager {
    static Owner currentUser;
    static Scanner sc = new Scanner(System.in);

    void run() {

        System.out.print("유저이름 :");
        String name = sc.next();

        Owner user = new Owner(name);
        setCurrentUser(user);
        System.out.println("로그인 완료");

        Dog newDog = DogFactory.Maker();
        currentUser.setDog(newDog);
        currentUser.dog.setOwner(currentUser);
        newDog.addObserver(currentUser);
        DateEventManager DM = new DateEventManager();
        DM.setCurrentUser(currentUser);

        do {
            System.out.println("""
                    ++++++++++++
                    1.🙍‍♀️🙍‍♂️유저정보보기
                    2.🐾개 정보보기
                    3.📆이번달 스케줄 실행
                    4.🐕개 재롱시키기
                    5.🏆보유 트로피 정보 보기
                    6.🙀사냥한 고양이 리스트 보기
                    ++++++++++++
                    """);
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    currentUser.info();
                    break;
                case 2:
                    currentUser.dog.info();
                    break;
                case 3:
                    DM.doSchedule();
                    break;
                case 4:
                    currentUser.dog.trySkills();
                    break;
                case 5:
                    currentUser.championCupInfo();
                    break;
                case 6:
                    currentUser.showHuntedList();
                    break;
                default:
                    System.out.println("다시 입력하세요");
            }
        } while (true);
    }

    static void setCurrentUser(Owner user) {
        currentUser = user;
    }

    static void logOutUser() {
        currentUser = null;
    }
}