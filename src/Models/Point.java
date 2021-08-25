package Models;


import java.util.Objects;

public class Point {
  final int x;
  final int y;

  /**
   * @param x координата точки х
   * @param y координата точки y
   */
  public Point (int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * @return String
   */
  @Override
  public String toString() {
    return "(" + x + "," + y + ")";
  }

  /**
   * @param o объект
   * @return Boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point point = (Point) o;
    return x == point.x && y == point.y;
  }

  /**
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
