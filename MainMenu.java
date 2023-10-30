import java.util.Scanner;

public class MainMenu {
    Scanner scan = new Scanner(System.in);

    private String reply;
    
    public MainMenu() {
        System.out.println("[NAME OF GAME HERE]");
        System.out.println ("New Game\tLoad Game\tSettings\tQuit");
        reply = scan.nextLine();

        if (reply.equals("New Game")){
            // implement a NewGame class
        }

        else if (reply.equals("Load Game")){
            // implement a LoadGame class
        }

        else if (reply.equals("Settings")){
            //implement a settings class
        }
        
        else if (reply.equals("Quit")){
            System.out.println("See you next time!"); 
        }
    }
    
    public class Settings {
        public Settings() {
            
        }
    }
}
