package org.aibles.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// nếu không có dòng này, id sẽ chỉ tự động tăng trong database mà không hiển thị id cho người dùng ??
    @Column(name = "role_id")
    private Long id;

    @Column(name = "name")
    private String name;
}
