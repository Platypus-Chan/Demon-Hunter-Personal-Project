public class Demon {
    
    private int hp;
    private int damage;
    private int type;
    private int x;
    private int y;
    private String symbol;
    private String copied;
    private int diceRoll = (int)(Math.random() * 10);

    public Demon(int width, int height) {
        type = (int)(Math.random() * 10);

        if (type >= 0 && type < 3) {
           // fast demon 
           symbol = "Z";
           hp = 5;
           damage = 5;
        }
        if (type >= 3 && type < 6) {
            // brute demon
            symbol = "T";
            hp = 10;
            damage = 15;
        }
        if (type >= 6 && type <= 9) {
            // tank demon
            symbol = "B";
            hp = 25;
            damage = 5;
        }
        if (type == 9 && diceRoll == 9) {
            // demon king
            symbol = "M";
            hp = 50;
            damage = 25;
        }

        x = (int)(Math.random() * width - 1);
        y = (int)(Math.random() * height - 1);
   }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public String copied() {
        return copied;
    }

    public void setX(int newX) {
        x = newX;
    }

    public void setY(int newY) {
        y = newY;
    }

    public void setCopied(String c)
    {
        copied = c;
    }

    // change this once leader damage is implemented
    public int hurt() {
        return hp -= 5;
    }

    public int hp() {
        return hp;
    }

    public int damage() {
        return damage;
    }

    public String symbol() {
        return symbol;
    }
    public void movement(Game game) {
        if (Math.abs(game.getPX() - x) <= 3 && Math.abs(game.getPY() - y) <= 3) {
            if ((game.getPX() - x) != 0) 
                x += (game.getPX() - x) / Math.abs(game.getPX() - x);
            if ((game.getPY() - y) != 0)
                y += (game.getPY() - y) / Math.abs(game.getPY() - y);
        }
        else {
            x += (int)(Math.random() * 3) - 1;
            y += (int)(Math.random() * 3) - 1;
        }
        
    }
}
