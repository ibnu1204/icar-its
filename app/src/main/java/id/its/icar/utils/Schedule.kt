package id.its.icar.utils

import com.wahidabd.library.utils.exts.debug


/**
 * Created by wahid on 7/7/2024.
 * Github github.com/wahidabd.
 */


enum class HalteName(val halteName: String) {
    ASRAMA_ITS("Asrama ITS"),
    MANARUL_ILMI("Manarul Ilmi"),
    BUNDERAN_ITS("Bunderan ITS"),
    T_LINGKUNGAN("T. Lingkungan"),
    REKTORAT_ITS("Rektorat ITS"),
    KANTIN_ITS("Kantin ITS"),
    T_ELEKTRO("T. Elektro"),
    BLOK_U_BARAT("Blok U Barat"),
    G_RISET("G. Riset"),
    G_ROBOTIKA("G. Robotika"),
    BLOK_U_TIMUR("Blok U Timur"),
    BLOK_T("Blok T")
}

enum class Loop(val loopName: String) {
    LOOP_1("Loop 1"),
    LOOP_2("Loop 2"),
    LOOP_3("Loop 3"),
    LOOP_4("Loop 4"),
    LOOP_5("Loop 5")
}

data class Schedule(
    val halte: HalteName,
    val type: String,
    val route: RouteType,
    val loopTimes: Map<Loop, String>
)

val morningSchedule = listOf(
    Schedule(
        HalteName.ASRAMA_ITS, "iCar 2", RouteType.BUNDARAN, mapOf(
            Loop.LOOP_1 to "9:00",
            Loop.LOOP_2 to "9:24",
            Loop.LOOP_3 to "9:48",
            Loop.LOOP_4 to "10:12",
            Loop.LOOP_5 to "10:36"
        )
    ),
    Schedule(
        HalteName.MANARUL_ILMI, "iCar 2", RouteType.BUNDARAN, mapOf(
            Loop.LOOP_1 to "9:05",
            Loop.LOOP_2 to "9:29",
            Loop.LOOP_3 to "9:53",
            Loop.LOOP_4 to "10:17",
            Loop.LOOP_5 to "10:41"
        )
    ),
    Schedule(
        HalteName.BUNDERAN_ITS, "iCar 2", RouteType.BUNDARAN, mapOf(
            Loop.LOOP_1 to "9:10",
            Loop.LOOP_2 to "9:34",
            Loop.LOOP_3 to "9:58",
            Loop.LOOP_4 to "10:22",
            Loop.LOOP_5 to "10:46"
        )
    ),
    Schedule(
        HalteName.T_LINGKUNGAN, "iCar 2", RouteType.BUNDARAN, mapOf(
            Loop.LOOP_1 to "9:12",
            Loop.LOOP_2 to "9:36",
            Loop.LOOP_3 to "10:00",
            Loop.LOOP_4 to "10:24",
            Loop.LOOP_5 to "10:48"
        )
    ),
    Schedule(
        HalteName.REKTORAT_ITS, "iCar 2", RouteType.BUNDARAN, mapOf(
            Loop.LOOP_1 to "9:15",
            Loop.LOOP_2 to "9:39",
            Loop.LOOP_3 to "10:03",
            Loop.LOOP_4 to "10:27",
            Loop.LOOP_5 to "10:51"
        )
    ),
    Schedule(
        HalteName.KANTIN_ITS, "iCar 2", RouteType.BUNDARAN, mapOf(
            Loop.LOOP_1 to "9:18",
            Loop.LOOP_2 to "9:42",
            Loop.LOOP_3 to "10:06",
            Loop.LOOP_4 to "10:30",
            Loop.LOOP_5 to "10:54"
        )
    ),
    Schedule(
        HalteName.KANTIN_ITS, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "9:20",
            Loop.LOOP_2 to "9:59",
            Loop.LOOP_3 to "10:38"
        )
    ),
    Schedule(
        HalteName.T_ELEKTRO, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "9:24",
            Loop.LOOP_2 to "10:03",
            Loop.LOOP_3 to "10:42"
        )
    ),
    Schedule(
        HalteName.BLOK_U_BARAT, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "9:30",
            Loop.LOOP_2 to "10:09",
            Loop.LOOP_3 to "10:48"
        )
    ),
    Schedule(
        HalteName.G_RISET, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "9:34",
            Loop.LOOP_2 to "10:13",
            Loop.LOOP_3 to "10:52"
        )
    ),
    Schedule(
        HalteName.G_ROBOTIKA, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "9:39",
            Loop.LOOP_2 to "10:18",
            Loop.LOOP_3 to "10:57"
        )
    ),
    Schedule(
        HalteName.BLOK_U_TIMUR, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "9:46",
            Loop.LOOP_2 to "10:25",
            Loop.LOOP_3 to "11:04"
        )
    ),
    Schedule(
        HalteName.BLOK_T, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "9:51",
            Loop.LOOP_2 to "10:30",
            Loop.LOOP_3 to "11:09"
        )
    ),
    Schedule(
        HalteName.MANARUL_ILMI, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "9:56",
            Loop.LOOP_2 to "10:35",
            Loop.LOOP_3 to "11:14"
        )
    )
)

val afternoonSchedule = listOf(
    Schedule(
        HalteName.ASRAMA_ITS, "iCar 2", RouteType.BUNDARAN, mapOf(
            Loop.LOOP_1 to "14:00",
            Loop.LOOP_2 to "14:24",
            Loop.LOOP_3 to "14:48",
            Loop.LOOP_4 to "15:12",
            Loop.LOOP_5 to "15:36"
        )
    ),
    Schedule(
        HalteName.MANARUL_ILMI, "iCar 2", RouteType.BUNDARAN, mapOf(
            Loop.LOOP_1 to "14:05",
            Loop.LOOP_2 to "14:29",
            Loop.LOOP_3 to "14:53",
            Loop.LOOP_4 to "15:17",
            Loop.LOOP_5 to "15:41"
        )
    ),
    Schedule(
        HalteName.BUNDERAN_ITS, "iCar 2", RouteType.BUNDARAN, mapOf(
            Loop.LOOP_1 to "14:10",
            Loop.LOOP_2 to "14:34",
            Loop.LOOP_3 to "14:58",
            Loop.LOOP_4 to "15:22",
            Loop.LOOP_5 to "15:46"
        )
    ),
    Schedule(
        HalteName.T_LINGKUNGAN, "iCar 2", RouteType.BUNDARAN, mapOf(
            Loop.LOOP_1 to "14:12",
            Loop.LOOP_2 to "14:36",
            Loop.LOOP_3 to "15:00",
            Loop.LOOP_4 to "15:24",
            Loop.LOOP_5 to "15:48"
        )
    ),
    Schedule(
        HalteName.REKTORAT_ITS, "iCar 2", RouteType.BUNDARAN, mapOf(
            Loop.LOOP_1 to "14:15",
            Loop.LOOP_2 to "14:39",
            Loop.LOOP_3 to "15:03",
            Loop.LOOP_4 to "15:27",
            Loop.LOOP_5 to "15:51"
        )
    ),
    Schedule(
        HalteName.KANTIN_ITS, "iCar 2", RouteType.BUNDARAN, mapOf(
            Loop.LOOP_1 to "14:18",
            Loop.LOOP_2 to "14:42",
            Loop.LOOP_3 to "15:06",
            Loop.LOOP_4 to "15:30",
            Loop.LOOP_5 to "15:54"
        )
    ),
    Schedule(
        HalteName.KANTIN_ITS, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "14:20",
            Loop.LOOP_2 to "14:59",
            Loop.LOOP_3 to "15:38"
        )
    ),
    Schedule(
        HalteName.T_ELEKTRO, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "14:24",
            Loop.LOOP_2 to "15:03",
            Loop.LOOP_3 to "15:42"
        )
    ),
    Schedule(
        HalteName.BLOK_U_BARAT, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "14:30",
            Loop.LOOP_2 to "15:09",
            Loop.LOOP_3 to "15:48"
        )
    ),
    Schedule(
        HalteName.G_RISET, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "14:34",
            Loop.LOOP_2 to "15:13",
            Loop.LOOP_3 to "15:52"
        )
    ),
    Schedule(
        HalteName.G_ROBOTIKA, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "14:39",
            Loop.LOOP_2 to "15:18",
            Loop.LOOP_3 to "15:57"
        )
    ),
    Schedule(
        HalteName.BLOK_U_TIMUR, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "14:46",
            Loop.LOOP_2 to "15:25",
            Loop.LOOP_3 to "16:04"
        )
    ),
    Schedule(
        HalteName.BLOK_T, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "14:51",
            Loop.LOOP_2 to "15:30",
            Loop.LOOP_3 to "16:09"
        )
    ),
    Schedule(
        HalteName.MANARUL_ILMI, "iCar 3", RouteType.ROBOTIKA, mapOf(
            Loop.LOOP_1 to "14:56",
            Loop.LOOP_2 to "15:35",
            Loop.LOOP_3 to "16:14"
        )
    )
)

fun getSchedule(halte: HalteName, route: RouteType): List<Schedule> {
    val schedule = morningSchedule + afternoonSchedule
    return schedule.filter { it.halte == halte && it.route == route }
}