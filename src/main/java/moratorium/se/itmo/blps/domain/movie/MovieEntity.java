package moratorium.se.itmo.blps.domain.movie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
public class MovieEntity {

    @Id
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

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MovieEntity)) {
            return false;
        }
        final MovieEntity other = (MovieEntity) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
            return false;
        }
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        final Object this$director = this.getDirector();
        final Object other$director = other.getDirector();
        if (this$director == null ? other$director != null : !this$director.equals(other$director)) {
            return false;
        }
        final Object this$releaseYear = this.getReleaseYear();
        final Object other$releaseYear = other.getReleaseYear();
        if (this$releaseYear == null ? other$releaseYear != null : !this$releaseYear.equals(other$releaseYear)) {
            return false;
        }
        final Object this$genre = this.getGenre();
        final Object other$genre = other.getGenre();
        if (this$genre == null ? other$genre != null : !this$genre.equals(other$genre)) {
            return false;
        }
        final Object this$duration = this.getDuration();
        final Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MovieEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $director = this.getDirector();
        result = result * PRIME + ($director == null ? 43 : $director.hashCode());
        final Object $releaseYear = this.getReleaseYear();
        result = result * PRIME + ($releaseYear == null ? 43 : $releaseYear.hashCode());
        final Object $genre = this.getGenre();
        result = result * PRIME + ($genre == null ? 43 : $genre.hashCode());
        final Object $duration = this.getDuration();
        result = result * PRIME + ($duration == null ? 43 : $duration.hashCode());
        return result;
    }
}