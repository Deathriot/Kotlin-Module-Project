package model

import java.util.Scanner

class Archive(name: String, parent: Node) : Node(name, parent) {

    override val children = ArrayList<Note>()

    override fun showContent() {
        println("Введите команду \"создать 'Имя_Заметки'\", чтоб создать новую заметку или выберите уже существующую")
        printChildren()
    }


    override fun create(name: String) {
        println("Введите содержание заметки: ")
        val content = Scanner(System.`in`).nextLine()

        if (content.isEmpty()) {
            println("Нельзя создать пустую заметку!")
            return
        }

        val newNote = Note(name, this, content)
        children.add(newNote)
    }
}