package model

abstract class Node(
    val name: String,

    // Ссылка на прерыдущее хранилище в иерархии
    val parent: Node?
) {

    // Ссылка на содержимое, у последнего в иерархии - самих заметок, равна null
    protected abstract val children: MutableList<out Node>?


    // Выход. Eсли выходить уже некуда - возвращаем null
    fun exit(): Node? {
        return parent
    }

    abstract fun showContent()

    fun commandHandle(command: String): Node? {
        if (command.contains("создать")) {
            val name = command.replace("создать", "").trim()

            if (name.isEmpty() || name.isBlank()) {
                println("Имя не может быть пустым!")
                return this
            }

            println()
            create(name)
            println()
            return this
        }

        val commandNumber: Int? = command.toIntOrNull()

        if (commandNumber == null) {
            println("Неизвестная команда!")
            return this
        }

        if (commandNumber == 0) {
            return exit()
        }

        val child = children?.getOrNull(commandNumber - 1)

        if (child == null) {
            println()
            println("Такого в списке нет, повторите еще раз")
            return this
        }

        return child
    }


    // Печатаем все содержимое
    protected fun printChildren() {
        println()

        if (children != null) {
            for (childIndex in children!!.indices) {
                println("${childIndex + 1} - ${children!![childIndex].name}")
            }
        }

        if (parent == null) {
            println("0 - выход из программы")
        } else {
            println("0 - вернутся назад в ${parent.name}")
        }

        println()
    }

    // Добавление новой сущности в содержимое
    protected abstract fun create(name: String)
}

