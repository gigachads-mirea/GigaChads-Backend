package ru.gigachads.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Описание класса
 */
@Entity
@Table(name = "servers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "ip_address")
    private String ipAddress;

    private String title;

    private String description;

    private int capacity;

    private int currentOnline;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    private int ping;

    @Column(name = "anti_cheat")
    private boolean antiCheat;

    @Column(name = "is_modded")
    private boolean isModded;

    private float rating;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private boolean validated;

    @ManyToMany(fetch = FetchType.EAGER,
        mappedBy = "favorites")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

}
