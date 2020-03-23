package subtask5

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val a = CharArray(n)
        for ((i, c) in digitString.withIndex()) {
            a[i] = c
        }

        val half = n / 2
        var minSteps = 0
        for (i in 0 until half) {
            if (a[i] != a[n - 1 - i]) {
                minSteps++
            }
        }
        if (minSteps > k) return "-1"

        for (i in 0 until half) {
            val r = n - 1 - i
            if (a[i] != a[r]) {
                if (a[i] > a[r]) {
                    a[r] = a[i]
                } else {
                    a[i] = a[r]
                }
            }
        }

        var stepsLeft = k - minSteps
        var i = 0
        while (stepsLeft > 0 && i < half) {
            val r = n - 1 - i
            if (areDiverseDigitsNotNines(i, r, digitString)) {
                a[i] = '9'
                a[r] = '9'
                stepsLeft--
            } else if (areEqualDigitsNotNines(i, r, digitString) && stepsLeft > 1) {
                a[i] = '9'
                a[r] = '9'
                stepsLeft -= 2
            }
            i++
        }

        if (n % 2 != 0 && stepsLeft > 0) a[half] = '9'

        return String(a)
    }

    private fun areEqualDigitsNotNines(i: Int, r: Int, digitString: String): Boolean {
        return (digitString[i] == digitString[r]) && (digitString[i] != '9')
    }

    private fun areDiverseDigitsNotNines(i: Int, r: Int, digitString: String): Boolean {
        return (digitString[i] != digitString[r]) && (digitString[i] != '9') && (digitString[r] != '9')
    }
}
