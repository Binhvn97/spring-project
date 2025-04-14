package com.springdemo.binh97.entities.ecommerce;

import com.springdemo.binh97.entities.user.User;
import com.springdemo.binh97.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String order_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    Double totalPrice;

    @Enumerated(EnumType.STRING)
    OrderStatus status; // Enum: PENDING, COMPLETED, CANCELLED

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<OrderItem> orderItems = new ArrayList<>();
}
