import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Map {

    int[][] boardMatrix = new int[boardSize][boardSize];
    String mapFile = "maps/map0" + (int)(Math.random() * 2 + 1) + ".txt";

    public Map(Graphics graphics) {
        boardSetUp(mapFile);
        boardDraw(graphics);
    }

    public void boardSetUp(String mapFile) {
        Path mapPath = Paths.get(mapFile);
        List<String> fileContent = new ArrayList<String>();
        try {
            fileContent = Files.readAllLines(mapPath);
        } catch (IOException e) {
            System.out.println("This map isn't a map. I can't read.");
        }
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                boardMatrix[i][j] = (int)fileContent.get(i).charAt(j) - 48;
            }
        }
    }

    public void boardDraw(Graphics graphics) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (boardMatrix[i][j] == 1) {
                    PositionedImage imgFloor = new PositionedImage(
                            "wanderer-java/img/floor.png", i * 72, j * 72);
                    imgFloor.draw(graphics);
                } else {
                    PositionedImage imgWall = new PositionedImage(
                            "wanderer-java/img/wall.png", i * 72, j * 72);
                    imgWall.draw(graphics);
                }
            }
            System.out.println();
        }
    }
}