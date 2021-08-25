package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Group {
  private final List<Point> gPoints = new ArrayList<>();
  private final CheckerGroups checkerGroups;

  /**
   * @param checkerGroups
   */
  public Group(CheckerGroups checkerGroups) {
    this.checkerGroups = checkerGroups;
  }

  public void clear() {
    gPoints.clear();
  }

  /**
   * @param point
   * @return Boolean
   */
  public boolean add(Point point) {
    boolean isMember = checkerGroups.check(point);
    if (isMember) {
      gPoints.add(point);
    }
    return isMember;
  }

  /**
   * @return список точек
   */
  public List<Point> getPoints() {
    return gPoints;
  }

  /**
   * @return String
   */
  @Override
  public String toString() {
    if (gPoints.isEmpty()) {
      return checkerGroups.groupMember() + ": Группа пуста";
    }
    return checkerGroups.groupMember() + ": " + gPoints.stream().map(Point::toString).collect(Collectors.joining(", "));
  }
}
