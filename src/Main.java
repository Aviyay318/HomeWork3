import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RealEstate realEstate = new RealEstate();
        int userChoice=0;
        Scanner scanner = new Scanner(System.in);
        while (userChoice!=Constant.FINISH_THE_PROGRAM) {
        do {
            System.out.println("Choose your desired option: between 1-3 ");
            System.out.println(Constant.MAIN_MENU);
            userChoice = scanner.nextInt(); //to chang to not only int ...!!!
        }while (userChoice>Constant.MAXIMUM_RANG||userChoice<Constant.MINIMUM_RANG);

            switch (userChoice) {
                case Constant.CREATE_USER-> realEstate.createUser();
                case Constant.LOG_IN_INTO_EXISTED_ACCOUNT-> {
                    User myUser = realEstate.Login();
                if (myUser!=null){
                    System.out.println("\"Choose your desired option: between 1-6 \"");
                    System.out.println(Constant.INTERNAL_MENU);
                    int secondUserChoice = scanner.nextInt();
                    while (userChoice!= Constant.VIEW_ALL_THE_PROPERTIES) {
                        switch (secondUserChoice) {
                            case Constant.POST_NEW_PROPERTY-> realEstate.postNewProperty(myUser);
                            case Constant.REMOVE_PROPERTY_POST -> realEstate.removeProperty(myUser);
                            case Constant.VIEW_ALL_THE_PROPERTIES -> realEstate.printAllProperties();
                            case Constant.VIEW_ALL_THE_USERS_PROPERTIES -> realEstate.printProperties(myUser);
                            case Constant.SEARCH_PROPERTIES_WITH_FILTER -> realEstate.search();
                            case Constant.LOG_OUT_AND_RETURN_TO_THE_MAIN_MENU -> {
                                do {
                                    System.out.println("Choose your desired option: between 1-3 ");
                                    System.out.println(Constant.MAIN_MENU);
                                    userChoice = scanner.nextInt(); //to chang to not only int ...!!!
                                }while (userChoice>3||userChoice<1);}

                        }
                        if (secondUserChoice!=Constant.LOG_OUT_AND_RETURN_TO_THE_MAIN_MENU){
                        System.out.println("\"Choose your desired option: between 1-6 \"");
                        System.out.println(Constant.INTERNAL_MENU);
                        secondUserChoice = scanner.nextInt();
                    }}
                }
                else {
                    System.out.println("not exist...");
                }}
            }

        }
    }
}