package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextProcessing textProc = new TextProcessing();
        MenuFactory menuFactory = new MenuFactory(textProc);
        MenuList menuAction = null;

        String text = args.length == 0 ? "txt" : args[0];

        textProc.readText(text);
        textProc.printText();
        textProc.decomposeText();
        textProc.printTextStats();

        while (menuAction == null) {
            menuFactory.printMenuList();
            menuAction = menuFactory.chooseAction(scanner.nextLine());

            if (menuAction == null) {
                System.out.println("Incorrect action!");
            }
        }
        System.out.println();
        menuFactory.executeAction(menuAction);
    }
}
