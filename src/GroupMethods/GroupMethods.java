package GroupMethods;

import Models.CheckerGroups;
import Models.Group;
import Models.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupMethods {
  private final Group[] groups;
  private final List<Point> noGroup;


  public GroupMethods(CheckerGroups[] checkerGroups) {
    this.groups = Arrays.stream(checkerGroups).map(Group::new).toArray(Group[]::new);
    this.noGroup = new ArrayList<>();
  }

  public void add(Point[] points) {
    for (Point point : points) {
      boolean wasAdded = false;
      for (Group group : groups) {
        wasAdded = group.add(point) || wasAdded;
      }
      if (!wasAdded) {
        noGroup.add(point);
      }
    }
  }

  public List<Group> getGroups() {
    return Arrays.asList(groups.clone());
  }

  public List<Group> getGroups(int[] groupNums) {
    List<Group> result = new ArrayList<>();
    for (int groupNum : groupNums) {
      assertGroupNum(groupNum);
      result.add(groups[groupNum - 1]);
    }
    return result;
  }

  public List<Point> getNoGroup() {
    return noGroup;
  }

  public void remove(int[] groupNums) {
    for (int groupNum : groupNums) {
      assertGroupNum(groupNum);
      groups[groupNum - 1].clear();
    }
  }

  public void clear() {
    for (Group group : groups) {
      group.clear();
    }
  }

  private void assertGroupNum(int groupNum) {
    if (1 <= groupNum && groupNum <= groups.length) {
      return;
    }

    throw new RuntimeException("Нет группы с номером " + groupNum + ". Введите число от 1 до " + groups.length);
  }
}
