import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RealEstate realEstate = new RealEstate();
        Constant constant = new Constant();
        int userChoice=0;
        Scanner scanner = new Scanner(System.in);
        while (userChoice!=constant.NUMBER_THREE) {
        do {
            System.out.println("Choose your desired option: between 1-3 ");
            System.out.println("1: Create a new account"+"\n"+ "2: To login into an existing"
                    +"\n"+ "3: Exit the program");
            userChoice = scanner.nextInt(); //to chang to not only int ...!!!
        }while (userChoice>Constant.NUMBER_THREE||userChoice<constant.NUMBER_ONE);

            if (userChoice == constant.NUMBER_ONE) {
                realEstate.createUser();
            }
            if (userChoice == constant.NUMBER_TWO) {
                User myUser = realEstate.Login();
                if (myUser!=null){
                    System.out.println("\"Choose your desired option: between 1-6 \"");
                    System.out.println("1: Pablish a new property"+"\n"+ "2: To remove a proprty"
                            +"\n"+ "3: to show all property" + "\n" + "4: to show only user property" +
                            "\n"+ "5:search property"+"\n"+"6: log out");
                    int secondUserChoice = scanner.nextInt();
                    while (userChoice!=constant.NUMBER_THREE) {
                        switch (secondUserChoice) {
                            case Constant.POST_NEW_PROPERTY-> realEstate.postNewProperty(myUser);
                            case Constant.REMOVE_PROPERTY_POST -> realEstate.removeProperty(myUser);
                            case Constant.VIEW_ALL_THE_PROPERTIES -> realEstate.printAllProperties();
                            case Constant.VIEW_ALL_THE_USERS_PROPERTIES -> realEstate.printProperties(myUser);
                            case Constant.SEARCH_PROPERTIES_WITH_FILTER -> realEstate.search();
                            case Constant.LOG_OUT_AND_RETURN_TO_THE_MAIN_MENU -> {
                                do {
                                    System.out.println("Choose your desired option: between 1-3 ");
                                    System.out.println("1: Create a new account"+"\n"+ "2: To login into an existing"
                                            +"\n"+ "3: Exit the program");
                                    userChoice = scanner.nextInt(); //to chang to not only int ...!!!
                                }while (userChoice>3||userChoice<1);}

                        }
                        if (secondUserChoice!=constant.NUMBER_SIX){
                        System.out.println("\"Choose your desired option: between 1-6 \"");
                        System.out.println("1: Pablish a new property"+"\n"+ "2: To remove a proprty"
                                +"\n"+ "3: to show all property" + "\n" + "4: to show only user property" +
                                "\n"+ "5:search property"+"\n"+"6: log out");
                        secondUserChoice = scanner.nextInt();
                    }}
                }
                else {
                    System.out.println("not exist...");
                }
            }

        }
    }
}