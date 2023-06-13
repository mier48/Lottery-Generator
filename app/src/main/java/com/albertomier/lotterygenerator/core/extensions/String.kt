package com.albertomier.lotterygenerator.core.extensions

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

fun String.toBase64() = stringToBase64(this)

fun String.base64ToString() = toString(this)

fun String.formatDate() = toDateString(this)

fun String.hasContent() = checkHasContent(this)

fun checkHasContent(str: String): Boolean {
    return str.isNotEmpty() && str.isNotBlank()
}

//fun String.numberResponse() = toNumberResponse(this)

fun String.isNumeric() = checkIsNumeric(this)

fun String?.validate(value: String = ""): String {
    return this ?: value
}

fun String.log(debugKey: String = "Value"): Int {
    return Log.d(debugKey, this)
}

private fun stringToBase64(str: String): String {
    val encoder: Base64.Encoder = Base64.getEncoder()

    return encoder.encodeToString(str.toByteArray())
}

private fun toString(str: String): String {
    val decoder: Base64.Decoder = Base64.getDecoder()

    return String(decoder.decode(str))
}

private fun toDateString(str: String): String {
    val parser = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

    return try {
        formatter.format(parser.parse(str)!!)
    } catch (e: Exception) {
        str
    }
}

//private fun toNumberResponse(str: String): NumberResponse? {
//    return try {
//        val gson = Gson()
//        gson.fromJson(str, NumberResponse::class.java)
//    } catch (e: Exception) {
//        Log.e("AppConstants.TAG", e.message.toString())
//        null
//    }
//}

fun checkIsNumeric(str: String): Boolean {
    return str.toDoubleOrNull() != null
}
