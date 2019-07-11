package example
import domain._
import engine.Runner
import gui.BoardGui

import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.html

@JSExport
object ScalaJSExample {
  @JSExport
  def main(canvas: html.Canvas): Unit = {
    val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

    val size = 400
    val background = Background(
      size,
      size,
      Color(255, 255, 180)
    )

    var current_board = InitialBoard.simple(400)
    val gui = BoardGui(ctx, background, 8)

    def run = {
      current_board = Runner.next(current_board)
      gui.render(current_board)
    }

    dom.window.setInterval(() => run, 500)
  }
}
