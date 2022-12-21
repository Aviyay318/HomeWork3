public class User {
    private String userName;
    private String password;
    private String phoneNumber;
    private boolean isMediator;

    public String getUserName() {
       return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getIsMediator() {
        return isMediator;
    }

    public void setMediator(boolean mediator) {
        isMediator = mediator;
    }

    public User(String userName, String password, String phoneNumber, boolean isMediator){
        this.userName=userName;
       this.password=password;
        this.phoneNumber=phoneNumber;
        this.isMediator=isMediator;
    }
    public User(){

    }

    public String toString() {
        String user;
        user="UserName= "+this.userName+" Password= "+this.password
                + " Phone number: "+this.phoneNumber+" User broker: "+this.isMediator;
        return user;
    }
    boolean passwordValidation(String userPassword){
        boolean isValid=true;
        String digits="0123456789";
        String necessaryChar ="$%_";
        if (userPassword.length()!=5){
            isValid=false;
        }
        if (isValid==true){
            isValid=false;
            for (int i=0;i<userPassword.length();i++){
                String currentChar =userPassword.charAt(i)+"";
                if (digits.contains(currentChar)==true){
                    isValid=true;
                    break;
                }

            }
            if (isValid==true){
                isValid=false;
                for (int i=0;i<userPassword.length();i++){
                    String currentChar =userPassword.charAt(i)+"";
                    if (necessaryChar.contains(currentChar)==true){
                        isValid=true;
                        break;
                    }

                }
            }}
        if (isValid==false){
            System.out.println("wrong password");
        }
        return isValid;
    }
    boolean phoneNumberValidation(String userPhoneNumber) {
        boolean isValid=true;
        String digits="0123456789";
        if (userPhoneNumber.length()!=10){
            isValid = false;
        }
        else {
            String help = userPhoneNumber.substring(0,2);
            if (help.equals("05")){
                for (int i=2;i<userPhoneNumber.length();i++){
                    String helper=userPhoneNumber.charAt(i) +"";
                    if(digits.contains(helper)==false){
                        isValid=false;
                        break;
                    }
                }
            }

        }
        if(isValid==false){
            System.out.println("Your phone number isn't valid");
        }
        return isValid;
    }


}
