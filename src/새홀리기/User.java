import java.util.Scanner;


public class User {
    Scanner sc = new Scanner(System.in);
    String ID;
    int Pw;
    String name;
    String address;
    int phone;

    public User(String Id, int Pw,String name, String address, int phone) {
        this.ID = Id;
        this.Pw = Pw;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public void info(){
        System.out.println(this.name+" "+this.ID);
    }

    public void setInfo( int Pw,  int phone, String address) {
        this.Pw = Pw;
        this.address = address;
        this.phone = phone;
        System.out.println(this.name+"님의 정보가 변경되었습니다");
    }
    public void showMenu(){
        System.out.println("""
                            ++++++++++++++++
                            1.주소록 관리
                            2.전체 주소록 검색
                            3.내정보변경
                            4.로그아웃
                            ++++++++++++++++
                            """);
    }

}


