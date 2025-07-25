# 🎮 Rock Paper Scissors

A simple Rock Paper Scissors (RPS) game built using Java. Play against the computer in the terminal and track your score!

![Java](https://img.shields.io/badge/Language-Java-blue.svg)
![Beginner Project](https://img.shields.io/badge/Level-Beginner-brightgreen)
![Console Game](https://img.shields.io/badge/Type-Console--App-lightgrey)
---

## 📌 Features

- Classic Rock 🪨, Paper 📄, Scissors ✂️ gameplay
- Randomized computer move logic
- Input validation and helpful user prompts
- Round number counter
- Color coded win and loss messages to help the user identify
- Custom messages for wins and losses and in between choosing times
- Streak tracker of wins, losses, draws
- Running score tracking:
    - 🕹️ Games Played
    - ✅ Wins
    - ❌ Losses
    - 🤝 Draws
- Replay support — play as many times as you'd like!

---

## 🚀 Getting Started

### 📦 Requirements

- Java 8 or above
- Any terminal or command line interface

### 🛠️ How to Run
Download the jar file from the releases section
```bash
java -jar rps-game.jar
```
Try it on [Replit](https://replit.com/@yago-xd/rps-game)

---

## 🎲 How to Play

1. Run the game.
2. Enter your move: `rock`, `paper`, or `scissors`.
3. The computer randomly chooses its move.
4. The winner is displayed along with the updated score.
5. At the end of each round, choose whether to replay.

---

## 📜 Game Rules

- 🪨 Rock beats ✂️ Scissors
- 📄 Paper beats 🪨 Rock
- ✂️ Scissors beats 📄 Paper
- Same moves = 🤝 Draw

---

## 📊 Demo

```console
Welcome to the Rock Paper Scissors Game!
Type exit anytime to end the game
------------------------------
Round: 1

Enter your choice (rock, paper, scissors): paper
I wonder if you’re trying to trick me.
You chose: paper
Computer chose: rock

You Win!
Flawless win! 😎

Score: User - 1 | Computer - 0
Games Played: 1
Win %: 100.0%
Loss %: 0.0%
Draw %: 0.0%

------------------------------
Do you wish to play again? (Y/N): n
Thank you for playing!
```

---

## 🧠 Ideas for Future Improvements

- Best-of-N match system
- Basic GUI with buttons
- Pattern-detecting AI opponent
- Score leaderboard with save feature

---

## 🔧 Tools Used

- Java 17 (or Java 8+)
- IntelliJ IDEA (recommended)
- Git + GitHub

---

> 💡 This project was built as part of learning Object-Oriented Programming and core Java concepts.