import java.util.Scanner;

public class RealEstate {
    private User [] users;
    private Property [] properties ;// to ask
    private City [] cities  = new City[10];

    public RealEstate(){
       this.cities[0] = new City("Eilat","Negev-District","HaTmarim Shachamon Nirit");
       this.cities[1] = new City("Beer-Sheva","Negev-District","Bialik Rambam Hatzvi");
       this.cities[2] = new City("Kiryat-Gat","HaDarom-District","Hashoftim Tzaal Lachish");
       this.cities[3] = new City("Ashkelon","HaDarom-District","Neve-Shalom Rabin Bialik");
       this.cities[4] = new City("Tel-Aviv","Central-District","Morozov Dizingof Avital");
       this.cities[5] = new City("Ramat-Gan","Central-District","Avigail Einstein Alonim");
       this.cities[6] = new City("Hertzelia","HaSharon-District","Marina Kaplan Beeri");
       this.cities[7] = new City("Netanya","HaSharon-District","Sokolov Herzel Remez");
       this.cities[8] = new City("Harish","Northen-District","Gefen Alon Rimon");
       this.cities[9] = new City("Haifa","Northen-District","Oren Hilel Nesher");

    }


    void createUser(){
        Scanner scanner = new Scanner(System.in);
        Scanner scannerText = new Scanner(System.in);
        boolean isExist=false;
        boolean isBroker=true;
        int typeUser;
        String userName;
        String userPassword;
        String userPhoneNumber;
        int i;
            do {
                if (isExist){
                    System.out.println("This Username is unavailable");
                }
                System.out.println("Please enter your Username");
                userName = scannerText.nextLine();
                if (users!=null){
            for (i=0;i<users.length;i++) {
                if (userName.equals(users[i].getUserName())) {
                    isExist = true;
                    break;
                }
            }
            if (i==users.length){
                isExist = false;
            }
            }
            }while (isExist);
        System.out.println("Please enter a password according to these security rules: \n" +
                "1. At least 5 characters.\n" +
                "2. At least 1 digit\n" +
                "3. At least 1 special characters from the following ($,%,_)");
        userPassword = scannerText.nextLine();
        System.out.println("Please enter your phone number");
        userPhoneNumber = scannerText.nextLine();
        do {
            System.out.println("what user are you? (choose: 1 for regular / 2 for broker)");
            typeUser=scanner.nextInt();
            if(typeUser==1){
                isBroker=false;
            }
        }while (typeUser>2||typeUser<1);
         User user = new User(userName,userPassword,userPhoneNumber,isBroker);
         while (user.getPassword()==null){
             System.out.println("Invalid password!");
             userPassword = scannerText.nextLine();
             user.setPassword(userPassword);
         }
         while (user.getPhoneNumber()==null){
             System.out.println("Invalid phone number!");
             userPhoneNumber = scannerText.nextLine();
             user.setPhoneNumber(userPhoneNumber);
         }
        users=insertUser(users,user);

        for( i=0;i<users.length;i++){
            System.out.println(users[i]);
        }

    }


    public User[] insertUser(User[] users,User user){
        User[] newUsers;
        if (users!=null) {
            newUsers = new User[users.length + Constant.NUMBER_ONE];
            for (int i = 0; i < users.length; i++) {
                newUsers[i] = users[i];
            }
        }
        else {
             newUsers = new User[Constant.NUMBER_ONE];
        }
        newUsers[newUsers.length-1]=user;
        return newUsers;
    }
       public User Login(){
            Scanner scanner=new Scanner(System.in);
            if (users!=null) {
                System.out.println("Enter your Username");
                String username = scanner.nextLine();
                System.out.println("Enter your Password");
                String password = scanner.nextLine();
                for (int i = 0; i < users.length; i++) {
                    if (users[i].getUserName().equals(username)) {
                        if (users[i].getPassword().equals(password)) {
                            return users[i];
                        }
                    }
                }
            }
            return null;
        }

        boolean postNewProperty(User user) {
                    Scanner scanner = new Scanner(System.in);
                    boolean isPublished = true;
                    int counter = 0;
                    boolean canPost = true;
                    if(properties!=null){
                        for (int i = 0; i < properties.length; i++) {
                            if (this.properties[i].getUserName() == user.getUserName()) {
                                counter++;
                                if (user.getIsMediator() == true && counter == 5) {
                                    canPost = false;
                                    System.out.println("You have reached your quota");
                                } else if (user.getIsMediator() == false && counter == 2) {
                                    canPost = false;
                                    System.out.println("You have reached your quota");
                                }
                            }
                        }}
                    String city="";
                    City myCity = new City();
                    String street="";
                    int propertyType=0;
                    int floorLevel=0;
                    int roomAmount;
                    int propertySerialNumber;
                    String rentOrSell; //!!!!! המשתנה צריך להיות boolean , אתה יכול לקלוט מהמשתמש תשובה של 1/0 ןלתרגם אותה לטרו/פולס
                    int price;
                    int i = 0;
                    boolean proceedToStreet = false;
                    boolean proceedToType = false;
                    boolean proceedToRoomAmount = true;
                    if (canPost) {
                        System.out.println("In which city do you want to advertise the property?");
                        for (i = 0; i < cities.length; i++) {
                            System.out.println(this.cities[i].getCityName());
                        }
                        System.out.println("Enter city name");
                        city = scanner.nextLine();
                        for ( i = 0; i < cities.length; i++) {
                            if (!city.equals(this.cities[i].getCityName())) {
                                proceedToStreet = true;
                                break;
                            }
                        }
                    }
                    if (!proceedToStreet) {
                        System.out.println("inValid city name");//למה אתה מאתחל את שם העיר אם היא לא נכונה?
                        myCity.setCityName(city);
                        isPublished = false;
                    } else {
                        System.out.println("In which street do you want to advertise the property?");
                            System.out.println(this.cities[i].getStreetsList());
                        }
                        System.out.println("Enter street name");
                        street = scanner.nextLine();
                        String [] arrayOfStreets  = this.cities[i].getStreetsList().split(" ") ;
                        for (i = 0; i < arrayOfStreets.length; i++) {
                            if (street.equals(arrayOfStreets[i])) {
                                proceedToType = true;
                                break;
                            }
                        }
                        if (!proceedToType) {
                            System.out.println("in valid street name");
                            isPublished = false;
                        } else {
                            Property myProperty = new Property();
                            for ( i = 0; i < myProperty.getTypes().length; i++) {
                                System.out.println(myProperty.getTypes()[i]);
                            }
                            System.out.println("Enter the type of the property: 1 for...2 for...");
                            propertyType = scanner.nextInt();
                            for (i = 0; i < myProperty.getTypes().length; i++) {
                                if (propertyType != i) {
                                    System.out.println("Invalid property type.");
                                    proceedToRoomAmount = false;
                                } else if (propertyType == 2) {
                                    System.out.println("Enter the floor level");
                                    floorLevel = scanner.nextInt();
                                }
                            }
                            if(!proceedToRoomAmount){
                                isPublished=false;
                            }
                            else{
                                System.out.println("How many rooms are there in your property?");
                                roomAmount = scanner.nextInt();
                                System.out.println("Enter the property serial number");
                                propertySerialNumber = scanner.nextInt();
                                System.out.println("Type 0 if the property is for sale\n" +
                                        "Type 1 if the property is for rent");
                                rentOrSell = scanner.nextLine();
                                System.out.println("Enter the price");
                                price = scanner.nextInt();
                                Property property = new Property(myCity, street, propertyType, floorLevel, roomAmount, propertySerialNumber,rentOrSell,price);
                                isPublished=true;
                            }
                        }
                    return isPublished;
                }
        void removeProperty(User user){
        Scanner scanner= new Scanner(System.in);
        Property[] newProperties = new Property[]{};
        int propertyNumber=0;
        int propertyToRemove;
        int size;
        if (user.getIsMediator()){
            size=5;
        }
        else {
            size = 2;
        }
        int [] arrayOfIndex = new int[size];
        if (properties!=null){
            newProperties=new Property[properties.length-1];
            for (int i=0;i< properties.length;i++){
                if(user.getUserName().equals(properties[i].getUserName())){
                    System.out.print(propertyNumber+=1);
                    System.out.println(properties[i]);
                    arrayOfIndex[propertyNumber-1]=i;

                }

            }
            System.out.println("Please choose the number of the property you want to removed");
            propertyToRemove=scanner.nextInt();
            //do while
            propertyToRemove = arrayOfIndex[propertyToRemove-1];
            int myIndex=0;
            for (int i=0;i<properties.length;i++){
                if (i==propertyToRemove){
                    continue;
                }
                else {
                    newProperties[myIndex]= properties[i];
                    myIndex++;
                }
            }
        }
        else {
            System.out.println("You have no properties on your name right now");
        }


            properties = newProperties;
            System.out.println("Your property has been removed");
        }
        void printAllProperties(){
        if (properties!=null) {
            for (int i=0;i<properties.length;i++){
                System.out.println(properties[i]);
            }
        }
        else {
            System.out.println("no property to publish");
        }
        }
        void printProperties(User user){
            if (properties!=null){
                for (int i=0;i<properties.length;i++){
                    if (user.getUserName().equals(properties[i].getUserName())){
                        System.out.println(properties[i]);
                    }
                }
            }
            else {
                System.out.println("no property to publish");
            }
        }
        Property [] search(){
        int indexOfArrayNewP = 0;
        boolean isOk = true;
        Scanner scanner = new Scanner(System.in);
        String [] arrayOfQuestion = new String[]{"for sale or for rent",
                "type of property","how many room numbers do you want","rang of prices min","max"};
        String [] arrayOfAnswer = new String[arrayOfQuestion.length];
        for (int i=0;i<arrayOfQuestion.length;i++){
            System.out.println(arrayOfQuestion[i]);
            arrayOfAnswer[i] = scanner.nextLine();
        }
        int counterOfProp=0;
        Property [] newP;
        if (properties!=null){
        for (int i=0;i<properties.length;i++) {
          if ( conditionFilter(arrayOfAnswer,i)){
              counterOfProp++;
          }}}
           newP = new Property[counterOfProp];
        if (properties!=null){
        for (int i=0;i<properties.length;i++){
            if (conditionFilter(arrayOfAnswer,i)){
               newP[indexOfArrayNewP]=properties[i];
               indexOfArrayNewP++;
            }}}
        else {
            System.out.println("0 property");
        }


        return newP;
        }
        boolean conditionFilter( String [] arrayOfAnswer,int propertyToCheck){
        boolean isOk=true;
        int j=0;
            if (Integer.parseInt(arrayOfAnswer[j])!=-999) {
                if (!this.properties[propertyToCheck].getIsForRent().equals(arrayOfAnswer[j])) {
                    isOk=false;
                }
            }//!!!!!!!!!!!!!st-boolean
            if (isOk){
                if (Integer.parseInt(arrayOfAnswer[j+1])!=-999) {
                    if (this.properties[propertyToCheck].getType() != Integer.parseInt(arrayOfAnswer[j+ 1])) { //!!!!!!!!int-string
                        isOk = false;
                    }
                }
            }
            if (isOk){
                if (Integer.parseInt(arrayOfAnswer[j+2])!=-999){
                    if (this.properties[propertyToCheck].getRoomNumbers()!=Integer.parseInt(arrayOfAnswer[j+2])){
                        isOk=false;
                    }}
            }
            if (isOk){
                if (Integer.parseInt(arrayOfAnswer[j+3])!=-999){
                    if (this.properties[propertyToCheck].getPrice()<Integer.parseInt(arrayOfAnswer[j+3])){
                        isOk=false;
                    }}
            }
            if (isOk){
                if (Integer.parseInt(arrayOfAnswer[j+4])!=-999){
                    if (this.properties[propertyToCheck].getPrice()>Integer.parseInt(arrayOfAnswer[j+3])){
                        isOk=false;
                    }
                }
            }
            return isOk;
        }
        }