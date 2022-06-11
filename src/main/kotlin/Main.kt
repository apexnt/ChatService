fun main() {

    val user1 = User(
        id = 1 ,
        firstName = "Alex" ,
        lastName = "Volkov" ,
        incomingMessages = emptyList() ,
        outgoingMessages = emptyList()
    )

    val user2 = User(
        id = 2 ,
        firstName = "Alexandr" ,
        lastName = "Petrov" ,
        incomingMessages = emptyList() ,
        outgoingMessages = emptyList()
    )

    val user3 = User(
        id = 2 ,
        firstName = "Aleksey" ,
        lastName = "Ivanov" ,
        incomingMessages = emptyList() ,
        outgoingMessages = emptyList()
    )

    val user4 = User(
        id = 2 ,
        firstName = "Alic" ,
        lastName = "Salovat" ,
        incomingMessages = emptyList() ,
        outgoingMessages = emptyList()
    )

    ChatService.addUser(user1)
    ChatService.addUser(user2)
    ChatService.addUser(user3)
    ChatService.addUser(user4)

    val message1 = Message(
        text = "first" ,
        senderId = 1 ,
        recipientId = 2
    )

    val message2 = Message(
        text = "second" ,
        senderId = 1 ,
        recipientId = 4
    )

    val message3 = Message(
        text = "third" ,
        senderId = 1 ,
        recipientId = 3
    )

    val message4 = Message(
        text = "fourth" ,
        senderId = 3 ,
        recipientId = 1
    )

    val message5 = Message(
        text = "fifth" ,
        senderId = 2 ,
        recipientId = 1
    )

    val message6 = Message(
        text = "sixth" ,
        senderId = 2 ,
        recipientId = 1
    )

    val message7 = Message(
        text = "seventh" ,
        senderId = 2 ,
        recipientId = 1
    )

    val message8 = Message(
        text = "eighth" ,
        senderId = 2 ,
        recipientId = 3
    )

    val message9 = Message(
        text = "ninth" ,
        senderId = 2 ,
        recipientId = 1
    )

    val message10 = Message(
        text = "tenth" ,
        senderId = 4 ,
        recipientId = 2
    )

    val message11 = Message(
        text = "eleventh" ,
        senderId = 1 ,
        recipientId = 2
    )

    val updatedMessage = Message(
        id = 1 ,
        text = "UPDATED!!!" ,
        senderId = 1 ,
        recipientId = 2
    )

    ChatService.addMessage(message1)
    ChatService.addMessage(message2)
    ChatService.addMessage(message3)
    ChatService.addMessage(message4)
    ChatService.addMessage(message5)
    ChatService.addMessage(message6)
    ChatService.addMessage(message7)
    ChatService.addMessage(message8)
    ChatService.addMessage(message9)
    ChatService.addMessage(message10)
    ChatService.addMessage(message11)

    ChatService.editingMessage(updatedMessage)
    ChatService.getUnreadChats(1)
    ChatService.deleteMessage(8)
    ChatService.deleteChatId(listOf(3 , 1))
    ChatService.getMessagesFromChat(chatId = listOf(1 , 2) , 5 , 2)

}
