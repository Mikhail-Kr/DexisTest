import groupMethods.GroupMethods;
import models.Group;
import models.Point;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ConsoleUI {
  private final GroupMethods groupsMethods;

  public ConsoleUI(GroupMethods groupsMethods) {
    this.groupsMethods = groupsMethods;
  }

  /**
   * @param groupNums
   */
  public void print(int[] groupNums) {
    if (groupNums.length == 0) {
      for (Group group : groupsMethods.getGroups()) {
        System.out.println(group.toString());
      }
      System.out.println("Количество точек без группы: " + groupsMethods.getNoGroup().size());
    } else {
      Set<Point> points = new HashSet<>();

      groupsMethods.getGroups(groupNums).forEach(group -> points.addAll(group.getPoints()));

      if (points.isEmpty()) {
        System.out.println("Группа(ы) пуста(ы)");
      } else {
        System.out.println(points.stream().map(Point::toString).collect(Collectors.joining(", ")));
      }
    }
  }

  public void help() {
    System.out.println(
        """
            add <point>        - добавить в память программы точки, координаты передаются парами чисел через пробел
                                 прим. add 1 1 -2 -3 //добавить 2 точки: (1,1) и (-2,-3)
            print              - напечатать построчно каждую из трех групп (входящие в них точки)
                                 если в группу не попадает ни одна точка, то вывести сообщение, что группа пуста
                                 последней строкой напечатать количество точек, не вошедших ни в одну группу
            print <group_num>  - напечатать одним списком точки, входящие в группу(ы) переданную(ые) параметром <group_num>
                                 прим. print 1 2
            remove <group_num> - удалить из памяти все точки, входящие в группу(ы) <group_num>
                                 прим. remove 2 3
            clear              - очистить память
            help               - вывод справки по командам"""
    );
  }
}
