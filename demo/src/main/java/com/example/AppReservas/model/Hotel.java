package com.example.AppReservas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double value;
    private String description;
    private String urlImg;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();
    @ManyToMany
    @JoinTable(name="hotel_category",
    joinColumns = @JoinColumn(name="hotel_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();
}
