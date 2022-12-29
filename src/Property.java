public class Property {
    private City city;
    private String street;
    private int roomNumbers;
    private int price;
    private String [] types = new String[]{"apartment" ,"build"};
    private int type; //!!!!!!!!
    private String isForRent; //!!!!!!!!!!!
    private int houseNumber;
    private int floorNumber;
    private User userName;

    public static final int GROUND_FLOOR = 1;
    public static final int BUILDING = 2;
    Property (City city,String street,int propertyType,int floorLevel,int roomAmount,int propertySerialNumber,String rentOrSell,int price){
      this.city =city;
      this.street = street;
      this.type =propertyType;
      this.floorNumber = floorLevel;
      this.roomNumbers  = roomAmount;
      this.houseNumber = propertySerialNumber;
      this.isForRent = rentOrSell;
      this.price  = price;
    }
    Property(){}
    public String toString() {
        String userContent;
        userContent= "";
        return userContent;
    }
    public String getUserName() {
        return userName.getUserName();
    }
    public String getIsForRent() {
        return isForRent;
    }
    public String [] getTypes() {
        return this.types;
    }
    public int getRoomNumbers() {
        return roomNumbers;
    }
    public int getPrice() {
        return price;
    }
    public int getType() {
        return type;
    }
}

