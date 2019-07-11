package engine

import domain._

object Runner {

  def next(board: Board): Board = board.transform(compute_cell_is_alive(board))

  private[this] def compute_cell_is_alive(board: Board)(cell: Cell): Cell = {
    val x = cell.x
    val y = cell.y

    // format: OFF
    val surrounding: Array[Array[Cell]] = Array(
      Array(board.cell(x - 1)(y - 1), board.cell(x)(y - 1), board.cell(x + 1)(y - 1)),
      Array(board.cell(x - 1)(y),                            board.cell(x + 1)(y)),
      Array(board.cell(x - 1)(y + 1), board.cell(x)(y + 1), board.cell(x + 1)(y + 1))
    )
    // format : ON

    val nb_alive = surrounding.flatten.count(_.is_alive)

    /**
     * Une cellule morte possédant exactement trois voisines vivantes devient vivante (elle naît).
     * Une cellule vivante possédant deux ou trois voisines vivantes le reste, sinon elle meurt.
     */
    val result = (cell.is_alive, nb_alive) match {
      case (true, x) if (x == 2 || x == 3) => cell
      case (true, _)                       => cell.copy(is_alive = false)
      case (false, x) if (x == 3)          => cell.copy(is_alive = true)
      case _                               => cell
    }
    result
  }
}
