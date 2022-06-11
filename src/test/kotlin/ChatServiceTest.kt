import org.junit.Assert.*
import org.junit.Test


class ChatServiceTest {

    @Test
    fun addUser() {
        val user1 = User(
            id = 1 ,
            firstName = "Alex" ,
            lastName = "Volkov" ,
            incomingMessages = emptyList() ,
            outgoingMessages = emptyList()
        )

        val result = ChatService.addUser(user1)

        assertTrue(result)
    }

    @Test
    fun addUserFalse() {
        val user1 = User(
            id = 1 ,
            firstName = "Alex" ,
            lastName = "Volkov" ,
            incomingMessages = emptyList() ,
            outgoingMessages = emptyList()
        )

        val user2 = User(
            id = 1 ,
            firstName = "Alex" ,
            lastName = "Volkov" ,
            incomingMessages = emptyList() ,
            outgoingMessages = emptyList()
        )

        val chatService = ChatService

        chatService.addUser(user1)

        val result = chatService.addUser(user2)

        assertFalse(result)
    }

    @Test
    fun addMessage() {
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

        val message1 = Message(
            text = "first" ,
            senderId = 1 ,
            recipientId = 2
        )

        ChatService.addUser(user1)
        ChatService.addUser(user2)
        val result = ChatService.addMessage(message1)

        assertEquals(result, 1)
    }

    @Test
    fun addMessage_SecondChat() {
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
            id = 3 ,
            firstName = "Aleksey" ,
            lastName = "Ivanov" ,
            incomingMessages = emptyList() ,
            outgoingMessages = emptyList()
        )

        val message1 = Message(
            text = "first" ,
            senderId = 1 ,
            recipientId = 2
        )

        val message3 = Message(
            text = "third" ,
            senderId = 1 ,
            recipientId = 3
        )

        ChatService.addUser(user1)
        ChatService.addUser(user2)
        ChatService.addUser(user3)
        ChatService.addMessage(message1)
        val result = ChatService.addMessage(message3)

        assertEquals(result, 2)
    }

    @Test
    fun deleteMessage_True() {
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

        val message1 = Message(
            text = "first" ,
            senderId = 1 ,
            recipientId = 2
        )

        ChatService.addUser(user1)
        ChatService.addUser(user2)
        ChatService.addMessage(message1)
        val result = ChatService.deleteMessage(1)

        assertTrue(result)
    }

    @Test
    fun deleteMessage_False() {
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

        val message1 = Message(
            text = "first" ,
            senderId = 1 ,
            recipientId = 2
        )

        ChatService.addUser(user1)
        ChatService.addUser(user2)
        ChatService.addMessage(message1)
        val result = ChatService.deleteMessage(5)

        assertFalse(result)
    }

    @Test
    fun deleteChatById_True() {
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

        val message1 = Message(
            text = "first" ,
            senderId = 1 ,
            recipientId = 2
        )

        ChatService.addUser(user1)
        ChatService.addUser(user2)
        ChatService.addMessage(message1)
        val chatKey = listOf(1, 2)
        val result = ChatService.deleteChatId(chatKey)

        assertTrue(result)
    }

    @Test
    fun deleteChatById_False() {
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

        val message1 = Message(
            text = "first" ,
            senderId = 1 ,
            recipientId = 2
        )

        ChatService.addUser(user1)
        ChatService.addUser(user2)
        ChatService.addMessage(message1)
        val chatKey = listOf(5, 2)
        val result = ChatService.deleteChatId(chatKey)

        assertFalse(result)
    }

    @Test
    fun editingMessage_True() {
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

        val message1 = Message(
            text = "first" ,
            senderId = 1 ,
            recipientId = 2
        )

        val updatedMessage = Message(
            id = 1 ,
            text = "UPDATED!!!" ,
            senderId = 1 ,
            recipientId = 2
        )

        ChatService.addUser(user1)
        ChatService.addUser(user2)
        ChatService.addMessage(message1)
        val result = ChatService.editingMessage(updatedMessage)

        assertTrue(result)
    }

    @Test
    fun editingMessage_False() {
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

        val message1 = Message(
            text = "first" ,
            senderId = 1 ,
            recipientId = 2
        )

        val updatedMessage = Message(
            id = 5 ,
            text = "UPDATED!!!" ,
            senderId = 1 ,
            recipientId = 2
        )

        ChatService.addUser(user1)
        ChatService.addUser(user2)
        ChatService.addMessage(message1)
        val result = ChatService.editingMessage(updatedMessage)

        assertFalse(result)
    }

    @Test
    fun getChatList() {
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

        val message1 = Message(
            id = 1,
            text = "first" ,
            senderId = 1 ,
            recipientId = 2
        )

        ChatService.addUser(user1)
        ChatService.addUser(user2)
        ChatService.addMessage(message1)
        val result = ChatService.getChatList()

        assertEquals(result, mutableMapOf(Pair((1), mutableListOf(message1))))
    }

    @Test
    fun getMessagesFromChat() {
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

        val message1 = Message(
            id = 1,
            text = "first" ,
            senderId = 1 ,
            recipientId = 2
        )

        ChatService.addUser(user1)
        ChatService.addUser(user2)
        ChatService.addMessage(message1)
        val result = ChatService.getMessagesFromChat(listOf(1, 2), 1, 1)

        assertEquals(result, listOf(message1))
    }

    @Test
    fun getUnreadChats() {
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

        val message8 = Message(
            text = "eighth" ,
            senderId = 2 ,
            recipientId = 3
        )

        ChatService.addUser(user2)
        ChatService.addUser(user3)
        ChatService.addMessage(message8)
        val result = ChatService.getUnreadChats(3)

        assertTrue(result.size == 1)
    }
}