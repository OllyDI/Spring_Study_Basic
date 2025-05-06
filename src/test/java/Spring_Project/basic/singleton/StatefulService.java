package Spring_Project.basic.singleton;

public class StatefulService {

//    private int price;  // 상태 유지 필드


    // 싱글톤은 이런식으로 설계하면 안됨
//    public void order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 여기가 문제
//    }

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
