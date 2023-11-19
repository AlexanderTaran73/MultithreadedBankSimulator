package Observers

import java.io.File
import java.time.LocalDateTime

class FileLogger: Observer {
    val file = File("FileLogger.txt")
    override fun update(type: String, message: String, status: String) {

        file.appendText("[${LocalDateTime.now()}][$status] $type : $message\n")
    }

    init {
        file.createNewFile()
        file.writeText("FileLogger\n")

    }
}