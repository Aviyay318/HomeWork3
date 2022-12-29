import java.awt.*;

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
        if (passwordValidation(password)){
            this.password = password;
        }else {
            this.password = null;
        }


    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumberValidation(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }else {
            this.phoneNumber = null;
        }

    }

    public boolean getIsMediator() {
        return isMediator;
    }

    public void setMediator(boolean mediator) {
        isMediator = mediator;
    }

    public User(String userName, String password, String phoneNumber, boolean isMediator){
        this.userName=userName;
        if (passwordValidation(password)){
            this.password=password;
        }else {
            this.password = null;
        }
        if (phoneNumberValidation(phoneNumber)){
            this.phoneNumber=phoneNumber;
        }else {
            this.phoneNumber = null;
        }

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
    boolean passwordValidation(String password){
        boolean isValid=true;
        String digits="0123456789";
        String necessaryChar ="$%_";
        if (password.length()<5){
            isValid=false;
        }
        if (isValid==true){
            isValid=false;
            for (int i=0;i<password.length();i++){
                String currentChar =password.charAt(i)+"";
                if (digits.contains(currentChar)==true){
                    isValid=true;
                    break;
                }

            }
            if (isValid==true){
                isValid=false;
                for (int i=0;i<password.length();i++){
                    String currentChar =password.charAt(i)+"";
                    if (necessaryChar.contains(currentChar)==true){
                        isValid=true;
                        break;
                    }

                }
            }}
        return isValid;
    }
    boolean phoneNumberValidation(String phoneNumber) {
        boolean isValid=true;
        String digits="0123456789";
        if (phoneNumber.length()!=10){
            isValid = false;
        }
        else {
            String help = phoneNumber.substring(0,2);
            if (help.equals("05")){
                for (int i=2;i<phoneNumber.length();i++){
                    String helper=phoneNumber.charAt(i) +"";
                    if(digits.contains(helper)==false){
                        isValid=false;
                        break;
                    }
                }
            }

        }
        return isValid;
    }


}
