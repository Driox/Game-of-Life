package domain

case class Color(
    red:   Int,
    green: Int,
    blue:  Int
) {
  def toCss(): String = s"rgb(${red}, ${green}, ${blue})"
}
