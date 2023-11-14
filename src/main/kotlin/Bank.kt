import Transactions.*
import com.google.gson.Gson
import java.net.URL
import java.util.concurrent.*


data class ExchangeRate (val success: Boolean, val timestamp: Int, val base: String,
                         val date: String, val rates: HashMap<String, Double>)
class Bank {
    val clients = CopyOnWriteArrayList<Client>()
    val cashiers = CopyOnWriteArrayList<Cashier>()

    val transactionQueue = ConcurrentLinkedQueue<Transaction>()
    val exchangeRates = ConcurrentHashMap<String, Double>()




    init {
        val executor = ScheduledThreadPoolExecutor(1)
        executor.scheduleAtFixedRate({
            val gson = Gson()
            val json = URL("http://api.exchangeratesapi.io/v1/latest?access_key=7899ebf0794dbff83a21281f188c4727&symbols=RUB,USD,EUR").readText()
            gson.fromJson(json, ExchangeRate::class.java).also {
                if (it.success) it.rates.forEach{
                    (key, value) -> exchangeRates[key] = value }
                else {
                    TODO("Обработать плохой ответ сервера")
                }
            }
            println(exchangeRates)

        }, 0, 60, TimeUnit.SECONDS)
    }

}