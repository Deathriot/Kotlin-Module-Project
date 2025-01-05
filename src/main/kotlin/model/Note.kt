package model

class Note(name : String, parent : Node, val content : String) : Node(name, parent) {

    override val children = null

    override fun showContent() {
        println(content)
        printChildren()
    }

    override fun create(name: String) {
        println("В заметках нечего создавать!")
    }
}