package id.its.icar.domain.user.model.response

import com.wahidabd.library.utils.common.emptyString


/**
 * Created by wahid on 5/17/2024.
 * Github github.com/wahidabd.
 */


data class LoginResponse(
    val name: String? = emptyString(),
    val email: String? = emptyString(),
)
