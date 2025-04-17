import java.util.Scanner;

public class DogMaker {
    static Owner currentUser;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("유저로그인 :");
        String name = sc.next();
        Owner user = new Owner(name);
        setCurrentUser(user);
        System.out.println("로그인 완료");
        Dog newDog = DogFactory.Maker();
        currentUser.setDog(newDog);
        currentUser.showDogInfo();

    }
    static void setCurrentUser(Owner user){
        currentUser = user;
    }
    static void logOutUser(){
        currentUser = null;
    }




















}