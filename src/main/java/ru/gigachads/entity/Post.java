package ru.gigachads.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String content;
	private LocalDateTime writtenAt;
	private Integer likes;

	@OneToOne
	@JoinColumn(name = "server_id")
	private Server server;

	@OneToMany
	@JoinColumn(name = "comment_id")
	private List<Comment> comments;
}
