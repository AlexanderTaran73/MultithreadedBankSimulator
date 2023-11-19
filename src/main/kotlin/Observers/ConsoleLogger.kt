package Observers

import java.time.LocalDateTime

class ConsoleLogger: Observer {
    override fun update(type: String, message: String, status: String) {
        println(
            "[${LocalDateTime.now()}][$status] $type : $message\n"
        )
    }
}
