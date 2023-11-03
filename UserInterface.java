public class UserInterface {

    private int supplies;
    private int mercernaries;
    private int demons;
    
    public UserInterface() {
        supplies = 100;
        mercernaries = 2;
        demons = 0;
        System.out.println("Supplies: " + supplies + "%\tMercernaries: " + mercernaries + "\tDemon Activity: " + demons);

        if (supplies == 0) {
            System.out.print("Oh No! You ran out of supplies! You'll have to dip into your reserves!");
            int resSupplies = 25;
            if (resSupplies == 0) {
                System.out.print("You're out of supplies! Game Over!");
            }
        }
        if (mercernaries == 0) {
            System.out.print("You ran out of mercenaries! Game Over!");
        }
        if (demons >= 5) {
            System.out.print("You let the demons overrun you! Game Over!");
        }

        

    }
}