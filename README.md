# Security Key Manager

A Java-based console application for managing and transforming security keys through various operations such as validation, modification, insertion, and removal. Designed to demonstrate strong command of Java fundamentals, string manipulation, and regex-based validation.

## Features

- Validates initial security key with **regex pattern** (`^[A-Za-z0-9_]{6,20}$`)
- Provides multiple operations:
  - **Check** for substrings  
  - **Change** case (upper/lower) in a specific range  
  - **Remove** characters in a range  
  - **Insert** text at a specific position  
  - **Replace** substrings  
  - **Reverse** a substring  
- Class-level key management with **static field and methods**  
- Modular and clean code structure for easy maintenance  

## Technologies Used

- **Programming Language:** Java  
- **Libraries:** Java Standard Library (Regex, StringBuilder)  
- **Version Control:** Git  
- **IDE:** JetBrains IntelliJ IDEA

## Test

- Input
my_secureKey2025
Insert:::2:::X_
Change:::Upper:::3:::10
Replace:::2025:::2026
Reverse:::4:::8
Check:::KEY
Remove:::0:::2
Finalize

-Output
myX_secureKey2025
myX_SECUREKey2025
myX_SECUREKey2026
myX_SEUCERKey2026
Substring not found!
X_SEUCERKey2026
Your final security key is: X_SEUCERKey2026


## Project Structure
 /src/main/java – source code
 /src/test/java – tests
**README.md** – project documentation
 Author
Developed by Ivan Peshterski – passionate about full-stack development and problem solving.
 **License**
This project is licensed under the MIT License.

