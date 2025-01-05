package model

class ArchiveList: Node ("Главный Архив", null) {

    override val children = ArrayList<Archive>()

    override fun showContent() {
        println("Введите команду \"создать 'Имя_Архива'\", чтоб создать новый архив или выберите уже существующий")
        printChildren()
    }

    override fun create(name : String) {
        val newArchive = Archive(name, this)
        children.add(newArchive)
        println("Новый Архив с именем $name успешно создан!")
    }
}
