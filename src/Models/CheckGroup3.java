package Models;

public class CheckGroup3 implements CheckerGroups{
  /**
   * @param point точка с координатами x, y
   * @return Boolean
   */
  @Override
  public boolean check(Point point) {
    return Math.pow(point.x, 3) <= point.y;
  }

  /**
   * @return String
   */
  @Override
  public String groupMember() {
    return "Принадлежит группе 3";
  }
}