package CommandP;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class Client {
    public static void main(String[] args){
        
        try{
            Registry reg = LocateRegistry.getRegistry("localhost",1099);
            LogInFacade server = (LogInFacade) reg.lookup("rmi://localhost/service");
            try (Scanner scan = new Scanner(System.in)) {
                System.out.println("Enter username : ");
                String username = scan.nextLine();
                System.out.println("Enter password : ");
                String password = scan.nextLine();
                
                String response = server.login(username, password);
                
                System.out.println("Response from server : " + response);
            }
        }catch(RemoteException | NotBoundException ex){
            System.out.println(ex.getMessage());
        }
    }
}
