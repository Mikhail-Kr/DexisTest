import groupMethods.GroupMethods;
import models.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    GroupMethods groupsManager = new GroupMethods(new CheckerGroups[]{
        new CheckGroup1(),
        new CheckGroup2(),
        new CheckGroup3()
    });
    ConsoleUI consoleUI = new ConsoleUI(groupsManager);

    Scanner in = new Scanner(System.in);
    String command = "";
    do {
      System.out.println("Введите команду");
      try {
        command = in.nextLine();
        String[] commandParts = command.split("( )+");
        String[] params = Arrays.copyOfRange(commandParts, 1, commandParts.length);

        switch (commandParts[0]) {
          case "add" -> groupsManager.add(parseAddingInput(params));
          case "print" -> consoleUI.print(Arrays.stream(params).mapToInt(Integer::parseInt).toArray());
          case "remove" -> groupsManager.remove(Arrays.stream(params).mapToInt(Integer::parseInt).toArray());
          case "clear" -> groupsManager.clear();
          case "help" -> consoleUI.help();
        }
      } catch (NumberFormatException e) {
        System.err.println("Неправильный тип параметров: ожидается целочисленное выражение");
      } catch (Exception e) {
        System.err.println(e.getMessage());
      }
    } while (!command.equals("exit"));
    in.close();
  }

  /**
   * @param pointInputs
   * @return Point[]
   */
  private static Point[] parseAddingInput(String[] pointInputs) {
    if (pointInputs.length % 2 != 0) {
      throw new RuntimeException("Неверный формат данных. \n Координаты передаются парами чисел через пробел, например, add 1 1 -2 -3 - добавит 2 точки: (1,1) и (-2,-3)");
    }

    Point[] points = new Point[pointInputs.length / 2];

    for (int i = 0; i < points.length; i++) {
      points[i] = new Point(Integer.parseInt(pointInputs[i * 2]), Integer.parseInt(pointInputs[i * 2 + 1]));
    }

    return points;
  }
}
