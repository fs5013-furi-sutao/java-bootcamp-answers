package jp.freestyles.mid.instance.method.house;

public class House {
    
    private String ownerName;
    private String color;
    private String address;
    private boolean isDoorOpen;
    private boolean isDoorOpenNow;
    private boolean isDoorCloseNow;

    public House(
            String name, 
            String color, 
            String address) {
            
        this.ownerName = name;
        this.color = color;
        this.address = address;
        this.isDoorOpen = false;
        clearDoorNowStatus();
    }

    public void openDoor() {
        showAction("%s さん家のドアを開けます %n");
        isDoorOpenNow = true;
        logCanOpen();
        isDoorOpen = true;
        clearDoorNowStatus();
    }

    public void closeDoor() {
        showAction("%s さん家のドアを閉めます %n");
        isDoorCloseNow = true;
        logCanOpen();
        isDoorOpen = false;
        clearDoorNowStatus();
    }

    private void logCanOpen() {
        if (this.isDoorOpenNow && this.isDoorOpen) {
            System.out.println(" => [INFO] 既にドアは開いてます");
        }
        if (this.isDoorCloseNow && !this.isDoorOpen) {
            System.out.println(" => [INFO] 既にドアは閉まってます");
        }
        clearDoorNowStatus();
    }

    private void clearDoorNowStatus() {
        isDoorOpenNow = false;
        isDoorCloseNow = false;
    }

    private void showAction(String message) {
        System.out.printf(message, this.ownerName);
    }

    public void showDetails() {
        System.out.printf(
            "%s さん家 %n" + 
            " => 色: %s %n" + 
            " => 住所: %s %n" + 
            " => ドア: %S %n",
            this.ownerName, 
            this.color, 
            this.address, 
            getDoorStatus()
        );
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public String getAddress() {
        return address;
    }

    public String getDoorStatus() {
        if (this.isDoorOpen) return "開いてます";
        return "閉まってます";
    }
}
