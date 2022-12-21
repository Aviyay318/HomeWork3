import java.util.Scanner;

public class RealEstate {
    private User [] users;
    private Property [] properties;
    private City [] cities;

    private User user = new User();

    void createUser(){
        Scanner scanner = new Scanner(System.in);
        Scanner scannerText = new Scanner(System.in);
        boolean isExist=true;
        boolean isValid=false;
        boolean isBroker=true;
        int typeUser;
        String userName="";
        String userPassword="";
        String userPhoneNumber="";
        if (users!=null){
            do {
                System.out.println("Please enter your name");
                userName = scanner.nextLine();
                for (int i = 0; i < users.length; i++) {
                    if (users[i].getUserName().equals(userName)) {
                        isExist = false;
                        break;
                    }
                }
            } while (isExist == false);
        }
        else {
            System.out.println("Please enter your name");
            userName = scanner.nextLine();
        }
        while (isValid==false){
            System.out.println("Please enter your password");
            userPassword = scanner.nextLine();
            isValid =user.passwordValidation(userPassword);
        }
        isValid=false;
        while (isValid==false) {
            System.out.println("Please enter your phone number");
            userPhoneNumber = scannerText.nextLine();
            isValid = user.phoneNumberValidation(userPhoneNumber);
        }
        System.out.println("what user are you? (choose: 1 for regular / 2 for broker)");
        typeUser=scanner.nextInt();
        if(typeUser==1){
            isBroker=false;
        }
        User user=new User(userName,userPassword,userPhoneNumber,isBroker);
        users=insertUser(users,user);

        for(int i=0;i<users.length;i++){
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
        User Login(){
            Scanner scanner=new Scanner(System.in);
            if (users!=null) {
                System.out.println("entre your username");
                String username = scanner.nextLine();
                System.out.println("enter your password");
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
            for (int i = 0; i < properties.length; i++) {
                if (this.properties[i].getUserName() == user.getUserName()) {
                    counter++;
                    if (user.getIsMediator() == true && counter == 5) {
                        canPost = false;
                        System.out.println("you have reached your quota");
                    } else if (user.getIsMediator() == false && counter == 2) {
                        canPost = false;
                        System.out.println("you have reached your quota");
                    }
                }
                String city;
                if (canPost == true) {
                    for (i = 0; i < cities.length; i++) {
                        System.out.println(this.cities[i].getCityName());
                    }
                    System.out.println("enter city name");
                    city = scanner.nextLine();
                    for (i = 0; i < cities.length; i++) ;
                    {
                        if (city.equals(this.cities[i].getCityName()) == false) {
                            isPublished = false;
                        }
                    }

                }

            }
            return isPublished;
        }
        void removeProperty(User user){
            System.out.println("remove");
        }
        void printAllProperties(){
        if (properties!=null) {
            for (int i=0;i<properties.length;i++){
                System.out.println(properties[i]);
            }
        }
        }
        void printProperties(User user){
            System.out.println("only by user");
        }
        Property [] search(){
        Property [] newP = new Property[]{};
        return newP;
        }

        }