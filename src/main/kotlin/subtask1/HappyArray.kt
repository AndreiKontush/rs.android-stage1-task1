package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val sadList = sadArray.toMutableList()
        do {
            var isSadFound = false
            for(i in 1..sadList.size - 2) {
                if (sadList[i] > sadList[i - 1] + sadList[i + 1]) {
                    sadList.removeAt(i)
                    isSadFound = true
                    break
                }
            }
        } while (isSadFound)
        return sadList.toIntArray()
    }
}
