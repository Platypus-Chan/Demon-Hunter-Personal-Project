import java.util.Scanner;
import java.lang.Math;

public class NewGame {
    Scanner scan = new Scanner(System.in);

    private NewGame game;
    private String leader;
    private int choice;
    private String[][] map;
    public int bounties = 0;


    public NewGame() {
        System.out.print("Welcome to [NAME OF GAME]! Here, you'll be in charge of a company of demon hunters scouring the Chinese countryside for threats! Let's start off with a leader!");

        for (int i = 1; i <= 3; i++) {
            System.out.println ("Company Leader: ");
            nameGenerator();
            System.out.println (" Ability: ");
            // implement the ClassAbilities constructer.
            System.out.print("\n");
        }

        choice = scan.nextInt();
        if (choice != 1 || choice != 2 || choice != 3) {
            System.out.print ("Oh no! Please pick a number between 1 - 3!");
            choice = scan.nextInt();
        }

        map = new String[10][10];
        for (int i = 3; i <=5; i++) {
            map[i][4] = "+";
            if (i == 4) {
                map[i][3] = "+";
                map[i][5] = "+";
            }
        }
        map[4][2] = "웃";
        map[4][6] = "웃";
    }

        System.out.println ("Welcome to Guangzhou Province, Hunter! The Cross of \"+'s\" is your headquarters.\nIn order to sustain your prescence in the province, you need to manage your supplies, your mercernaries, and the number of demons within the area!\nIf any of these stats reach zero, save for demons which is the oppostie, you will lose control over your company, resulting in a lsot game! ")

    }
    
    private String name() {
        
    } String nameGenerator() {
        int num1 = (int) (Math.random() * 10);
        int num2 = (int) (Math.random() * 10);
        String[] names = new String[]{"Tan", "Wang", "Zhao", "Shao", "Zhang", "Jun", "Ji", "Zhuge", "Dube", "Xiao"};
        String[] surnames = new String[]{"Tze", "Xingxing", "Xiaohua", "Kulai", "Jinta", "Meili", "Yumao", "Maomi", "Mao", "Avinash"};
        
        //String leader1 = names[(int) (((Math.random()) * 10) * 2 - 2)];

        leader = names[num1] + " " + surnames[num2];
        return leader;

        
    }
