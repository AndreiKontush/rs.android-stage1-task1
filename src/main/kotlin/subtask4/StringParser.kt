package subtask4

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val outList = mutableListOf<String>()
        for ((index, char) in inputString.withIndex()) {
            if (char == '[' || char == '<' || char == '(') {
                val interimString = inputString.substring(index)
                val opening: Char
                val closing: Char

                when (char) {
                    '[' -> {
                        opening = '['
                        closing = ']'
                    }
                    '<' -> {
                        opening = '<'
                        closing = '>'
                    }
                    '(' -> {
                        opening = '('
                        closing = ')'
                    }
                    else -> {
                        opening = '{'
                        closing = '}'
                    }
                }

                var nestingCount = 0
                for((i, c) in interimString.withIndex()) {
                    if (c == opening) {
                        nestingCount++
                    } else if (c == closing) {
                        nestingCount--
                        if (nestingCount < 1) {
                            outList.add(interimString.substring(1, i))
                            break
                        }
                    }
                }
            }
        }
        return outList.toTypedArray()
    }
}
