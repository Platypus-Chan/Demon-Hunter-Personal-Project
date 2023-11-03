import java.util.Scanner;
public class NewGame{
    Scanner scan = new Scanner(System.in);
    private final int width = 10;
    private final int height = 10;

    private Leader leader;
    private String[][] map;
    private int leaderX = 2;
    private int leaderY = 4;
    private String copy = null;

    public int bounties = 0;
    public int supplies = 100;
    public int mercernaries = 100;
    public int demons = 0;



    public NewGame() {
        System.out.println("Welcome to [NAME OF GAME]! Here, you'll be in charge of a company of demon hunters scouring the Chinese countryside for threats! Let's start off with a leader!");
        Leader[] choices = new Leader[3]; 
        for (int i = 0; i < 3; i++) {
            choices[i] = new Leader();
            // implement the ClassAbilities constructer.
            System.out.println("Leader " + i + ": " );
            System.out.println(choices[i]);
        }   

        int choice = scan.nextInt();
        while (choice > 2 || choice < 0) {
            System.out.print ("Oh no! You chose " + choice + ". Please pick a number between 0-2!");
            choice = scan.nextInt();
        }

        leader = choices[choice];
        System.out.println("Welcome to the business " + leader.name() + "!");

        map = new String[height][width];
        for (int i = 3; i <=5; i++) {
            map[i][4] = "+";
            if (i == 4) {
                map[i][3] = "+";
                map[i][5] = "+";
            }
        }

        map[leaderY][leaderX] = "O";

        for (int i = 0; i < 7; i++) {
            int x = (int)(Math.random() * width);
            int y = (int)(Math.random() * height);
            if ( map[y][x] == null) {
                map[y][x] = "*";
            }
        }


        printMap();

        System.out.println ("Welcome to Guangzhou Province, Hunter! The Cross of \"+'s\" is your headquarters.\nIn order to sustain your prescence in the province, you need to manage your supplies, your mercernaries, and the number of demons within the area!\nIf any of these stats reach zero, save for demons which is the oppostie, you will lose control over your company, resulting in a lost game! ");

    }

    public void actionMenu() {
        System.out.println("You can tell your leader to move: 0. up, 1. down, 2. left, 3. right!");
        int choice = scan.nextInt();
        while (choice > 3 || choice < 0) {
            System.out.print ("Oh no! You chose " + choice + ". Please pick a number between 0-3!");
            choice = scan.nextInt();
        }

        map[leaderY][leaderX] = copy;

        switch (choice) {
            case 0: 
                if (leaderY > 0) {
                    leaderY--;
                }
                else {
                    System.out.println ("You can't move up! Choose another action!");
                }
                break;
            case 1: 
                if (leaderY < height - 1) {
                    leaderY++;
                }
                else {
                    System.out.println ("You can't move down! Choose another action!");
                }
                break;
            case 2: 
                if (leaderX > 0) {
                    leaderX--;
                }
                else {
                    System.out.println ("You can't move left! Choose another action!");
                }
                break;
            case 3: 
                if (leaderX < width - 1) {
                    leaderX++;
                }
                else {
                    System.out.println ("You can't move right! Choose another action!");
                }
                break;
        }

        copy = map[leaderY][leaderX];
        map[leaderY][leaderX] = "O";

        if (copy != null && copy.equals("*")) {
            treasures();
            copy = null;

            int x = (int)(Math.random() * width);
            int y = (int)(Math.random() * height);
            if ( map[y][x] == null) {
                map[y][x] = "*";
            }
        }

        printMap();
        printStats();
        
    }

    public boolean endCons() {
        boolean end = false;
        if (supplies == 0) {
            System.out.print("Oh No! You ran out of supplies! Game Over!");
            end = true;
        }
        if (mercernaries == 0) {
            System.out.print("You ran out of mercenaries! Game Over!");
            end = true;
        }
        if (demons == 100) {
            System.out.print("You let the demons overrun you! Game Over!");
            end = true;
        }
        if (leader.health() <= 0) {
            System.out.print("Oh No! Looks like the demons got the best of you, but you fought well! Game Over!");
            end = true;
        }
        return end;
    }
    
    private void printStats() {
        System.out.println("Health: " + (leader.health() < 0?0:leader.health()) + "\tSupplies: " + supplies + "\tMercernaries: " + mercernaries + "\tDemon Activity: " + demons);
    }

    private void printMap() {
        for (int k = 0; k < width+2; k++) {
            System.out.print("-");
        }
        System.out.println("");
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int k = 0; k < width; k++) {
                if (map[i][k] != null) {
                    System.out.print(map[i][k]);
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        for (int k = 0; k < width+2; k++) {
            System.out.print("-");
        }
        System.out.println("");
    } 

    public void treasures() {
        int poss = (int)(Math.random() * 8);
        switch (poss) {
            case 0:
                System.out.println("You've found extra rations! +25 to your supplies!");
                supplies += 25;
                break;
            case 1:
                System.out.println("You've found a whole store of dried goods! +75 to supplies!");
                supplies += 75;
                break;
            case 2:
                System.out.println("You've found a rigged stash! Take cover! -50% of your current HP!");
                leader.dmg(leader.health() / 2);
                if (leader.health() <= 10) {
                    leader.dmg(-leader.health());
                }
                break;
            case 3:
                System.out.println("You've found a cursed charm! Demons can smell those from a mile away! +15 Demon activity!");
                demons += 15;
                break;
            case 4:
                System.out.println("You've found some medicinal herbs and ointments! These will come in handy... +10 HP!");
                leader.heal(10);
                break;
            case 5:
                System.out.println("You've discovered a plague which ravishes your stores! -50 supplies!");
                supplies -= 50;
                break;
            case 6:
                System.out.println("You've discovered... is that dynamite? -100 HP!");
                leader.dmg(100000000);
                break;
            case 7:
                System.out.println("You've discovered... hey, who planned you a surprise party? And why do they look so hungry?");
                int coinFlip = (int)(Math.random() * 2);
                if (coinFlip == 0) {
                    leader.dmg(30);
                    System.out.println("Those were some rude party throwers! Next time, walk into an ambush prepared, yeah? -30 HP!");
                }
                else {
                    mercernaries -= 50;
                    System.out.println("That was a close call! Can't say the same for your agents, however... -50 mercernaries!");
                }
                break;
        }
    }

    public static void main(String[] args) {
        NewGame myGame = new NewGame();
        while (!myGame.endCons()) {
            myGame.actionMenu();
        }
    }

}