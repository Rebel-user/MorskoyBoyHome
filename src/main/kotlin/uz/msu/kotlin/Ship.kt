package uz.msu.kotlin

class Ship(var size:Int) {
    private var cells = arrayListOf<Cell>()
    private var dx = 0
    private var dy = 0
    fun make(cell:Cell, direction:String): Boolean{

        checkDirection(direction)

        addCells(cell)

        var checkPerimetr:Boolean = checkPerimetr()

        if (!checkPerimetr)
            cells.clear()

        return checkPerimetr
    }

    private fun checkDirection(direction:String) {
        when (direction) {
            SHIP_DIRECTION_EAST -> dx = 1
            SHIP_DIRECTION_NORTH -> dy = 1
            SHIP_DIRECTION_SOUTH -> dy = -1
            SHIP_DIRECTION_WEST -> dx = -1
        }
    }

    private fun addCells(cell:Cell) {
        var cellInLoop = cell
        for (i in 1..size) {
            cells.add(cellInLoop)
            cellInLoop = Cell(cellInLoop.x + dx, cellInLoop.y + dy)
        }
    }

    private fun checkPerimetr():Boolean {
        for (cellINList in cells) {
            if (cellINList.x < BOARD_X_MIN
                || cellINList.x > BOARD_X_MAX
                || cellINList.y < BOARD_Y_MIN
                || cellINList.y > BOARD_Y_MAX)
                return false
        }
        return true
    }

    fun fire(cell: Cell): String {
        var firedCellCount = 0

        for(cellInList in cells) {
            if (cellInList.ravno(cell)) {
                cellInList.status = CELL_STATUS_FIRED
            }
            if (cellInList.status == CELL_STATUS_FIRED)
                firedCellCount++
        }
      return when (firedCellCount) {
          size -> SHIP_STATUS_DIED
          in 1..size -> SHIP_STATUS_FIRED
          else -> CELL_STATUS_MISSED
      }
    }
}

