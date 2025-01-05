import model.ArchiveList
import model.Node
import java.util.Scanner

fun main(args: Array<String>) {
    var node : Node? = ArchiveList()
    val input = Scanner(System.`in`)

    while(true){
        node!!.showContent()
        node = node.commandHandle(input.nextLine())

        node ?: break
    }

    println()
    println("Досвидания!")
}