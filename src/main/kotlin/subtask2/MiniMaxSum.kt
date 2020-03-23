package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {
        val sum = input.sum()
        val min = sum - input.max()!!
        val max = sum - input.min()!!
        return intArrayOf(min, max)
    }
}
