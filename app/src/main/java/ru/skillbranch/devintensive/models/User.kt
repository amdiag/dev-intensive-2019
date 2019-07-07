package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

class User(//private val config: Builder
        val id: String,
        var firstName: String?,
        var lastName: String?,
        var avatar: String?,
        var rating: Int = 0,
        var respect: Int = 0,
        val lastVisit: Date? = Date(),
        val isOnline: Boolean = false
) {

    private constructor(builder: Builder) : this(builder.id, builder.firstName, builder.lastName, builder.avatar, builder.rating, builder.respect, builder.lastVisit, builder.isOnline)

    class Builder {
        var id: String = "-1"
            private set
        var firstName: String? = null
            private set
        var lastName: String? = null
            private set
        var avatar: String? = null
            private set
        var rating: Int = 0
            private set
        var respect: Int = 0
            private set
        var lastVisit: Date? = Date()
            private set
        var isOnline: Boolean = false
            private set


        fun id(id: String) = apply { this.id = id }
        fun firstName(firstName: String?) = apply { this.firstName = firstName }
        fun lastName(lastName: String?) = apply { this.lastName = lastName }
        fun avatar(avatar: String?) = apply { this.avatar = avatar }
        fun rating(rating: Int) = apply { this.rating = rating }
        fun respect(respect: Int) = apply { this.respect = respect }
        fun lastVisit(lastVisit: Date?) = apply { this.lastVisit = lastVisit }
        fun isOnline(isOnline: Boolean) = apply { this.isOnline = isOnline }
        fun build() = User(this)
    }

    constructor (id: String, firstName: String?, lastName: String?) : this(
            id = id,
            firstName = firstName,
            lastName = lastName,
            avatar = null
    )

//    constructor(id: String) : this(id, "John", "Doe $id")
//
//    init {
//        println("It's alive!!!${if (lastName === "Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName!!!"}")
//    }

    companion object Factory {
        private var lastId: Int = -1
        fun makeUser(fullName: String?): User {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }

//    companion object Builder {
//        protected var id: String = ""
//        protected var firstName: String? = ""
//        protected var lastName: String? = ""
//        protected var avatar: String? = ""
//        protected var rating: Int = 0
//        protected var respect: Int = 0
//        protected var lastVisit: Date? = Date()
//        protected var isOnline: Boolean = false
//
//
//        fun id(value: String) = apply { id = value }
//        fun firstName(value: String?) = apply { firstName = value }
//        fun lastName(value: String?) = apply { lastName = value }
//        fun avatar(value: String?) = apply { avatar = value }
//        fun rating(value: Int) = apply { rating = value }
//        fun respect(value: Int) = apply { respect = value }
//        fun lastVisit(value: Date?) = apply { lastVisit = value }
//        fun isOnline(value: Boolean) = apply { isOnline = value }
//
//        fun build(): User {
//            return User(this)
//        }
//    }
}