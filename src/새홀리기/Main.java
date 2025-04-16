import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static User[] Users = new User[5];
    static User user;

    static void setUser(String input) {
        for (User u : Users) {
            if (u.ID.equals(input)) {
                user = u;
            }
        }
    }

    static void logOutUser() {
        user = null;
    }

    static String logIn() {
        Scanner sc = new Scanner(System.in);
        String inputID = "";
        boolean flag = false;
        while (!flag) {
            System.out.print("ID:");
            inputID = sc.next();
            System.out.print("PW: ");
            int inputPW = sc.nextInt();

            String lastInputID = inputID;
            if (Arrays.stream(Users).anyMatch(e -> e.ID.equals(lastInputID) && e.Pw == inputPW)) {
                System.out.println("로그인 성공");
                flag = true;
            } else {
                System.out.println("로그인 실패");
            }
        }
        return inputID;
    }

    static void findInfo(String name) {
        boolean flag = false;
        for (User u : Users) {
            if (u.ID.equals(name)) {
                System.out.println(u.name + "님의 주소:" + u.address + "\n" +
                        u.name + "님의 전화번호:" + u.phone);
                flag = true;
                return;
            }
        }
        if (!flag)
            System.out.println("없슴");
    }

    static void allInfo() {
        for (User u : Users) {
            System.out.println(u.name + "님의 주소:" + u.address + "\n" +
                    u.name + "님의 전화번호:" + u.phone + "\n"
            );
        }
    }

    static void selectMenu(int select) {
        Scanner sc = new Scanner(System.in);

        switch (select) {
            case 1:
                System.out.print("찾을 ID입력: ");
                String findId = sc.next();
                findInfo(findId);
                break;
            case 2:
                allInfo();
                break;
            case 3:
                System.out.print("PW:");
                int pw = sc.nextInt();
                System.out.print("Phone:");
                int phone = sc.nextInt();
                System.out.print("Address:");
                String address = sc.next();
                user.setInfo(pw, phone, address);
                break;
            case 4:
                logOutUser();
                break;

        }
    }

    public static void main(String[] args) {
        Users[0] = new User("aa", 11, "김주언", "서울", 1234567);
        Users[1] = new User("bb", 22, "양관식", "제주", 7654321);
        Users[2] = new User("cc", 33, "양금명", "수원", 1515151);
        Users[3] = new User("dd", 44, "양은명", "울산", 1887733);
        Users[4] = new User("ee", 55, "애순이", "부산", 1551111);

        int intro = 0;
        while (true) {
            System.out.println("1.로그인" + "\n" + "2.종료");
            Scanner sc = new Scanner(System.in);
            intro = sc.nextInt();
            if (intro == 2)
                break;
            int select = 0;
            while (select != 4) {
                String inputID = "";
                inputID = logIn();
                setUser(inputID);
                do {
                    user.showMenu();
                    select = sc.nextInt();
                    selectMenu(select);
                } while (select != 4);
                break;
            }

        }
    }
}