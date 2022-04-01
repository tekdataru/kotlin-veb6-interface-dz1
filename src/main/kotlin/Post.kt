data class Post(
    val id:Int,//    integer	Идентификатор записи.
    val ownerId:Int = 0,//integer	Идентификатор владельца стены, на которой размещена запись. В версиях API ниже 5.7 это поле называется to_id.
    val fromId:Int = 0, //integer	Идентификатор автора записи (от чьего имени опубликована запись).
    val createdBy:Int = 0, //integer	Идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора). Возвращается в записях, опубликованных менее 24 часов назад.
    val date:Int = 0, //integer	Время публикации записи в формате unixtime.
    val text:String, //string	Текст записи.
    val parentPost:Post?,// родительский пост, который может быть null
    val replyOwnerId:Int = 0, //integer	Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val replyPostId:Int = 0, //integer	Идентификатор записи, в ответ на которую была оставлена текущая.
    val friendsOnly:Boolean = false, //integer, [1]	1, если запись была создана с опцией «Только для друзей».
    val comments:Boolean = false, //object	Информация о комментариях к записи, объект с полями:
             /*(integer) — количество комментариев;
        can_post* (integer, [0,1]) — информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может);
        groups_can_post (integer, [0,1]) — информация о том, могут ли сообщества комментировать запись;
        can_close(boolean) — может ли текущий пользователь закрыть комментарии к записи;
        can_open(boolean) — может ли текущий пользователь открыть комментарии к записи.*/
    val copyright:Boolean = false, /*
object	Источник материала, объект с полями:
id (integer);
link* (string);
name* (string);
type* (string).*/
    val likes:Boolean = false, /*
object	Информация о лайках к записи, объект с полями:
count (integer) — число пользователей, которым понравилась запись;
user_likes* (integer, [0,1]) — наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);
can_like* (integer, [0,1]) — информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);
can_publish* (integer, [0,1]) — информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).*/
    val reposts:Boolean = false, /*
object	Информация о репостах записи («Рассказать друзьям»), объект с полями:
count (integer) — число пользователей, скопировавших запись;
user_reposted* (integer, [0,1]) — наличие репоста от текущего пользователя (1 — есть, 0 — нет).*/
    val views:Boolean = false,/*
object	Информация о просмотрах записи. Объект с единственным полем:
count (integer) — число просмотров записи.*/
    val postType:String  = "",//string	Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    /*val postSource:Boolean
object
Поле возвращается только для Standalone-приложений с ключом доступа, полученным в Implicit Flow.	Информация о способе размещения записи. Описание объекта находится на отдельной странице.*/
    val attachments:Array<Attachment>
    /*Медиавложения записи (фотографии, ссылки и т.п.). Описание массива attachments находится на отдельной странице.*/
    /*val geo:Boolean
object	Информация о местоположении , содержит поля:
type (string) — тип места;
coordinates (string) — координаты места;
place (object) — описание места (если оно добавлено). Объект места.*/
    val signerId:Int = 0,//integer	Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
    //val copyHistory:Boolean//array	Массив, содержащий историю репостов для записи. Возвращается только в том случае, если запись является репостом. Каждый из объектов массива, в свою очередь, является объектом-записью стандартного формата.
    val canPin:Boolean = false,//integer, [0,1]	Информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).
    val canDelete:Boolean = false,//integer, [0,1]	Информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может).
    val canEdit:Boolean = false,//integer, [0,1]	Информация о том, может ли текущий пользователь редактировать запись (1 — может, 0 — не может).
    val isPinned:Boolean = false,//integer, [1]	Информация о том, что запись закреплена.
    val markedAsAds:Boolean = false,//integer, [0,1]	Информация о том, содержит ли запись отметку "реклама" (1 — да, 0 — нет).
    val isFavorite:Boolean = false,//boolean	true, если объект добавлен в закладки у текущего пользователя.
    val donut:Boolean = false,/*object	Информация о записи VK Donut:
is_donut (boolean) — запись доступна только платным подписчикам VK Donut;
paid_duration (integer) — время, в течение которого запись будет доступна только платным подписчикам VK Donut;
placeholder (object) — заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи.
can_publish_free_copy (boolean) — можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut;
edit_mode (string) — информация о том, какие значения VK Donut можно изменить в записи. Возможные значения:
all — всю информацию о VK Donut.
duration — время, в течение которого запись будет доступна только платным подписчикам VK Donut.*/
    val postponedId:Int = 0,//integer	Идентификатор отложенной записи. Это поле возвращается тогда, когда з
) {
    init {
        attachments = emptyArray()
        var ind:Int = 0
        ind = 0
        attachments.set(ind, AttachmentAudio(value = Audio(id = ind, trackName = "init $ind")))
        ind = 1
        attachments.set(ind, AttachmentAudio(value = Audio(id = ind, trackName = "init $ind")))
    }

    fun addAttachment(att:Attachment){
        attachments.set(attachments.size, att)
    }
}
