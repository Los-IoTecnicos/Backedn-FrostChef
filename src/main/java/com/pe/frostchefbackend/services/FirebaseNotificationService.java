package com.pe.frostchefbackend.services;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class FirebaseNotificationService {

    public void sendNotificationToDevice(String title, String messageBody, String token) {
        Message message = Message.builder()
                .putData("title", title)
                .putData("body", messageBody)
                .setToken(token)
                .build();

        try {
            FirebaseMessaging.getInstance().send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
