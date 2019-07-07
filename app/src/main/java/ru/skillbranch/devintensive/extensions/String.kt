package ru.skillbranch.devintensive.extensions

import java.util.*

public fun String.truncate(numDelimit: Int = 16): String {
    if (this.length <= numDelimit)
        return this.trimEnd()
    else
        return "${this.subSequence(0, numDelimit).trimEnd().toString()}..."
}