package com.pe.frostchefbackend.frost.aplication.commandservices;

import com.pe.frostchefbackend.frost.domain.model.aggregates.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
