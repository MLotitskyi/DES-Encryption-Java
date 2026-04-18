# DES Encryption Java

A Java desktop application that implements the Data Encryption Standard (DES) algorithm from scratch with a graphical user interface.

The project demonstrates the full encryption and decryption process, including key generation, Feistel network structure, permutations, and S-box transformations.

---

## Overview

This application allows users to:
- Encrypt and decrypt text using the DES algorithm
- Visualize how data is transformed during encryption
- Use a graphical interface for interaction with the cipher

The project is intended for educational purposes to understand classical symmetric encryption algorithms.

---

## Features

- Full implementation of DES algorithm from scratch
- 16-round Feistel network
- Key generation algorithm
- Initial and final permutations
- S-box substitution logic
- Bitwise operations on binary data
- GUI interface using Java Swing
- Support for text and file encryption/decryption

---

## Architecture

```
src/main/java/
├── des/
│   ├── DES.java
│   ├── KeyGenerator.java
│   ├── Round.java
│   ├── Permutation.java
│   └── SBox.java
│
├── gui/
│   ├── MainWindow.java
│   ├── TextPanel.java
│   └── FileChooserHandler.java
│
├── utils/
│   ├── ByteUtils.java
│   ├── FileHandler.java
│   └── Padding.java
│
└── Main.java
```

---

## How to Run

### Clone repository
git clone https://github.com/USERNAME/DES-Encryption-Java.git

### Open project
Open the project in IntelliJ IDEA or any IDE with Maven support.

### Run application
Run:
Main.java

---

## How DES Works

DES (Data Encryption Standard) is a symmetric block cipher that processes 64-bit blocks using a 56-bit key.

The encryption process includes:
- Initial permutation
- Splitting data into left and right halves
- 16 Feistel rounds:
  - Expansion
  - XOR with round key
  - S-box substitution
  - Permutation
- Final permutation

---

## Important Note

DES is an outdated encryption standard and is not secure for modern applications.  
This project is for educational purposes only.
