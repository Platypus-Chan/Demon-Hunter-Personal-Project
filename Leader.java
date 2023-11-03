public class Leader {

    private String name;
    private int hitPoints;
    private int currHP;

    public Leader() {
        name = nameGenerator();
        hitPoints = (int)(Math.random() * 90 + 10);
        currHP = hitPoints;

    }
    
    private String nameGenerator() {
        int num1 = (int) (Math.random() * 10);
        int num2 = (int) (Math.random() * 10);
        String[] names = new String[]{"Tan", "Wang", "Zhao", "Shao", "Zhang", "Jun", "Ji", "Zhuge", "Dube", "Xiao"};
        String[] surnames = new String[]{"Tze", "Xingxing", "Xiaohua", "Kulai", "Jinta", "Meili", "Yumao", "Maomi", "Mao", "Avinash"};
        
        //String leader1 = names[(int) (((Math.random()) * 10) * 2 - 2)];

        return names[num1] + " " + surnames[num2];
       
    }

    public String toString() {
        return ("\tName: " + name + "\tHitpoints: " + hitPoints);
    }

    public String name() {
        return name;
    }

    public int health() {
        return currHP;
    }

    public void dmg(int points) {
        currHP -= points;
    }

    public void heal(int points) {
        if (currHP + points <= hitPoints) {
            currHP += points;
        }
        else {
            currHP = hitPoints; 
        }
    }
}
 