package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        if (fullName?.trim().isNullOrEmpty())
            return null to null

        var parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(index = 1)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        // ToDo use buildString()
        var translitString = ""
        for (char in payload) {
            translitString += when (char) {
                'а' -> 'a'
                'б' -> 'b'
                'в' -> 'v'
                'г' -> 'g'
                'д' -> 'd'
                'е' -> 'e'
                'ё' -> 'e'
                'ж' -> "zh"
                'з' -> 'z'
                'и' -> 'i'
                'й' -> 'i'
                'к' -> 'k'
                'л' -> 'l'
                'м' -> 'm'
                'н' -> 'n'
                'о' -> 'o'
                'п' -> 'p'
                'р' -> 'r'
                'с' -> 's'
                'т' -> 't'
                'у' -> 'u'
                'ф' -> 'f'
                'х' -> 'h'
                'ц' -> 'c'
                'ч' -> "ch"
                'ш' -> "sh"
                'щ' -> "sh'"
                'ъ' -> ""
                'ы' -> 'i'
                'ь' -> ""
                'э' -> 'e'
                'ю' -> "yu"
                'я' -> "ya"
                else -> divider
            }
        }

        return translitString
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        if (firstName?.trim().isNullOrBlank() and lastName?.trim().isNullOrBlank()) {
            return null
        }

        if (lastName != null) {
            return """${firstName?.get(0).toString().toUpperCase()}${lastName.get(0).toString().toUpperCase()}"""
        } else
            return "${firstName?.get(0).toString().toUpperCase()}"
    }
}