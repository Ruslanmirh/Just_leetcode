package utils

fun IntArray.asString(): String {
    val stringBuilder = StringBuilder()
    forEachIndexed { index, value ->
        if (index == 0) {
            stringBuilder.append("( ")
        }
        stringBuilder.append(value)
        if (index == lastIndex) {
            stringBuilder.append(" )")
        } else {
            stringBuilder.append(", ")
        }
    }
    return stringBuilder.toString()
}