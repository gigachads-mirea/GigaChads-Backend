package ru.gigachads.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Описание класса
 */
@Entity
@Table(name = "posts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "author_id")
    private User author;

    private String title;

    private String content;

    private int likes;

    @Column(name = "written_at")
    private LocalDateTime writtenAt;

    @ManyToOne
    @JoinColumn(name = "server_id")
    private Server server;

    @OneToMany(fetch = FetchType.EAGER,
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        mappedBy = "post")
    private List<Comment> posts;
}
