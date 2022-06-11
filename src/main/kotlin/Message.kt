data class Message(
    val id: Int = 0 ,
    val text: String? ,
    val readStatus: Boolean = false ,
    val senderId: Int ,
    val recipientId: Int
) {
    override fun toString(): String {
        return "id = $id, text = $text, readStatus = $readStatus, senderId = $senderId, recipientId = $recipientId"
    }
}
