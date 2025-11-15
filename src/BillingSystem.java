import java.util.*;

class MenuItem {
    int id;
    String name;
    double price;

    MenuItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Order {
    int orderId;
    String customerName;
    ArrayList<MenuItem> items;
    double totalAmount;

    Order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    void addItem(MenuItem item) {
        items.add(item);
        totalAmount += item.price;
    }
}

public class BillingSystem {
    static HashMap<Integer, Order> orders = new HashMap<>();
    static ArrayList<MenuItem> menu = new ArrayList<>();
    static int orderCounter = 1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeMenu();
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();        // This was already here – good!

            switch(choice) {
                case 1: createNewOrder(); break;
                case 2: addItemToOrder(); break;
                case 3: viewOrder(); break;
                case 4: generateBill(); break;
                case 5: viewAllOrders(); break;
                case 6: searchOrder(); break;
                case 0:
                    System.out.println("Thank you! Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        } while(choice != 0);
    }

    static void initializeMenu() {
        menu.add(new MenuItem(1, "Tea", 15.0));
        menu.add(new MenuItem(2, "Coffee", 20.0));
        menu.add(new MenuItem(3, "Samosa", 25.0));
        menu.add(new MenuItem(4, "Sandwich", 40.0));
        menu.add(new MenuItem(5, "Burger", 60.0));
        menu.add(new MenuItem(6, "Pizza Slice", 80.0));
        menu.add(new MenuItem(7, "Cold Drink", 30.0));
        menu.add(new MenuItem(8, "Pastry", 50.0));
    }

    static void displayMenu() {
        System.out.println("\n===== CHAT MANAGEMENT & BILLING SYSTEM =====");
        System.out.println("1. Create New Order");
        System.out.println("2. Add Item to Order");
        System.out.println("3. View Order Details");
        System.out.println("4. Generate Bill");
        System.out.println("5. View All Orders");
        System.out.println("6. Search Order (Binary Search)");
        System.out.println("0. Exit");
        System.out.println("==========================================");
    }

    static void createNewOrder() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        Order order = new Order(orderCounter, name);
        orders.put(orderCounter, order);
        System.out.println("Order created successfully! Order ID: " + orderCounter);
        orderCounter++;
    }

    // FIXED – added sc.nextLine() after every nextInt()
    static void addItemToOrder() {
        System.out.print("Enter Order ID: ");
        int orderId = sc.nextInt();
        sc.nextLine();                     // ← ADD THIS

        if(!orders.containsKey(orderId)) {
            System.out.println("Order not found!");
            return;
        }

        System.out.println("\n--- Available Items ---");
        for(MenuItem item : menu) {
            System.out.println(item.id + ". " + item.name + " - Rs." + item.price);
        }

        System.out.print("Enter item ID to add: ");
        int itemId = sc.nextInt();
        sc.nextLine();                     // ← AND THIS

        MenuItem selectedItem = binarySearchItem(itemId);
        if(selectedItem != null) {
            orders.get(orderId).addItem(selectedItem);
            System.out.println("Item added successfully!");
        } else {
            System.out.println("Item not found!");
        }
    }

    static void viewOrder() {
        System.out.print("Enter Order ID: ");
        int orderId = sc.nextInt();
        sc.nextLine();                     // ← ADD THIS

        Order order = orders.get(orderId);
        if(order == null) {
            System.out.println("Order not found!");
            return;
        }

        System.out.println("\n--- Order Details ---");
        System.out.println("Order ID: " + order.orderId);
        System.out.println("Customer: " + order.customerName);
        System.out.println("Items:");
        if(order.items.isEmpty()) {
            System.out.println("  No items yet.");
        } else {
            for(MenuItem item : order.items) {
                System.out.println("  - " + item.name + ": Rs." + item.price);
            }
        }
        System.out.println("Total Amount: Rs." + order.totalAmount);
    }

    static void generateBill() {
        System.out.print("Enter Order ID: ");
        int orderId = sc.nextInt();
        sc.nextLine();                     // ← ADD THIS

        Order order = orders.get(orderId);
        if(order == null) {
            System.out.println("Order not found!");
            return;
        }

        System.out.println("\n========== BILL ==========");
        System.out.println("Order ID: " + order.orderId);
        System.out.println("Customer: " + order.customerName);
        System.out.println("--------------------------");
        if(order.items.isEmpty()) {
            System.out.println("No items ordered.");
        } else {
            for(MenuItem item : order.items) {
                System.out.printf("%-15s Rs.%.2f\n", item.name, item.price);
            }
        }
        System.out.println("--------------------------");
        System.out.printf("Total: Rs.%.2f\n", order.totalAmount);
        System.out.println("==========================");
    }

    static void viewAllOrders() {
        if(orders.isEmpty()) {
            System.out.println("No orders available!");
            return;
        }

        System.out.println("\n--- All Orders ---");
        for(Order order : orders.values()) {
            System.out.println("Order ID: " + order.orderId + " | Customer: " +
                    order.customerName + " | Total: Rs." + order.totalAmount);
        }
    }

    static void searchOrder() {
        System.out.print("Enter Order ID to search: ");
        int orderId = sc.nextInt();
        sc.nextLine();                     // ← ADD THIS

        if(orders.containsKey(orderId)) {
            Order order = orders.get(orderId);
            System.out.println("Order found! Customer: " + order.customerName +
                    " | Total: Rs." + order.totalAmount);
        } else {
            System.out.println("Order not found!");
        }
    }

    static MenuItem binarySearchItem(int itemId) {
        int left = 0, right = menu.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(menu.get(mid).id == itemId) {
                return menu.get(mid);
            }
            if(menu.get(mid).id < itemId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}