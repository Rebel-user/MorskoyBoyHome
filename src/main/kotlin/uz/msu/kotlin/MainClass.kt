package uz.msu.kotlin

fun main() {
    var ship = Ship(4)
    var cell = Cell(3,3)

    var shipMake:Boolean = ship.make(cell, SHIP_DIRECTION_EAST)

    println("cell $cell shipMake $shipMake")

    var shipStatus = ship.fire(Cell(3,3))
    println("Ship :: $shipStatus")
    shipStatus = ship.fire(Cell(4,3))
    println("Ship :: $shipStatus")
    shipStatus = ship.fire(Cell(5,3))
    println("Ship :: $shipStatus")
    shipStatus = ship.fire(Cell(6,3))
    println("Ship :: $shipStatus")
}