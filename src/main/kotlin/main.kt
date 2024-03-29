fun main() {
    val post = Post(id = 1, text = "Текст 1")
    var post2 = Post(id = 2, text = "Текст 2")
    val post3 = Post(id = 1, text = "Текст 3")

    var att:Attachment = AttachmentAudio(Audio(id=1, trackName = "Песня 1"))
    post2.addAttachment(att)

    att = AttachmentVideo(Video(id=1, title = "Видео 1"))
    post2.addAttachment(att)

    att = AttachmentVideo(Video(id=2, title = "Видео 2"))
    post2.addAttachment(att)

    post3.addAttachment(att)

    post3.addAttachment(AttachmentPhoto(Photo(id=2, title = "Фото 2")))
    post3.addAttachment(AttachmentNote(Note(id=2, text = "Заметка 2")))
    post2.addAttachment(AttachmentNote(Note(id=2, text = "Заметка 222")))

    val ws = WallService()

    ws.add(post)
    ws.add(post2)
    ws.add(post3)
    ws.update(post3)

    ws.printAllPosts()
}