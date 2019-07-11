package domain

case class Board(cells: Array[Array[Cell]]) {
  def update(cell: Cell) = {
    val new_cells = cells.clone()
    new_cells(cell.x)(cell.y) = cell
    Board(new_cells)
  }

  def width(): Int = cells.size
  def height(): Int = if (cells.size > 0) cells(0).size else 0

  def transform(f: Cell => Cell) = Board(cells.map(_.map(cell => f(cell))))

  def cell(x_index: Int)(y_index: Int): Cell = (x_index, y_index) match {
    case (x, y) if (x < 0 || y < 0)                => Cell(-1, 1, false)
    case (x, y) if (x >= width() || y >= height()) => Cell(width() + 1, height() + 1, false)
    case (x, y)                                    => cells(x)(y)
  }
}
