import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AAT {

	protected static Scanner sc;
	protected static String password;

	public static void main(String args[]) throws IOException {

		createUserName(); // Allows user to create a username
		getPassword();	// Prompts user for a password
		checkLength();	// Checks the length of the password
		checkLetterAndDigit();	// Checks that the password contains at least one letter and one numeric character
		checkSimple();	// Checks to make sure the password isnt too simple
		accountSuccess();	// Confirms account creation
	}

	private static void createUserName() {

		String username;

		System.out.println("Create a Username:");
		sc = new Scanner(System.in);
		username = sc.next();
		if (username.length() < 6 || !username.matches(".*[a-zA-z]+.*")
				|| !username.matches("(.)*(\\d)(.)*")) {
			System.out
					.println("Username must be at least 6 characters long, contain at least one letter, and "
							+ "contain at least one numeric character.");
			createUserName();
		}

	}

	private static void checkLength() {

		while (password.length() < 8) {
			System.out
					.println("No, the password has to be at least 8 characters long,");
			getPassword();
			checkLength();
		}
	}

	private static void checkLetterAndDigit() {
		if (password.length() < 8) {
			checkLength();
		}
		while (!password.matches(".*[a-zA-z]+.*")
				|| !password.matches("(.)*(\\d)(.)*")) {
			System.out
					.println("No, the password has to contain at least 1 letter and 1 numeric character");
			getPassword();
			checkLetterAndDigit();
		}
	}

	private static void checkSimple() throws IOException {
		
		if (password.length() < 8) {
			checkLength();
		}
		while (!password.matches(".*[a-zA-z]+.*")
				|| !password.matches("(.)*(\\d)(.)*")) {
			System.out
					.println("No, the password has to contain at least 1 letter and 1 numeric character,");
			getPassword();
			checkLetterAndDigit();
		}
		BufferedReader in = new BufferedReader(new FileReader(
				"SimplePasswords.txt"));
		for (int i = 0; i < 10000; i++) {
			String str = in.readLine();
			if (password.trim().equals(str)) {
				System.out.println("No, the password is too simple,");
				getPassword();
				checkSimple();
			} else {

			}
		}
		in.close();
	}
	
	private static void accountSuccess(){
		System.out.println("Account successfully created.");
	}
	
	// private static void changeUsername()
	// private static void changePassword()

	public static void getPassword() {
		System.out.println("Please Choose a Password:");
		sc = new Scanner(System.in);
		password = sc.next();

	}
}
