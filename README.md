# Minesweeper

A simple implementation of the classic Minesweeper game in Java. This project is a Swing/AWT desktop game (with local accounts, a personal page and a ranking board) that allows users to play Minesweeper by uncovering cells on a grid, avoiding hidden mines, and trying to clear the board.

## Features
- **Customizable grid size**: The game allows you to set different grid sizes.
- **Random mine placement**: Mines are randomly placed at the start of each game.
- **Recursive cell reveal**: Uncovering an empty cell reveals all adjacent empty cells until non-empty cells are found.
- **Game status**: The game keeps track of whether you've won or lost.
- **Flagging mines**: You can mark cells where you suspect mines are located.

## How to Play
- **Objective**: Uncover all cells that are not mines. If you uncover a mine, you lose the game.
- The number on a revealed cell shows how many mines are adjacent to that cell.
- Use flags to mark cells you suspect contain mines.
- Win by uncovering all non-mine cells or lose if you uncover a mine.

## Requirements
- JDK 8 or higher

## Running the Project
1. Clone the repository:
    ```bash
    git clone https://github.com/LEE-Kyungjae/Minesweeper.git
    ```
2. Navigate to the project directory:
    ```bash
    cd Minesweeper
    ```
3. Compile the Java files (sources are UTF-8):
    ```bash
    javac -encoding UTF-8 -d bin src/game/*.java
    ```
4. Run the game from the project root (it loads `img/`, `user/` and `rank/` relative to the working directory):
    ```bash
    java -cp bin game.Main
    ```

## Project Structure
All sources live in the `game` package under `src/game/`:
- **Main.java**: Entry point; opens the login window.
- **LoginPage.java / CreateAccountPage.java**: Log-in and sign-up windows.
- **MenuPage.java / MyPage.java / RankPage.java**: Main menu, personal page and ranking board.
- **GamePage.java**: The Minesweeper board (mine placement, reveal, flags, win/lose).
- **Save.java / Load.java / UserInfo.java / UserRank.java**: Serialize accounts to `user/<id>.sav` and rankings to `rank/rank.sav`.
- **Timer1.java / ResetThread.java / Token.java / HintTextField.java**: Game timer, board reset, login session token and a text field with placeholder text.

## Contributing
If you find any bugs or want to add new features, feel free to open an issue or submit a pull request.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

## Author
- GitHub: [LEE-Kyungjae](https://github.com/LEE-Kyungjae)
