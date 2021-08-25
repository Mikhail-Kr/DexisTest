package models;

public class CheckGroup1 implements CheckerGroups{
  /**
   * @param point точка с координатами x, y
   * @return Boolean
   */
  @Override
  public boolean check(Point point) {
    return point.x <= point.y;
  }

  /**
   * @return String
   */
  @Override
  public String groupMember() {
    return "Принадлежит группе 1";
  }
}
