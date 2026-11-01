<div align="center">
  
# 🎵 Smart Music Playlist Manager

**A Console-Based Data Structures Microproject**

[![Java Version](https://img.shields.io/badge/Java-8%2B-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![Data Structure](https://img.shields.io/badge/Core_DS-Doubly_Linked_List-06b6d4?style=for-the-badge)](https://en.wikipedia.org/wiki/Doubly_linked_list)
[![Architecture](https://img.shields.io/badge/Architecture-Console_CLI-8b5cf6?style=for-the-badge&logo=gnometerminal)](https://github.com/)
[![Build Status](https://img.shields.io/badge/Build-Passing-1db954?style=for-the-badge)](#)

*An interactive, memory-efficient music queue manager built from scratch without relying on built-in Java Collection libraries.*

---

</div>

## 📑 Table of Contents
- [About the Project](#-about-the-project)
- [System Architecture](#-system-architecture--under-the-hood)
- [Key Features](#-key-features)
- [Complexity Analysis](#-complexity-analysis)
- [Testing & Edge Cases](#-testing--edge-cases)
- [Getting Started](#-getting-started)
- [Project Structure](#-project-structure)

---

## 📖 About the Project

This application was developed as a **Data Structures Microproject**. It simulates a modern music playlist engine (like Spotify or Apple Music) using a custom **Doubly Linked List**. 

The primary objective is to demonstrate raw memory management, pointer manipulation, and algorithm design by manually handling `head`, `tail`, and `current` node pointers. 

> **⚠️ Academic Integrity Note:** This project implements its own `SongNode` and `PlaylistLinkedList` classes. The standard `java.util.LinkedList` is explicitly **avoided** to satisfy project requirements.

---

## 🏗 System Architecture & Under the Hood

### The Doubly Linked List Model
Unlike an Array, a Doubly Linked List allows us to navigate forwards and backwards through the playlist in constant $O(1)$ time without shifting elements in memory.

```text
       HEAD                                                    TAIL
      [ Node ] <========> [ Node ] <========> [ Node ] <========> [ Node ]
NULL ⟸ [Prev | Next]      [Prev | Next]      [Prev | Next]      [Prev | Next] ⟹ NULL
                      ↑
                   CURRENT (Playing)
```

### The "Recently Played" Stack
Whenever a song is played, a pointer to that node is pushed onto a fixed-capacity (size 5) Array-based **Stack**. This allows users to view their listening history in LIFO (Last-In-First-Out) order.

---

## ✨ Key Features

*   **Dynamic Memory Allocation:** Add or remove songs seamlessly without pre-defining a maximum playlist size.
*   **Bi-Directional Playback:** Instantly jump to the `Next` or `Previous` track using bidirectional memory pointers.
*   **Fast Deletions:** Remove a song from the Head, Tail, or Middle of the playlist with secure pointer re-linking to prevent memory leaks.
*   **Favorites System:** Toggle tracks as favorites ($\star$) and filter to display only your top tracks.
*   **Robust Input Validation:** Built-in error handling via `try-catch` blocks to prevent crashes from invalid user inputs (e.g., typing letters instead of IDs).

---

## 📊 Complexity Analysis

| Operation | Best Case | Worst Case | Space Complexity | Justification |
| :--- | :---: | :---: | :---: | :--- |
| **Add Song (Tail)** | $O(1)$ | $O(1)$ | $O(1)$ | Direct insertion using the `tail` pointer. |
| **Play Next/Prev** | $O(1)$ | $O(1)$ | $O(1)$ | Instant traversal using `current.next` or `current.prev`. |
| **Search by Title** | $O(1)$ | $O(N)$ | $O(1)$ | Requires sequential traversal from the `head` node. |
| **Delete Song** | $O(1)$ | $O(N)$ | $O(1)$ | $O(N)$ to locate the node, but exactly $O(1)$ to re-link adjacent pointers. |

---

## 🧪 Testing & Edge Cases

The system has been rigorously tested against standard Data Structure boundary conditions:

1.  **Empty Structure:** Attempting to play or delete from an empty list gracefully returns an error message.
2.  **Single Element Deletion:** Deleting the only song correctly resets `head`, `tail`, and `current` to `null`.
3.  **Missing Key:** Searching for a non-existent Song ID is handled securely.
4.  **Middle Node Deletion:** Correctly bridges the `prev` and `next` nodes around the deleted target.
5.  **End of List Bounds:** Pressing "Next" on the `tail` node correctly identifies the end of the list without throwing a `NullPointerException`.

---

## 🚀 Getting Started

### Prerequisites
*   **Java Development Kit (JDK):** Version 8 or higher.
*   **Terminal/Command Prompt:** Basic CLI access.

### Installation & Execution

1. **Clone the repository:**
   
```bash
   git clone https://github.com/2025balkrishnakumbhar-tech/MusicPlaylistManager.git
   cd MusicPlaylistManager
```

2. **Compile the source code:**
   
```bash
   javac *.java
```

3. **Run the application:**
   
```bash
   java PlaylistManagerApp
```

---

## 📁 Project Structure

```text
MusicPlaylistManager/
│
├── SongNode.java              # Node definition (Data + Pointers)
├── PlaylistLinkedList.java    # Custom DLL implementation & algorithms
├── PlaylistManagerApp.java    # Main driver, CLI UI, & input loop
└── README.md                  # Project documentation
```

<div align="center">
  <br>
  <i>Developed with ❤️ for Data Structures and Algorithms coursework.</i>
</div>
