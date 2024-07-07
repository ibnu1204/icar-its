package id.its.icar.utils


/**
 * Created by wahid on 7/7/2024.
 * Github github.com/wahidabd.
 */


enum class HalteType(
    val halte: String,
    val route: RouteType
) {
    ASRAMA("Asrama ITS", RouteType.BUNDARAN),
    MANARUL("Manarul Ilmi", RouteType.BUNDARAN),
    BUNDARAN("Bundaran ITS", RouteType.BUNDARAN),
    LINKUNGAN("T. Lingkungan", RouteType.BUNDARAN),
    REKTORAT("Rektorat ITS", RouteType.BUNDARAN),
    KANTIN("Kantin ITS", RouteType.BUNDARAN),
    ELEKTRO("T. Elektro", RouteType.ROBOTIKA),
    BLOK_U_BARAT("Blok U Barat", RouteType.ROBOTIKA),
    RISET("G. Riset", RouteType.ROBOTIKA),
    ROBOTIKA("G. Robotika", RouteType.ROBOTIKA),
    BLOK_U_TIMUR("Blok U Timur", RouteType.ROBOTIKA),
    BLOK_T("Blok T", RouteType.ROBOTIKA),
}