import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";

    public static String generatePassword(int length, boolean useUpper, boolean useLower, boolean useDigits, boolean useSpecial) {
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than 0");
        }

        StringBuilder characters = new StringBuilder();
        if (useUpper) characters.append(UPPER);
        if (useLower) characters.append(LOWER);
        if (useDigits) characters.append(DIGITS);
        if (useSpecial) characters.append(SPECIAL);

        if (characters.length() == 0) {
            throw new IllegalArgumentException("At least one character type (upper, lower, digits, special) must be selected");
        }

        Random random;
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            random = new SecureRandom();
        }

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Willkommen beim Passwort-Generator!");
        System.out.println("-----------------------------------");
        
        // Länge des Passworts
        int length;
        while (true) {
            System.out.print("Wie lang soll das Passwort sein? (min. 8 Zeichen): ");
            try {
                length = Integer.parseInt(scanner.nextLine());
                if (length >= 8) {
                    break;
                } else {
                    System.out.println("Das Passwort muss mindestens 8 Zeichen lang sein!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Bitte geben Sie eine gültige Zahl ein!");
            }
        }
        
        // Zeichentypen
        boolean useUpper = false;
        boolean useLower = false;
        boolean useDigits = false;
        boolean useSpecial = false;
        
        System.out.println("\nWelche Zeichentypen sollen verwendet werden?");
        System.out.println("(Antworten Sie mit 'j' für ja oder 'n' für nein)");
        
        while (!useUpper && !useLower && !useDigits && !useSpecial) {
            System.out.print("Großbuchstaben (A-Z)? ");
            useUpper = scanner.nextLine().toLowerCase().startsWith("j");
            
            System.out.print("Kleinbuchstaben (a-z)? ");
            useLower = scanner.nextLine().toLowerCase().startsWith("j");
            
            System.out.print("Zahlen (0-9)? ");
            useDigits = scanner.nextLine().toLowerCase().startsWith("j");
            
            System.out.print("Sonderzeichen (!@#$%^&*...)? ");
            useSpecial = scanner.nextLine().toLowerCase().startsWith("j");
            
            if (!useUpper && !useLower && !useDigits && !useSpecial) {
                System.out.println("\nMindestens ein Zeichentyp muss ausgewählt werden!");
            }
        }

        String password = generatePassword(length, useUpper, useLower, useDigits, useSpecial);
        System.out.println("\nIhr generiertes Passwort ist: " + password);
        
        scanner.close();
    }
}
