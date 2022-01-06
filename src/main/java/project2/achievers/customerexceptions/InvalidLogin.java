package project2.achievers.customerexceptions;

public class InvalidLogin extends RuntimeException{
    public InvalidLogin(String message){
        super(message);
    }
}



