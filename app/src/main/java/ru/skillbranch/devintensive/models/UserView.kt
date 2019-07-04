package ru.skillbranch.devintensive.models

class UserView(
        val id: String,
        val fullName: String,
        val nickName: String,
        val initials: String,
        val avatar: String?,
        val status: String
) {
    fun printMe() {
        println("""
            id: $id
            fullName: $fullName
            nickName: $nickName
            initials: $initials
            avatar: $avatar
            status  : $status
        """.trimIndent())
    }
}