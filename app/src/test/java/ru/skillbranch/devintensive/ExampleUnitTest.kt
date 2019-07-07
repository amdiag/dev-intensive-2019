package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.Utils
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

//    @Test
//    fun test_instance() {
//        val user = User("1")
//        val user2 = User("2", "John", "Wick")
//        val user3 = User("3", "John", "Silverhand", avatar = null)
//
//        //    user.printMe()
//        //    user2.printMe()
//        //    user3.printMe()
//
//        //println(" $user $user2 $user3")
//    }
//
//    @Test
//    fun test_factory() {
//        // val user = User.makeUser("John Cena")
//        //val user2 = User.makeUser("John Wick")
//        val user3 = User.makeUser("John Silverhand")
//        val user4 = user3.copy(id = "6", lastName = "user4")
//        print(user4)
//    }
//
//    @Test
//    fun test_decomposition() {
//        val user = User.makeUser("John Wick3")
//        fun getUserInfo() = user
//        val (id, firstName, lastName) = getUserInfo()
//        println("$id, $firstName, $lastName")
//        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
//    }
//
//    @Test
//    fun test_copy() {
//        val user = User.makeUser("John Wick")
//        var user2 = user.copy(lastVisit = Date())
//        //var user3 = user.copy(lastName = "Cena", lastVisit = Date().add(2, "hour"))
//        // var user4 = user.copy(lastName = "1234", lastVisit = Date().add(-2, "seconds"))
//
////        if (user.equals(user2)) {
////            println("equals data and hash \n ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
////        } else {
////            println("not equals ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
////        }
////
////        user2 = user
////
////        if (user === user2) {
////            println("equals adress \n ${System.identityHashCode(user)} $user \n ${System.identityHashCode(user2)} $user2")
////        } else {
////            println("not equals adress \n ${System.identityHashCode(user)} $user \n ${System.identityHashCode(user2)} $user2")
////        }
//
//        /*   println("""
//               ${user.lastVisit?.format()}
//               ${user2.lastVisit?.format()}
//               ${user3.lastVisit?.format()}
//               ${user4.lastVisit?.format()}
//           """.trimIndent())*/
//
//    }

//    @Test
//    fun test_dataq_mapping() {
//        val user = User.makeUser("fgf fgfg")
//        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))
//        println(user)
//
//
//        val userView = newUser.toUserView()
//
//        userView.printMe()
//    }

//    @Test
//    fun test_abstract_factory() {
//        val user = User.makeUser("123 123")
//        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
//        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image message", type = "image")
////        when (txtMessage) {
////            is BaseMessage -> println("this is base message")
////            is TextMessage -> println("this is text message")
////            is ImageMessage -> println("this is image message")
////        }
//
//        println(txtMessage.formatMessage())
//        println(imgMessage.formatMessage())
//    }

    @Test
    fun test_parse_full_name() {
        val name = Utils.parseFullName("123")
        println(name)
    }

    @Test
    fun test_date_format() {
        val date = Date().format("HH:mm")
        println(date)
    }

    @Test
    fun test_utils_to_initials() {
        val answer = Utils.toInitials("Jo", "fd")
        println(answer)
    }

    @Test
    fun test_utils_transliteration() {
        val answer = Utils.transliteration("вкпкпекпи апааа", "-")
        println(answer)
    }

    @Test
    fun test_humanize_diff() {
//        val answer = Date().add(-2, TimeUnits.HOUR).humanizeDiff() //2 часа назад
        val diff = -3
        val unit = TimeUnits.MINUTE
        val answer = Date().add(diff, unit).humanizeDiff() //2 часа назад
        println("${diff}, ${unit}")
        println(answer)
    }

    @Test
    fun test_builder() {
        val answer = User.Builder().id("123")
                .firstName("wer")
                .lastName("wer")
                .avatar("wer")
                .rating(3)
                .respect(3)
                .lastVisit(Date())
                .isOnline(true)
                .build()

        println(answer.javaClass)
    }
    
    @Test
    fun test_truncate(){
//        val answer = "N    ".truncate()
//        val answer = "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес".truncate()
        val answer = "Bender Bending Ro".truncate()
        println("\"${answer}\"")
    }
}