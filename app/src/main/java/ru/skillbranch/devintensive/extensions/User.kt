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
    //ToDo: not implemented
    return ""
}

