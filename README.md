Hotel Reservation System

Overview :

This is a simple console-based Hotel Reservation System implemented in Java. It allows hotel staff to manage room bookings, cancellations, and generate bills for customers. Users can also view all rooms or only available rooms in the hotel.

The program uses object-oriented programming concepts such as classes, objects, and ArrayLists to manage hotel data efficiently.

Features :

Add Room : Add a new room to the hotel with a room number, type, and price per day. Prevents adding duplicate room numbers.

View Available Rooms : Displays all rooms that are not currently booked.

Book Room : Allows booking a specific room for a customer. Checks if the room is already booked before confirming.

Cancel Booking : Cancels an existing booking for a specific room.

Generate Bill : Generates a detailed bill for a customer including room type, price per day, number of days, and total amount.

View All Rooms : Displays all rooms, along with their booking status and customer name if booked.

Exit : Terminates the program.

How to Run:
Compile the code:
javac HotelReservationSystem.java

Run the program:
java HotelReservationSystem

Follow the menu to manage rooms and bookings.

Notes:
Room numbers must be unique.
Only booked rooms can generate bills or be canceled.
