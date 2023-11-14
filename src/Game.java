import java.util.Scanner;

/**
 * Game Class
 * To start the game
 */
public class Game {
    public static void main(String[] args) {

        Display display = new Display();

        // open scanner
        Scanner sc = new Scanner(System.in);

        // read first hand
        display.askHand1();
        // reads string
        String input1 = sc.nextLine();
        // string to hand
        Hand hand1 = new Hand(input1, 1);

        // read second hand
        display.askHand2();
        // reads string
        String input2 = sc.nextLine();
        // string to hand
        Hand hand2 = new Hand(input2, 2);

        // close scanner
        sc.close();

        Referee ref = new Referee(hand1, hand2);

        // verification of the hand state
        if (ref.notifyHandState()) {
            // verification of no duplicate
            if(ref.notifyDuplicate()) {
                // start the game
                ref.start();
            } else {
                // display error if there are duplicate
                display.DuplicateError();
            }
        } else {
            // display error if the hand state is incorrect
            display.CompositionError();
        }

        // display result
        display.Result(ref);

    }
}
