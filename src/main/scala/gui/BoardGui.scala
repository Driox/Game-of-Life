package gui

import domain._
import org.scalajs.dom.CanvasRenderingContext2D

class BoardGui(
    val canvas:     CanvasRenderingContext2D,
    val background: Background,
    val resolution: Int
) {

  def render(board: Board) = {
    renderBackground()

    val cell_color = Color(0, 0, 0)
    board.cells.map(_.map(cell => renderCell(cell, cell_color)))
  }

  def renderBackground() = {
    canvas.fillStyle = background.color.toCss()
    canvas.fillRect(background.origin_x, background.origin_y, background.width, background.height)
  }

  def renderCell(cell: Cell, color: Color) = {
    if (cell.is_alive) {
      canvas.fillStyle = color.toCss()
      canvas.fillRect(cell.x * resolution, cell.y * resolution, resolution, resolution)
    }
  }
}

object BoardGui {
  def apply(canvas: CanvasRenderingContext2D, background: Background, resolution: Int = 1): BoardGui = new BoardGui(canvas, background, resolution)
}
