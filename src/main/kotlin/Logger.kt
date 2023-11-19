import Observer

class Logger: Observer {
    override fun update(message: String, status: String) {
        println(
            "\n---   ---   ---\n"+
                    "Status: $status\n"+
                    "Message: $message\n"+
                    "---   ---   ---\n"
        )
    }
}