import java.util.*;

class Room {
    int roomNumber;
    String type;
    int price;
    boolean isBooked;
    String customerName;

    Room(int roomNumber, String type, int price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isBooked = false;
        this.customerName = "";
    }

    void displayRoom() {
        System.out.println("Room No: " + roomNumber +
                ", Type: " + type +
                ", Price: ₹" + price +
                ", Booked: " + (isBooked ? "Yes" : "No") +
                (isBooked ? ", Customer: " + customerName : ""));
    }
}

class Hotel {
    ArrayList<Room> rooms = new ArrayList<>();

    void addRoom(int roomNumber, String type, int price) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber) {
                System.out.println("Room already exists!");
                return;
            }
        }
        rooms.add(new Room(roomNumber, type, price));
        System.out.println("Room added successfully!");
    }

    void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            if (!r.isBooked) {
                r.displayRoom();
            }
        }
    }

    void bookRoom(int roomNumber, String name) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber) {
                if (!r.isBooked) {
                    r.isBooked = true;
                    r.customerName = name;
                    System.out.println("Room booked successfully for " + name);
                } else {
                    System.out.println("Room already booked.");
                }
                return;
            }
        }
        System.out.println("Room not found.");
    }

    void cancelBooking(int roomNumber) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber) {
                if (r.isBooked) {
                    r.isBooked = false;
                    System.out.println("Booking cancelled for " + r.customerName);
                    r.customerName = "";
                } else {
                    System.out.println("Room is not booked.");
                }
                return;
            }
        }
        System.out.println("Room not found.");
    }

    void generateBill(int roomNumber, int days) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber && r.isBooked) {
                int total = r.price * days;
                System.out.println("\n----- BILL -----");
                System.out.println("Customer: " + r.customerName);
                System.out.println("Room No: " + r.roomNumber);
                System.out.println("Room Type: " + r.type);
                System.out.println("Price per day: ₹" + r.price);
                System.out.println("Days: " + days);
                System.out.println("Total Amount: ₹" + total);
                System.out.println("----------------");
                return;
            }
        }
        System.out.println("Invalid room or not booked.");
    }

    void showAllRooms() {
        System.out.println("\nAll Rooms:");
        for (Room r : rooms) {
            r.displayRoom();
        }
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\n--- Hotel Menu ---");
            System.out.println("1. Add Room");
            System.out.println("2. View Available Rooms");
            System.out.println("3. Book Room");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Generate Bill");
            System.out.println("6. View All Rooms");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Room Type: ");
                    String type = sc.nextLine();

                    System.out.print("Enter Price per Day: ");
                    int price = sc.nextInt();

                    hotel.addRoom(roomNo, type, price);
                    break;

                case 2:
                    hotel.showAvailableRooms();
                    break;

                case 3:
                    System.out.print("Enter Room Number: ");
                    int bookNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    hotel.bookRoom(bookNo, name);
                    break;

                case 4:
                    System.out.print("Enter Room Number: ");
                    int cancelNo = sc.nextInt();
                    hotel.cancelBooking(cancelNo);
                    break;

                case 5:
                    System.out.print("Enter Room Number: ");
                    int billNo = sc.nextInt();

                    System.out.print("Enter Number of Days: ");
                    int days = sc.nextInt();

                    hotel.generateBill(billNo, days);
                    break;

                case 6:
                    hotel.showAllRooms();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}