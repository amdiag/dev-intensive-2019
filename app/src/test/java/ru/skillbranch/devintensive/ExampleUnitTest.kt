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
    fun test_to_initials_2() {
        val initials1 = Utils.toInitials("john" ,"doe") //JD
        val initials2 = Utils.toInitials("John", null) //J
        val initials3 = Utils.toInitials(null, null) //null
        val initials4 = Utils.toInitials(" ", "") //null
        val initials5 = Utils.toInitials(" ", "dohn")
        val initials6 = Utils.toInitials(null, "john")

        println("${initials1} ${initials2} ${initials3} ${initials4} ${initials5} ${initials6}")

        assertEquals("JD", initials1)
        assertEquals("J", initials2)
        assertEquals(null, initials3)
        assertEquals(null, initials4)
        assertEquals(null, initials5)
        assertEquals(null, initials6)
    }

    @Test
    fun toInitialsTest_3(){
        /* skillBranch tests */
        assertEquals("JD", Utils.toInitials("john", "doe"))
        assertEquals("D", Utils.toInitials("Dohn", null))
        assertEquals(null, Utils.toInitials(null, null))
        assertEquals(null, Utils.toInitials(" ", ""))

        /* additional tests */
        assertEquals(null, Utils.toInitials(" ", null))
        assertEquals(null, Utils.toInitials(null, ""))
        assertEquals("T", Utils.toInitials(null, "  tommy"))
        assertEquals("ST", Utils.toInitials("  samuel  ", "  tommy"))
        assertEquals("J", Utils.toInitials(null, "John"))
    }

    @Test
    fun test_utils_transliteration() {
        val answer = Utils.transliteration("вкпкпекпи апааа", "-")
        println(answer)
    }

    @Test
    fun test_transliteration() {
        val trans1 = Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
        val trans2 = Utils.transliteration("Amazing Петр","_") //Amazing_Petr

        assertEquals("Zhenya Stereotipov", trans1)
        assertEquals("Amazing_Petr", trans2)
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
    fun test_humanizeDiff_2() {
        // ----- Past -----
        assertEquals("только что", Date().add(-1, TimeUnits.SECOND).humanizeDiff())
        assertEquals("несколько секунд назад", Date().add(-45, TimeUnits.SECOND).humanizeDiff())
        assertEquals("минуту назад", Date().add(-46, TimeUnits.SECOND).humanizeDiff())
        assertEquals("1 минуту назад", Date().add(-76, TimeUnits.SECOND).humanizeDiff())
        assertEquals("минуту назад", Date().add(-1, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("2 минуты назад", Date().add(-2, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("3 минуты назад", Date().add(-3, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("45 минут назад", Date().add(-45, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("час назад", Date().add(-1, TimeUnits.HOUR).humanizeDiff())
        assertEquals("1 час назад", Date().add(-76, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("2 часа назад", Date().add(-120, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("3 часа назад", Date().add(-3, TimeUnits.HOUR).humanizeDiff())
        assertEquals("4 часа назад", Date().add(-4, TimeUnits.HOUR).humanizeDiff())
        assertEquals("5 часов назад", Date().add(-5, TimeUnits.HOUR).humanizeDiff())
        assertEquals("день назад", Date().add(-26, TimeUnits.HOUR).humanizeDiff())
        assertEquals("1 день назад", Date().add(-27, TimeUnits.HOUR).humanizeDiff())
        assertEquals("4 дня назад", Date().add(-4, TimeUnits.DAY).humanizeDiff())
        assertEquals("5 дней назад", Date().add(-5, TimeUnits.DAY).humanizeDiff())
        assertEquals("360 дней назад", Date().add(-360, TimeUnits.DAY).humanizeDiff())
        assertEquals("более года назад", Date().add(-361, TimeUnits.DAY).humanizeDiff())

        // ----- Future ------
        assertEquals("через несколько секунд", Date().add(2, TimeUnits.SECOND).humanizeDiff())
        assertEquals("через минуту", Date().add(1, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("через 2 минуты", Date().add(2, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("через 3 минуты", Date().add(3, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("через 5 минут", Date().add(5, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("через час", Date().add(1, TimeUnits.HOUR).humanizeDiff())
        assertEquals("через 2 часа", Date().add(2, TimeUnits.HOUR).humanizeDiff())
        assertEquals("через 3 часа", Date().add(3, TimeUnits.HOUR).humanizeDiff())
        assertEquals("через 4 часа", Date().add(4, TimeUnits.HOUR).humanizeDiff())
        assertEquals("через 5 часов", Date().add(5, TimeUnits.HOUR).humanizeDiff())
        assertEquals("через день", Date().add(1, TimeUnits.DAY).humanizeDiff())
        assertEquals("через 4 дня", Date().add(4, TimeUnits.DAY).humanizeDiff())
        assertEquals("через 5 дней", Date().add(5, TimeUnits.DAY).humanizeDiff())
        assertEquals("через 148 дней", Date().add(148, TimeUnits.DAY).humanizeDiff())
        assertEquals("более чем через год", Date().add(400, TimeUnits.DAY).humanizeDiff())
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