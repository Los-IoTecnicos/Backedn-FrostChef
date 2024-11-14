package com.pe.frostchefbackend.frost.domain.services.Impl;

import com.pe.frostchefbackend.frost.aplication.commandservices.MachineRepository;
import com.pe.frostchefbackend.frost.aplication.commandservices.NotificationRepository;
import com.pe.frostchefbackend.frost.aplication.commandservices.ProductRepository;
import com.pe.frostchefbackend.frost.domain.model.aggregates.Notification;
import com.pe.frostchefbackend.frost.domain.model.entities.Machine;
import com.pe.frostchefbackend.frost.domain.model.entities.Product;
import com.pe.frostchefbackend.frost.domain.model.valueObjects.MachineStatus;
import com.pe.frostchefbackend.frost.domain.model.valueObjects.NotificationStatus;
import com.pe.frostchefbackend.services.FirebaseNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private MachineRepository machineRepository;

    @Autowired
    private ProductRepository productRepository;

    public void checkMachineStatus() {
        List<Machine> machines = machineRepository.findAll();

        for (Machine machine : machines) {
            if (machine.getStatus() == MachineStatus.BROKEN) {
                createNotification("Machine Issue", "Machine " + machine.getName() + " is broken.");
            } else if (machine.getCapacityPercentage() >= 100) {
                createNotification("Machine Capacity", "Machine " + machine.getName() + " is at maximum capacity.");
            }
        }
    }

    /*public void checkProductExpiry() {
        List<Product> products = productRepository.findAll();

        LocalDate today = LocalDate.now();
        for (Product product : products) {
            if (product.getExpiryDate()) {
                createNotification("Product Expiry", "Product " + product.getName() + " is about to expire.");
            }
        }
    }*/

    private void createNotification(String title, String message) {
        Notification notification = new Notification();
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setStatus(NotificationStatus.PENDING);
        notification.setTimestamp(LocalDateTime.now());
        notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Scheduled(fixedRate = 600000)
    public void scheduledMachineCheck() {
        checkMachineStatus();
    }

    // verificar la expiración de productos cada 24 horas
    /*@Scheduled(cron = "0 0 0 * * ?")
    public void scheduledProductExpiryCheck() {
        checkProductExpiry();
    }*/

    @Autowired
    private FirebaseNotificationService firebaseNotificationService;

    private void createNotifications(String title, String message) {

        // Token del dispositivo con cliente
        String deviceToken = "CLIENT_DEVICE_TOKEN";

        // Enviar notificación a dispositivo móvil
        firebaseNotificationService.sendNotificationToDevice(title, message, deviceToken);
    }
}

