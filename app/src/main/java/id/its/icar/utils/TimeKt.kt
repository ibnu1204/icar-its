package id.its.icar.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


/**
 * Created by wahid on 7/8/2024.
 * Github github.com/wahidabd.
 */


val localeIndonesia = Locale("id", "ID")

fun generateTimeNow(): String{
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("dd-MM-yyyy", localeIndonesia)
    val formattedDate = dateFormat.format(calendar.time)
    val dayOfWeekFormatter = SimpleDateFormat("EEEE", Locale("id"))
    val dayOfWeek = dayOfWeekFormatter.format(calendar.time)

    return "$dayOfWeek, $formattedDate"
}

fun checkBeforeTime(checkTime: String): Boolean {
    val timeFormatter = SimpleDateFormat("HH:mm", Locale.getDefault())
    val specifiedTime = timeFormatter.parse(checkTime) ?: return false
    val currentTime = Calendar.getInstance().time
    val calendar = Calendar.getInstance().apply {
        time = specifiedTime
    }
    calendar.add(Calendar.MINUTE, -30)
    val timeBefore30Minutes = calendar.time
    return currentTime.after(timeBefore30Minutes) && currentTime.before(specifiedTime)
}