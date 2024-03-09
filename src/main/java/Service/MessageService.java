package Service;

import java.util.List;

import DAO.MessageDAO;
import Model.Message;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService()
    {
        messageDAO = new MessageDAO();
    }
    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }

    public Message createMessage(Message message) {
        if (message.getMessage_text().length() == 0 || message.getMessage_text().length() > 255)
        {
            return null;
        }
        if (message.getPosted_by() == 0)
        {    
            return null;
        }
        
        return messageDAO.newMessage(message);
    }
    public List<Message> getAllMessages()
    {
        return messageDAO.getAllMessages();
    }

    public Message getAllMessagesById(int message_id) {

        return messageDAO.getAllMessagesById(message_id);
        
    }

    public Message deleteMessage(int message_id) {
        Message message = messageDAO.getAllMessagesById(message_id);
        if (message == null)
        {
            return null;
        }
        messageDAO.deleteMessage(message);   
        return message;
    }
}
