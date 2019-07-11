package domain

case class Background(
    width:    Int,
    height:   Int,
    color:    Color,
    origin_x: Int   = 0,
    origin_y: Int   = 0
)
