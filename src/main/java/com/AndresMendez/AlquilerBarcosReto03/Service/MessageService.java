package com.AndresMendez.AlquilerBarcosReto03.Service;

import com.AndresMendez.AlquilerBarcosReto03.Modelo.Message;
import com.AndresMendez.AlquilerBarcosReto03.Repository.MessageRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres Mendez
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int idMessage) {
        return messageRepository.getMessage(idMessage);
    }

    public Message save(Message m) {
        if (m.getIdMessage() == null) {
            return messageRepository.save(m);
        } else {
            Optional<Message> maux = messageRepository.getMessage(m.getIdMessage());
            if (maux.isPresent()) {
                return m;
            } else {
                return messageRepository.save(m);
            }
        }
    }

    public Message update(Message m) {
        if (m.getIdMessage() != null) {
            Optional<Message> q = messageRepository.getMessage(m.getIdMessage());
            if (q.isPresent()) {
                if (m.getMessageText() != null) {
                    q.get().setMessageText(m.getMessageText());
                }
                if (m.getClient() != null) {
                    q.get().setClient(m.getClient());
                }
                messageRepository.save(q.get());
                return q.get();
            } else {
                return m;
            }
        } else {
            return m;
        }
    }

    public boolean delete(int idMessage) {
        boolean flag = false;
        Optional<Message> m = messageRepository.getMessage(idMessage);
        if (m.isPresent()) {
            messageRepository.delete(m.get());
            flag = true;
        }
        return flag;
    }
}
