fun main() {
    val post = Post(id = 1, text = "Текст 1")
    var post2 = Post(id = 2, text = "Текст 2")
    val post3 = Post(id = 1, text = "Текст 3")

    val att = AttachmentAudio(value = Audio(id=1, trackName = "Песня 1"))

    post2.addAttachment(post2, att)

    val ws = WallService()

    ws.add(post)
    ws.add(post2)
    ws.add(post3)
    ws.update(post3)

    ws.printAllPosts()
}