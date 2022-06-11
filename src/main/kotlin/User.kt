data class User(
    var id: Int ,
    val firstName: String ,
    val lastName: String ,
    val incomingMessages: List<Message> ,
    val outgoingMessages: List<Message>
) {
    override fun toString(): String {
        return "UserId = $id, firstName = $firstName, lastName = $lastName"
    }
}