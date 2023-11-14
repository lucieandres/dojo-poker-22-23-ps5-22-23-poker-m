/**
 * Display Class
 * Used to write in the coderunner
 */
public class Display {

    /**
     * Display constructor
     */
    public Display() {
    }

    /**
     * Method to ask the first hand in the code runner
     */
    public void askHand1() {
        System.out.print("Rentrez la première main : ");
    }

    /**
     * Method to ask the second hand in the code runner
     */
    public void askHand2() {
        System.out.print("Rentrez la seconde main : ");
    }

    /**
     * Method to print in the coderunner that there is an error about a the hand format
     */
    public void CompositionError() {
        System.out.println("Erreur, la main doit être composée de "+ Hand.SIZE_OF_HAND +" cartes.\n" +
                "Assurez-vous d'avoir saisi des cartes entre 2 et 10 ou A(As), V(Valet), D(Dame), R(Roi)."+
                "Assurez-vous d'avoir saisi des couleurs valides (Co, Ca, Pi, Tr)");
    }

    /**
     * Method to print in the coderunner that there is an error about a duplication
     */
    public void DuplicateError() {
        System.out.println("Attention, la meme carte apparait 2 fois");
    }


    /**
     * Method to print in the coderunner the result of the game
     */
    public void Result(Referee ref) {
        System.out.println(ref.getResult());
    }

}
