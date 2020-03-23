package subtask3

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val haveToPay = (bill.sum() - bill[k]) / 2
        return if (haveToPay == b) "Bon Appetit"
        else (b - haveToPay).toString()
    }
}
