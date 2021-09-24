package com.blcheung.missyou.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user_coupon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private Long    userId;
    private Long    couponId;
    private Long    orderId;
    private Integer status;
    private Date    createTime;
}
