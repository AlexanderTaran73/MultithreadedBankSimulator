## Многопоточная симуляция банка

### Описание

Данное многопоточное приложение написанное на Kotlin и предоставляет возможность создания кассиров и клиентов внутри банка, а также возможность управления различными транзакциями между клиентами. Для упрощенного тестирования написан консольный интерфейс управления.


### Инструкции по запуску

1. **Скачайте проект:**
    ```bash
   https://github.com/AlexanderTaran73/MultithreadedBankSimulator.git
   ```

2. **Перейдите в каталог проекта:**
    ```bash
    cd MultithreadedBankSimulator
    ```

3. **Запустите приложение:**
    ```bash
   ./gradlew build
   java -jar build/libs/MultithreadedBankSimulator-1.0-SNAPSHOT-standalone.jar

    ```
### Использование приложения

* **Консольный интерфейс:**
  Приложение предоставляет консольный интерфейс для взаимодействия, который запускается в Main.kt
    ```Kotlin
    //    ConsoleUI
    val consoleUI = ConsoleUI(bank)
    consoleUI.start()
    ```
  После старта приложения необходимо следовать инструкциям выводимым в консоль.

  * Ввести количество кассиров и клиентов
  * Выбрать одно из действий
    1. Посмотреть информацию о пользователях
    2. Совершить транзакцию
    3. Выйти из приложения
  * В случае совершения транзакции надо выбрать ее тип и ввести требуемые данный
  * При выборе выхода из приложения работа программы будет завершена
  * В случае ввода ошибочных данных необходимо повторить ввод

    Детально изучить работу консольного интерфейса можно в файле ConsoleUI который лежит в папке kotlin.


* **Использование в коде:** Весь представленный функционал может быть использован в отрыве от консольного интерфейса.

  **Создание банка**
    ```Kotlin
    val bank = Bank()
    ```
  **Добавление кассира:** Для создания кассира необходимо передать в конструктор его уникальный id и bank к которому он будет привязан.
    ```Kotlin
    bank.cashiers.add(Cashier(0, bank))
    ```

  **Добавление клиента** Для создания клиента необходимо передать в его конструктор его уникальный id.
    ```Kotlin
    bank.clients.add(Client(0))
    ```
  **Создание транзакции** Для создания одной из четырех доступных транзакций необходим передать в их конструктор реализацию интерфейса TransactionData которая индвидуальна для каждого из типов транзакций
    ```Kotlin
    var transaction1 = WithdrawTransaction(
        WithdrawTransactionData(
            client = bank.clients[0],
            currency = "USD",
            amount = 1000.0))
    
    var transaction2 = ToDepositTransaction(
        ToDepositTransactionData(
            client = bank.clients[0],
            currency = "USD",
            amount = 5000.0))
    
    var transaction3 = ExchangeCurrencyTransaction(
        ExchangeCurrencyTransactionData(
            client = bank.clients[0],
            fromCurrency = "USD",
            toCurrency = "EUR",
            ratio = bank.exchangeRates["USD"]!! / bank.exchangeRates["EUR"]!!,
            amount = 100.0))
    
    var transaction4 = TransferTransaction(
        TransferTransactionData(
            senderClient = bank.clients[0],
            receiverClient = bank.clients[1],
            currency = "USD", amount = 1000.0))
    ```
  **Добавление транзакции** Добавление транзакции в очередь исполняемых транзакций
    ```Kotlin
    bank.transactionQueue.add(transaction)
    ```

  В Main.kt предоставлен закомментированный набор команд, который можно запустить для лучшего понимания работы приложения.


* **Логирование:** Для логирования информации необходимо добавить банку, действия которого мы хотим логировать, одну из реализаций интерфейса Observer.
    ```Kotlin
    bank.observers.add(FileLogger())        //Logging in file
    bank.observers.add(ConsoleLogger())   //Logging in console
    ```
  При необходимости можно добавить свою реализацию.


* **Курс валют:** Для контроля курса валют при работе приложения раз в 60 секунд происходит запрос на адрес

  http://api.exchangeratesapi.io/v1/latest?access_key=7899ebf0794dbff83a21281f188c4727&symbols=RUB,USD,EUR

  При необходимости адрес запроса и время между запросами можно поменять в init класса Bank файла Bank.kt


### Важно
Приложение написано с целью расширенного изучения многопоточного программирования на Kotlin. Представлен только базовый функционал. При использовании данного приложения в вашем проекте может потребоваться расширение функционала. 
