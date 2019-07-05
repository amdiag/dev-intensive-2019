package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        // ToDo Fix me
        var parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(index = 1)
        return Pair(firstName, lastName)
    }

    fun transliteration(payload: String, divider: String = " "): String {
        // ToDo: not implemented
        return ""
    }

    fun toInitials(firstName: String?, lastName: String?): String {
        // ToDo: not implemented
        return ""
    }
}