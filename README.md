# Currency Converter App

A simple Java Swing-based Currency Converter application for beginner-level university projects.  
This project allows users to convert currencies between USD, BDT, and EUR using a graphical user interface (GUI).

---

## Features

- Convert currencies instantly
- User-friendly GUI using Java Swing
- Supports:
  - USD (US Dollar)
  - BDT (Bangladeshi Taka)
  - EUR (Euro)
- Multithreading used for smooth GUI performance
- Input validation with error messages
- Exit button included
- Easy to add more currencies later

---

## Technologies Used

- Java
- Java Swing
- AWT
- Multithreading

---

## Project Structure

```bash
converterrapp/
│
├── Calculate.java
├── Converter.png
```

---

## How to Run

1. Open the project in your Java IDE  
   (NetBeans / IntelliJ IDEA / Eclipse recommended)

2. Make sure:
   - `Calculate.java` is inside the `converterrapp` package
   - `Converter.png` is inside the same package folder

3. Compile and run:

```bash
javac Calculate.java
java Calculate
```

Or simply run using your IDE.

---

## Currency Conversion Logic

The project currently uses fixed conversion rates:

| From | To | Rate |
|------|----|------|
| USD | BDT | 110 |
| USD | EUR | 0.92 |
| BDT | USD | 1 / 110 |
| BDT | EUR | 1 / 120 |
| EUR | USD | 1 / 0.92 |
| EUR | BDT | 120 |

---

## Future Improvements

- Add real-time exchange rates using APIs
- Add more currencies
- Improve GUI design
- Add dark/light mode
- Add currency flags/icons
- Store conversion history

---

Developed as a beginner-friendly university project using Java Swing.
