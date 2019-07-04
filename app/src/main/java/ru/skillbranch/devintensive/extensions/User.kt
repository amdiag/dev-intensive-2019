package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView

fun User.toUserView() : UserView{
    val nickname =
    val initials =
            val status = if(lastVisit == null) "Not " else if (isOnline) "online" else "Last time was ${}"

    return UserView(
            id,
            fullName = "",
            nickName = nickname,
            initials = initials,
            avatar = avatar,
            status = status)
    )
}