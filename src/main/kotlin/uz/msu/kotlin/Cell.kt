package uz.msu.kotlin

class Cell(var x: Int, var y: Int) {
    var status = CELL_STATUS_EMPTY
    override fun toString(): String {
        return "Cell(x=$x, y=$y, status='$status')"
    }

     fun ravno(other: Cell) = x == other.x && y == other.y


}