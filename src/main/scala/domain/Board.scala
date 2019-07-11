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

object InitialBoard {

  def empty(width: Int, height: Int): Board = Board(Array.tabulate(width, height)((x, y) => Cell(x, y, false)))
  def empty(size: Int): Board = empty(size, size)

  def simple(size: Int): Board =
    empty(size)
      .update(Cell(19, 20, true))
      .update(Cell(20, 20, true))
      .update(Cell(21, 20, true))

  def cannon(size: Int): Board =
    empty(620, 188)
      .update(Cell(2, 6, true))
      .update(Cell(2, 7, true))
      .update(Cell(3, 6, true))
      .update(Cell(3, 7, true))

      .update(Cell(12, 6, true))
      .update(Cell(12, 7, true))
      .update(Cell(12, 8, true))

      .update(Cell(13, 5, true))
      .update(Cell(13, 9, true))

      .update(Cell(14, 4, true))
      .update(Cell(14, 10, true))

      .update(Cell(15, 4, true))
      .update(Cell(15, 10, true))

      .update(Cell(16, 7, true))

      .update(Cell(17, 5, true))
      .update(Cell(17, 9, true))

      .update(Cell(18, 6, true))
      .update(Cell(18, 7, true))
      .update(Cell(18, 8, true))

      .update(Cell(19, 7, true))

      .update(Cell(22, 4, true))
      .update(Cell(22, 5, true))
      .update(Cell(22, 6, true))

      .update(Cell(23, 4, true))
      .update(Cell(23, 5, true))
      .update(Cell(23, 6, true))

      .update(Cell(24, 3, true))
      .update(Cell(24, 7, true))

      .update(Cell(26, 2, true))
      .update(Cell(26, 3, true))
      .update(Cell(26, 7, true))
      .update(Cell(26, 8, true))

      .update(Cell(36, 4, true))
      .update(Cell(36, 5, true))
      .update(Cell(37, 4, true))
      .update(Cell(37, 5, true))
}
