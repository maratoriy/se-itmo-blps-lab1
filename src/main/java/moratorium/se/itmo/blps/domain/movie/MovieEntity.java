package moratorium.se.itmo.blps.domain.movie;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import moratorium.se.itmo.blps.domain.review.ReviewEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "movie")
public class MovieEntity {

    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Length(min = 1)
    private String title;

    private String description;

    private String director;

    @Range(min = 1895)
    private Integer releaseYear;

    private String genre;

    @Range(min = 1)
    private Integer duration;


    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "movie")
    private List<ReviewEntity> reviews;
}