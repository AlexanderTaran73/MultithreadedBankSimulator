package Observers

interface Observer {
    fun update(type: String ,message: String, status: String)
}