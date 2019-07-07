package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.*
import java.util.*

fun User.toUserView(): UserView {
    val nickname = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null) "Not " else if (isOnline) "online" else "Last time was ${lastVisit.humanizeDiff()}"

    return UserView(id, fullName = "", avatar = avatar, nickName = nickname, initials = initials!!, status = status)
}

public fun Date.humanizeDiff(): String {
    val diff = (Date().getTime() - this.getTime()) / 1000

    return when (diff) {
        in 0..1 -> "только что"
        in 1..45 -> "несколько секунд назад"
        in 45..75 -> "минуту назад"
        in 75..45 * 60 -> "${diff/60} минут назад"
        in 45 * 60..75 * 60 -> "час назад"
        in 75 * 60..22 * 3600 -> "${diff/3600} часов назад"
        in 22 * 3600..26 * 3600 -> "день назад"
        in 26 * 3600..360 * 24 * 3600 -> "${diff/3600/24} дней назад"
        //>360д
        else -> "более года назад"
        //else -> "unk"
    }
}