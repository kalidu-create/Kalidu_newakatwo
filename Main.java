import java.util.Scanner;
class Main{
    // default login credentials
    static String userName = "wgga";
    static String password = "2007";

    static Scanner input = new Scanner(System.in);

    // supplier, category and item data store 
    static String[][] suppliers = new String[100][100];
    static int supplierCount = 0;

    static String[] categories = new String[100];
    static int categoryCount = 0;

    static String[][] items = new String[100][100];
    static int itemCount = 0;

    public static void main(String[] args) {
        loginPage(); // start with loginPage
    }

    public static void loginPage(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                                 LOGIN PAGE                               |");
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println();

        while(true) {
            System.out.print("User name: ");
            String entered_username = input.next();

            // user name check equals or not equals
            if(!entered_username.equals(userName)){
                System.out.println("User name is invalid. please try again!\n");
                continue;
            } else {
                System.out.println();

                while (true) {
                    System.out.print("Password: ");
                    String entered_password = input.next();

                    // password check equals or not equals
                    if(!entered_password.equals(password)){
                        System.out.println("Password is incorrect. please try again!\n");
                        continue;
                    } else {
                        homePage(); // if login successful
                    }
                }
            }
        }
    }

    public static void homePage(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                  WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                 |");
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println();
        System.out.println("[1]\sChange the Credentials         [2]\sSupplier Manage");
        System.out.println("[3]\sStock Manage                   [4]\sLog Out");
        System.out.println("[5]\sExit the System");
        System.out.println();
        System.out.print("Enter an option to continue > ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                changeCredentials();
                break;
            case 2:
                supplierManage();
                break;
            case 3:
                stockManage();
                break;
            case 4: 
                logOut();
                break;
            case 5: 
                exitPage();
                return;
            default:
                System.out.println("Invalid option! Please try again.\n");
        }
    }

    // update login credentials
    public static void changeCredentials(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                           CREDENTIAL MANAGE                              |");
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println();

        while(true) {
            System.out.print("Please enter the user name to verify it's you: ");
            String enteredUserName = input.next();

            if(enteredUserName.equals(userName)){
                System.out.println("Hey " + userName);
                break;
            } else {
                System.out.println("Invalid user name. try again!\n");
            }
        }
            
        while(true) {
            System.out.print("Enter your current password: ");
            String enteredPassword = input.next();

            if(enteredPassword.equals(password)){
                break;
            } else {
                System.out.println("Incorrect password. try again!\n");
            }
        }

        System.out.print("Enter your new password: ");
        String newPassword = input.next();

        password = newPassword;

        System.out.print("\nPassword changed successfully! Do you want to go home page?(Y/N): ");
        String choice = input.next();

        if(choice.equals("y")){
            homePage();
        } else {
            changeCredentials();
        }
    }

    // supplier manage
    public static void supplierManage(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                             SUPPLIER MANAGE                              |");
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println();
        System.out.println("[1]\sAdd Supplier          [2]\sUpdate Supplier");
        System.out.println("[3]\sDelete Supplier       [4]\sView Supplier");
        System.out.println("[5]\sSearch Supplier       [6]\sHome Page");
        System.out.println();
        System.out.print("Enter an option to continue > ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                addSupplier();
                break;
            case 2:
                updateSupplier();
                break;
            case 3:
                deleteSupplier();
                break;
            case 4:
                viewSupplier();
                break;
            case 5:
                searchSupplier();
                break;
            case 6:
                homePage();
                break;
            default:
                System.out.println("Invalid option! Please try again.\n");
        }
    }

    // add new supplier
    public static void addSupplier(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                                ADD SUPPLIER                              |");
        System.out.println("+--------------------------------------------------------------------------+");

        while(true) {
            System.out.print("\nSupplier ID: ");
            String supplierId = input.next();
            boolean exit = false;

            for(int i = 0; i < supplierCount; i++){
                if(suppliers[i][0].equals(supplierId)){
                    exit = true;
                    break;
                }
            }

            if (exit) {
                System.out.println("already added. try another supplier id!");
                continue;
            } else {
                System.out.print("Supplier name: ");
                String supplierName = input.next();

                suppliers[supplierCount][0] = supplierId;
                suppliers[supplierCount][1] = supplierName;
                supplierCount++;

                System.out.print("added successfully! Do you want to add another supplier?(Y/N): ");
                String choice = input.next();

                if (choice.equals("y")){
                    addSupplier();
                } else {
                    supplierManage();
                }
            }
        }
    }

    // update supplier name
    public static void updateSupplier(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                             UPDATE SUPPLIER                              |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        if(supplierCount == 0){
            System.out.print("No suppliers available! Do you want to add supplier?(Y/N): ");
            String choice = input.next();

            if(choice.equals("y")){
                addSupplier();
            } else {
                supplierManage();
            }
        }
        
        while(true) {
            System.out.print("Supplier ID: ");
            String supplierId = input.next();
            int index = -1;

            for(int i = 0; i < supplierCount; i++){
                if(suppliers[i][0].equals(supplierId)){
                    index = i;
                    break;
                }
            }

            if(index == -1){
                System.out.println("Can't find supplier id. try again!");
                continue;
            } else {
                System.out.println("Supplier name: " + suppliers[index][1]);
                System.out.print("Enter new supplier name: ");
                String newName = input.next();

                suppliers[index][1] = newName;

                System.out.print("Update successfully! Do you want to go update another supplier?(Y/N): ");
                String choice = input.next();

                if(choice.equals("y")){
                    updateSupplier();
                } else {
                    supplierManage();
                }
            }
        }
    }

    // delete suppliers
    public static void deleteSupplier(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                             DELETE SUPPLIER                              |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        if(supplierCount == 0){
            System.out.print("No suppliers availble! Do you want to add supplier?(Y/N): ");
            String choice = input.next();

            if(choice.equals("y")){
                addSupplier();
            } else {
                supplierManage();
            }
        }

        while(true) {
            System.out.print("Supplier ID: ");
            String supplierId = input.next();
            int index = -1;

            for(int i = 0; i < supplierCount; i++){
                if(suppliers[i][0].equals(supplierId)){
                    index = i;
                    break;
                }
            }

            if(index == -1){
                System.out.println("Can't find supplier id. try again!");
                continue;
            } else {
                for(int i = index; i < supplierCount - 1; i++){
                    suppliers[i][0] = suppliers[i+1][0];
                    suppliers[i][1] = suppliers[i+1][1];
                }
                supplierCount--;
                System.out.print("Delete successfully! Do you want to delete another supplier?{Y/N}: ");
                String choice = input.next();

                if(choice.equals("y")){
                    updateSupplier();
                } else {
                    supplierManage();
                }
            }
        }
    }

    // view all suppliers
    public static void viewSupplier(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                              VIEW SUPPLIERS                              |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        if(supplierCount == 0){
            System.out.print("No suppliers available! Do you want to add supplier?(Y/N): ");
            String choice = input.next();

            if(choice.equals("y")){
                addSupplier();
            } else {
                supplierManage();
            }
        }

        System.out.println("+-----------------------------------+-----------------------------------+");
        System.out.println("|            SUPPLIER ID            |           SUPPLIER NAME           |");
        System.out.println("+-----------------------------------+-----------------------------------+");

        for(int i = 0; i < supplierCount; i++){
            System.out.printf("| %-33s | %-33s |\n", suppliers[i][0], suppliers[i][1]);
        }
        System.out.println("+-----------------------------------+-----------------------------------+");
        System.out.print("Do you want to supplier manage page?(Y/N): ");
        String choice = input.next();

        if (choice.equals("y")){
            supplierManage();
        } else {
            viewSupplier();
        }
    }

    // search supplier by supplier ID
    public static void searchSupplier(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                             SEARCH SUPPLIER                              |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        if(supplierCount == 0){
            System.out.print("No suppliers available! Do you want to add supplier?(Y/N): ");
            String choice = input.next();

            if(choice.equals("y")){
                addSupplier();
            } else {
                supplierManage();
            }
        }

        while(true) {
            System.out.print("Supplier ID: ");
            String supplierId = input.next();
            int index = -1;

            for(int i = 0 ; i < supplierCount; i++){
                if(suppliers[i][0].equals(supplierId)){
                    index = i;
                    break;
                }
            }

            if(index == -1){
                System.out.println("Can't find supplier id. try again!");
                continue;
            } else {
                System.out.println("Supplier name: " + suppliers[index][1]);
                System.out.print("added successfully! Do you want to another find supplier?(Y/N): ");
                String choice = input.next();

                if(choice.equals("y")){
                    searchSupplier();
                } else {
                    supplierManage();
                }
            }
        }
    }

    // stock manage page 
    public static void stockManage(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                            STOCK MANAGEMENT                              |");
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println();
        System.out.println("[1]\sManage Item Categories          [2]\sAdd Item");
        System.out.println("[3]\sGet Item Supplier Wise          [4]\sView Item");
        System.out.println("[5]\sRank Item Per Unit Price        [6]\sHome Page");
        System.out.println();
        System.out.print("Enter an option to continue > ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                manageItemCategories();
                break;
            case 2:
                addItem();
                break;
            case 3:
                getItemSupplierWise();
                break;
            case 4:
                viewItem();
                break;
            case 5:
                rankItemUnitPrice();
                break;
            case 6:
                homePage();
                break;
            default:
                System.out.println("Invalid option! Please try again.\n");
        }
    }

    // manage item categories
    public static void manageItemCategories(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                            MANAGE ITEM CATEGORY                          |");
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println();
        System.out.println("[1]\sAdd New Item Category          [2]\sDelete Item Category");
        System.out.println("[3]\sUpdate Item Category           [4]\sStock Management");
        System.out.println();
        System.out.print("Enter an option to continue > ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                addItemCategory();
                break;
            case 2:
                deleteItemCategory();
                break;
            case 3:
                updateItemCategory();
                break;
            case 4:
                stockManage();
                break;
            default:
                System.out.println("Invalid option! Please try again.\n");
        }
    }

    // add a new item category
    public static void addItemCategory(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                             ADD ITEM CATEGORY                            |");
        System.out.println("+--------------------------------------------------------------------------+\n");
        
        while(true) {
            System.out.print("Enter the new item category: ");
            String category = input.next();
            boolean exit = false;

            for(int i = 0; i < categoryCount; i++){
                if(categories[i].equals(category)){
                    exit = true;
                    break;
                }
            }

            if(exit){
                System.out.println("This category already added. try again!\n");
                continue;
            } else {
                categories[categoryCount] = category;
                categoryCount++;
                System.out.print("added successfully! Do you want to add another item category?(Y/N): ");
                String choice = input.next();

                if(choice.equals("y")){
                    addItemCategory();
                } else {
                    manageItemCategories();
                }
            }
        }
    }

    // delete an item category
    public static void deleteItemCategory(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                          DELETE ITEM CATEGORY                            |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        if(categoryCount == 0){
            System.out.print("No item category avilable! Do you want to add item category?(Y/N): ");
            String choice = input.next();

            if(choice.equals("y")){
                addItemCategory();
            } else {
                manageItemCategories();
            }
        }

        while(true) {
            System.out.print("Enter item category: ");
            String category = input.next();
            int index = -1;

            for(int i = 0; i < categoryCount; i++){
                if(categories[i].equals(category)){
                    index = i;
                }
            }

            if(index == -1){
                System.out.println("Can't find category. try again!\n");
                continue;
            } else {
                for(int i = index; i < categoryCount; i++){
                    categories[i] = categories[i+1];
                }
                categoryCount--;
                System.out.print("delete successfully! Do you want to delete another category?(Y/N): ");
                String choice = input.next();

                if (choice.equals("y")){
                    deleteItemCategory();
                } else {
                    manageItemCategories();
                }
            }
        }
    }

    // update an item category
    public static void updateItemCategory(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                          UPDATE ITEM CATEGORY                            |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        if(categoryCount == 0){
            System.out.print("No item category available! Do you want to add item category?(Y/N): ");
            String choice = input.next();

            if(choice.equals("y")){
                addItemCategory();
            } else {
                manageItemCategories();
            }
        }

        while(true) {
            System.out.print("Enter item category: ");
            String category = input.next();
            int index = -1;

            for(int i = 0; i < categoryCount; i++){
                if(categories[i].equals(category)){
                    index = i;
                    break;
                }
            }

            if(index == -1){
                System.out.println("Can't find item category. try again!\n");
                continue;
            } else {
                System.out.println("Item category name: " + categories[index]);
                System.out.print("Enter new item category: ");
                String newCategoryName = input.next();

                categories[index] = newCategoryName;

                System.out.print("Update successfully! Do you want to go update another item category?(Y/N): ");
                String choice = input.next();

                if(choice.equals("y")){
                    updateItemCategory();
                } else {
                    manageItemCategories();
                }
            }
        }
    }

    // add a new stock item
    public static void addItem() {
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                                 ADD ITEM                                 |");
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println();

        if (categoryCount == 0) {
            System.out.println("OOPS! It seems that you don't have any item categories in the system.");
            System.out.print("Do you want to add a new item category?(Y/N): ");
            String choice = input.next();

            if (choice.equals("y")) {
                addItemCategory();
                addItem();
                return;
            } else {
                stockManage();
                return;
            }

        } else {
            if (supplierCount == 0) {
                System.out.println("OOPS! It seems that you don't have any suppliers in the system.");
                System.out.print("Do you want to add a new supplier?(Y/N): ");
                String choice = input.next();

                if (choice.equals("y")) {
                    addSupplier();
                    addItem();
                    return;
                }  else {
                    stockManage();
                    return;
                }
            }

            while (true) {
                System.out.print("Enter Item Code: ");
                String itemCode = input.next();
                boolean codeExists = false;

                for (int i = 0; i < itemCount; i++) {
                    if (items[i][0].equals(itemCode)) {
                        codeExists = true;
                        break;
                    }
                }

                if (codeExists) {
                    System.out.println("already added. try again!\n");
                    continue;
                } else {
                    System.out.println("\nSuppliers List:");
                    System.out.println("+-----------------+-------------------------+-------------------------+");
                    System.out.println("|        #        |       SUPPLIER ID       |       SUPPLIER NAME     |");
                    System.out.println("+-----------------+-------------------------+-------------------------+");

                    for (int i = 0; i < supplierCount; i++) {
                        System.out.printf("| %-15d | %-23s | %-23s |\n", (i + 1), suppliers[i][0], suppliers[i][1]);
                    }

                    System.out.println("+-----------------+-------------------------+-------------------------+");
                    System.out.print("\nEnter the supplier number > ");
                    int s = input.nextInt() -1 ;

                    if (s < 0 || s >= supplierCount) {
                        System.out.println("Invalid supplier number!\n");
                        continue;
                    } else {
                        String supplierId = suppliers[s][0];
                        System.out.println("\nItem Categories:");
                        System.out.println("+-----------------+-------------------------+");
                        System.out.println("|        #        |      CATEGORY NAME      |");
                        System.out.println("+-----------------+-------------------------+");

                        for (int i = 0; i < categoryCount; i++) {
                            System.out.printf("| %-15d | %-23s |\n", (i + 1), categories[i]);
                        }
                        
                        System.out.println("+-----------------+-------------------------+");
                        System.out.print("\nEnter the category number > ");
                        int c = input.nextInt() -1;

                        if (c < 0 || c >= categoryCount) {
                            System.out.println("Invalid category number!");
                            continue;
                        } else {
                            String category = categories[c];

                            System.out.print("Description: ");
                            String description = input.next();

                            System.out.print("Unit price: ");
                            String unitPrice = input.next();

                            System.out.print("Qty on hand: ");
                            String qtyOnHand = input.next();

                            items[itemCount][0] = itemCode;
                            items[itemCount][1] = supplierId;
                            items[itemCount][2] = category;
                            items[itemCount][3] = description;
                            items[itemCount][4] = unitPrice;
                            items[itemCount][5] = qtyOnHand;
                            itemCount++;
                            System.out.print("added successfully! Do you want to add another item?(Y/N): ");
                            String choice = input.next();

                            if (choice.equals("y")){
                                addItem();
                            } else {
                                stockManage();
                            }
                        }
                    }
                }
            }
        }
    }


    // get items by supplier
    public static void getItemSupplierWise(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                             SEARCH SUPPLIER                              |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        if(supplierCount == 0){
            System.out.print("No suppliers available. Do you want to add suppliers?(Y/N): ");
            String choice = input.next();

            if(choice.equals("y")){
                addSupplier();
            } else {
                stockManage();
            }
        }

        while(true){
            System.out.print("Enter supplier ID: ");
            String supplierId = input.next();
            boolean supplierExit = false;
            String supplierName = "";

            for(int i = 0; i < supplierCount; i++){
                if(suppliers[i][0].equals(supplierId)){
                    supplierExit = true;
                    supplierName = suppliers[i][0];
                    break;
                }
            }

            if(!supplierExit){
                System.out.println("Supplier not found!\n");
                continue;
            } else {
                boolean itemFound = false;
                System.out.println("Supplier name: " + supplierName + "\n");

                System.out.println("+-------------+----------------------+------------------+----------------+---------------+");
                System.out.println("|  ITEM CODE  |      DESCRIPTION     |    UNIT PRICE    |   QTN ON HAND  |    CATEGORY   |");
                System.out.println("+-------------+----------------------+------------------+----------------+---------------+");

                for(int i = 0; i < itemCount; i++){
                    if(items[i][1].equals(supplierId)){
                        itemFound = true;
                        System.out.printf("| %-11s | %-20s | %-16s | %-14s | %-13s |\n", items[i][0], items[i][3], items[i][4]+".0", items[i][5], items[i][2]);
                    }
                }

                if(!itemFound){
                    System.out.println("|                          No items found for this supplier.                             |");
                } 

                System.out.println("+-------------+----------------------+------------------+----------------+---------------+");

                System.out.print("search successfully! Do you want to search another one?(Y/N): ");
                String choice = input.next();

                if(choice.equals("y")){
                    getItemSupplierWise();
                } else {
                    stockManage();
                }
            }
        }
    }

    // view all items
    public static void viewItem(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                                 VIEW ITEM                                |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        if(itemCount == 0){
            System.out.print("No items available. Do you want to add item?(Y/N): ");
            String choice = input.next();

            if(choice.equals("y")){
                addItem();
            } else {
                stockManage();
            }
            
        } else {
            for (int c = 0; c < categoryCount; c++) {
                String category = categories[c];
                boolean categoryItems = false;

                for (int i = 0; i < itemCount; i++) {
                    if (items[i][2].equals(category)) {
                        categoryItems = true;
                        break;
                    }
                }

                if (categoryItems) {
                    System.out.println(category + ":");
                    System.out.println("+------------+---------------+-------------------+-------------+--------+");
                    System.out.println("|     SID    |     CODE      |        DESC       |    PRICE    |   QTY  |");
                    System.out.println("+------------+---------------+-------------------+-------------+--------+");
                    for (int i = 0; i < itemCount; i++) {
                        if (items[i][2].equals(category)) {
                            System.out.printf("| %-10s | %-13s | %-17s | %-11s | %-6s |\n", items[i][1], items[i][0], items[i][3], items[i][4]+".0", items[i][5]);
                        }
                    }
                    System.out.println("+------------+---------------+-------------------+-------------+--------+\n");
                }
            }
            System.out.print("Do you want to go stock manage page?(Y/N): ");
            String choice = input.next();

            if(choice.equals("y")){
                stockManage();
            } else {
                viewItem();
            }
        }
    }

    // ranked items by unit price in ascending order
    public static void rankItemUnitPrice(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                            RANKED UNIT PRICE                             |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        if(itemCount == 0){
            System.out.print("No items available to rank. Do you want to add item?(Y/N): ");
            String choice = input.next();

            if(choice.equals("y")){
                addItem();
            } else {
                stockManage();
            }

        } else {
            String[][] sortedItems = new String[itemCount][];
            for(int i = 0; i < itemCount; i++){
                sortedItems[i] = items[i];
            }
            for(int i = 0; i < itemCount-1; i++){
                for(int j = i+1; j < itemCount; j++){
                    double price1 = Double.parseDouble(sortedItems[i][4]);
                    double price2 = Double.parseDouble(sortedItems[j][4]);

                    if(price1 > price2){
                        String[] temp = sortedItems[i];
                        sortedItems[i] = sortedItems[j];
                        sortedItems[j] = temp;
                    }
                }
            }
            System.out.println("+------------+---------------+-------------------+-------------+----------+-------------+");
            System.out.println("|     SID    |     CODE      |        DESC       |    PRICE    |    QTY   |     CAT     |");
            System.out.println("+------------+---------------+-------------------+-------------+----------+-------------+");
            for(int i = 0; i < itemCount; i++){
                System.out.printf("| %-10s | %-13s | %-17s | %-11s | %-8s | %-11s |\n", sortedItems[i][1], sortedItems[i][0], sortedItems[i][3], sortedItems[i][4]+".0",sortedItems[i][5], sortedItems[i][2]);
            }
            System.out.println("+------------+---------------+-------------------+-------------+----------+-------------+");
            System.out.print("Do you want to go stock manage page?(Y/N): ");
            String choice = input.next();

            if(choice.equals("y")){
                stockManage();
            } else {
                rankItemUnitPrice();
            }
        }
    }

    // log out and retrun to login page
    public static void logOut(){
        loginPage();
    }

    //exit the system
    public static void exitPage(){
        clearConsole();
        System.out.println("\n----------------");
        System.out.println("(Program exited with code: 0)");
        int code = 0;
        System.out.println("Press return to continue");
        int enteredCode = input.nextInt();

        if(enteredCode == code){
            System.exit(enteredCode);
            return;
        } else {
            exitPage();
        }
    }

    // clear terminal
    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();
            
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }
}