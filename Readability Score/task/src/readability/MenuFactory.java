package readability;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

class MenuFactory {
    private String menuList;
    private TextProcessing textProc;

    MenuFactory(TextProcessing textProc) {
        this.textProc = textProc;
        createMenuList();
    }

    void executeAction(MenuList menuAction) {
        switch (menuAction) {
            case ARI:
                textProc.calcARI();
                break;
            case FK:
                textProc.calcFK();
                break;
            case SMOG:
                textProc.calcSMOG();
                break;
            case CL:
                textProc.calcCL();
                break;
            case ALL:
                textProc.calcAll();
                break;
        }
    }

    MenuList chooseAction(String inputString) {
        MenuList menuAction = null;
        for (MenuList value : MenuList.values()) {
            if (Objects.equals(
                    value.toString().toLowerCase(),
                    inputString.toLowerCase())) {
                menuAction = value;
                break;
            }
        }
        return menuAction;
    }

    void printMenuList() {
        System.out.printf("Enter the score you want to calculate (%s): ", menuList);
    }

    private void createMenuList() {
        menuList = Arrays.stream(MenuList.values())
                .map(MenuList::name)
                .collect(Collectors.joining(", "));

    }
}
