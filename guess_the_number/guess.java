import javax.swing.JOptionPane;
import java.util.Random;

public class GuessTheNumber {

    public static void main(String[] args) {

        Random random = new Random();
        int number = random.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        int maxAttempts = 5;

        JOptionPane.showMessageDialog(
                null,
                "🎮 Guess the Number Game 🎮\n\nI have selected a number between 1 and 100.\nYou have 5 attempts.",
                "Welcome",
                JOptionPane.INFORMATION_MESSAGE
        );

        while (attempts < maxAttempts) {

            String input = JOptionPane.showInputDialog(
                    null,
                    "Attempt " + (attempts + 1) + " of " + maxAttempts +
                    "\nEnter your guess:",
                    "Enter Number",
                    JOptionPane.QUESTION_MESSAGE
            );

            // Exit if user clicks Cancel
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Game Cancelled!");
                System.exit(0);
            }

            int guess = Integer.parseInt(input);
            attempts++;

            if (guess > number) {
                JOptionPane.showMessageDialog(null, "📈 Too High!");
            } else if (guess < number) {
                JOptionPane.showMessageDialog(null, "📉 Too Low!");
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "🎉 Correct!\nYou guessed the number in " + attempts + " attempts.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
                System.exit(0);
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "❌ You have used all attempts!\nThe correct number was: " + number,
                "Game Over",
                JOptionPane.ERROR_MESSAGE
        );

        System.exit(0);
    }
}
