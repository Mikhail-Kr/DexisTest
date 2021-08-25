package models;

public class CheckGroup2 implements CheckerGroups{
  /**
   * @param point точка с координатами x, y
   * @return Boolean
   */
  @Override
  public boolean check(Point point) {
    return Math.pow(point.x, 2) <= point.y;
  }

  /**
   * @return String
   */
  @Override
  public String groupMember() {
    return "Принадлежит группе 2";
  }
}