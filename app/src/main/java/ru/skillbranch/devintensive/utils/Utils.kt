package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        // TODO Сделать так чтобы эта функция возвращала ожидаемые значения

        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        when(firstName) {
            null, "", " " -> firstName = "null"
            else -> firstName
        } to when(lastName) {
            null, "", " " -> lastName ="null"
            else -> lastName
        }

        return Pair(firstName, lastName)
    }

    fun transliteration(payload: String, divider: String = " "): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun toInitials(firstName: String?, lastName: String?): String {

        val firstNameChar = firstName?.getOrNull(0)?.toUpperCase() ?: "null"
        val secondNameChar = lastName?.getOrNull(0)?.toUpperCase() ?: "null"

        return when {
            (firstName == "" || firstName == " " || firstName == "null") && (lastName == "" || lastName == " " || lastName == "null") -> "null"
            firstName == "null" -> "$secondNameChar"
            lastName == "null" -> "$firstNameChar"
            else -> "$firstNameChar$secondNameChar"
        }
    }
}