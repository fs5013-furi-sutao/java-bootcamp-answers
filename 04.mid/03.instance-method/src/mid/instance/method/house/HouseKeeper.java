package mid.instance.method.house;

public class HouseKeeper {

    public static void main(String[] args) {
        
        House myHouse = new House(
                "山本一郎", 
                "赤", 
                "愛知県名古屋市中区伏見 3-4-5"
            );

        myHouse.closeDoor();
        myHouse.openDoor();
        myHouse.showDetails();
    }
}
