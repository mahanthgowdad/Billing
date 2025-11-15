# Chat Management & Billing System ☕

A simple, console-based **Restaurant/Cafe Billing System** built in Java that allows you to:
- Create multiple customer orders
- Add food & drink items to orders
- View order details
- Generate beautiful formatted bills
- View all active orders
- Search orders instantly (using HashMap)
- Find menu items using **Binary Search** (for learning purposes)

Perfect for beginners learning OOP, collections, and console applications in Java!

---

### Features
- Fully menu-driven interface
- Supports **unlimited simultaneous orders**
- Fast order lookup using `HashMap<Integer, Order>`
- Menu items searchable via **Binary Search**
- Clean bill generation with proper formatting
- Customer names & individual order tracking
- No external dependencies — pure Java

---

### Menu Items (Pre-loaded)
| ID | Item          | Price  |
|----|---------------|--------|
| 1  | Tea           | ₹15.00 |
| 2  | Coffee        | ₹20.00 |
| 3  | Samosa        | ₹25.00 |
| 4  | Sandwich      | ₹40.00 |
| 5  | Burger        | ₹60.00 |
| 6  | Pizza Slice   | ₹80.00 |
| 7  | Cold Drink    | ₹30.00 |
| 8  | Pastry        | ₹50.00 |

---

### How to Run

#### Using IntelliJ IDEA (Recommended)
1. Open IntelliJ IDEA
2. Create a new Java project or clone this repo
3. Copy `BillingSystem.java` into `src/`
4. Run the `main()` method in `BillingSystem` class
5. Start taking orders!

#### Using Command Line
bash
javac BillingSystem.java
java BillingSystem


---

### Sample Usage Flow

1 → Create New Order → Enter name → Get Order ID
2 → Add Item to Order → Enter Order ID → Choose items
4 → Generate Bill → See formatted bill
5 → View All Orders → See summary of all customers
0 → Exit


---

### Project Structure

src/
 └── BillingSystem.java     ← Main class (everything in one file for simplicity)


Classes used:
- `MenuItem` – Stores item details
- `Order` – Holds customer name, items, and total
- `BillingSystem` – Main logic, menu, HashMap storage, binary search

---

### Concepts Covered (Great for Learning!)
- Object-Oriented Programming (Classes & Objects)
- `ArrayList`, `HashMap`
- `Scanner` for console input
- Binary Search Algorithm
- Method organization & clean code
- Handling newline issues with `nextInt()` + `nextLine()`

---

### Future Improvements (You can add!)
- Save orders to a file (File I/O)
- GUI using JavaFX or Swing
- Delete/Cancel orders
- Apply discounts or GST
- Table number assignment
- Daily sales report

---

### Author
Made with ☕ & ❤ by Mahanth Gowda D  

> "A cup of tea and clean code — best combo ever!"

---

**Star this repo if you liked it!**  
Contributions & improvements are welcome!


