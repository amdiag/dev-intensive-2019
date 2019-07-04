package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.models.User
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user = User("1")
        val user2 = User("2", "John", "Wick")
        val user3 = User("3", "John", "Silverhand", avatar = null)

        //    user.printMe()
        //    user2.printMe()
        //    user3.printMe()

        //println(" $user $user2 $user3")
    }

    @Test
    fun test_factory() {
        // val user = User.makeUser("John Cena")
        //val user2 = User.makeUser("John Wick")
        val user3 = User.makeUser("John Silverhand")
        val user4 = user3.copy(id = "6", lastName = "user4")
        print(user4)
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick3")
        fun getUserInfo() = user
        val (id, firstName, lastName) = getUserInfo()
        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastName = "Cena", lastVisit = Date().add(2, "hour"))
        var user4 = user.copy(lastName = "1234", lastVisit = Date().add(-2, "seconds"))

//        if (user.equals(user2)) {
//            println("equals data and hash \n ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
//        } else {
//            println("not equals ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
//        }
//
//        user2 = user
//
//        if (user === user2) {
//            println("equals adress \n ${System.identityHashCode(user)} $user \n ${System.identityHashCode(user2)} $user2")
//        } else {
//            println("not equals adress \n ${System.identityHashCode(user)} $user \n ${System.identityHashCode(user2)} $user2")
//        }

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent())

    }
}
