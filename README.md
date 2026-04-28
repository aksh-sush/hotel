# Hotel Management System
Problem Statement

Design a Hotel Management System that allows a guest to check room availability and proceed with a booking. The manager controls room data and verifies availability before a booking is made.

---

Approach / Logic Used

The system is built around 5 core classes and 1 integration class:
Room – Holds room details (number, type, floor, rate, status) and checks availability

Booking – Records a reservation linking a guest to a room with check-in/check-out dates

Guest – Holds guest details and manages their bookings

Invoice – Calculates the final bill at checkout including extras and taxes

HotelManager – Manages the list of rooms, checks availability, returns a boolean to the system

HotelSystem – Entry point — guest passes details, manager checks, booking proceeds if available




---

Steps to Execute


Compile all Java files

javac *.java


Step 3 — Run the simulation

java HotelSystem

