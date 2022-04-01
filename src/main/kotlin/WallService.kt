class WallService {
    var posts:Array<Post> = emptyArray()

    fun add(post: Post): Post {
        for (p in posts){
            if (p.id == post.id) return p
        }

        posts += post


        return posts.last()
    }

    fun update(post: Post): Boolean {
        var ind = -1
        for (p in posts){
            ind++
            if (p.id == post.id) {
                val np = post.copy(id = post.id, text = post.text)
                posts.set(ind, np)
                return true
            }
        }

        return false
    }

    fun printAllPosts(){

        for (post in posts){
            println("" + post.id + " - " + post.text)
        }

    }
}