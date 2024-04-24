package moratorium.se.itmo.blps.controller.movie;

import java.nio.charset.StandardCharsets;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import moratorium.se.itmo.blps.controller.movie.dto.AddMovieRequestDto;
import moratorium.se.itmo.blps.controller.movie.dto.AddMovieResponseDto;
import moratorium.se.itmo.blps.controller.movie.dto.GetMovieResponseDto;
import moratorium.se.itmo.blps.controller.movie.dto.GetMoviesResponseDto;
import moratorium.se.itmo.blps.service.movie.MovieFacade;
import moratorium.se.itmo.blps.util.StringTestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {

    @MockBean
    private MovieFacade movieFacade;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext) {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    @SneakyThrows
    void addMovieTest() {

        doReturn(new AddMovieResponseDto(1L)).when(movieFacade).addMovie(any(AddMovieRequestDto.class));
        var t = mockMvc.perform(post("/api/v1/movies/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .content(StringTestUtil.getString("controller.movie/movieCreateRequest.json")))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.movieId").value(1L))
                .andExpect(status().isOk());

        verify(movieFacade, times(1)).addMovie(any(AddMovieRequestDto.class));
    }

    @Test
    @SneakyThrows
    void getMoviesTest() {
        var movies = GetMoviesResponseDto.builder()
                .movies(List.of(
                        new GetMovieResponseDto(
                                1L,
                                "Фильм1",
                                "Описание1",
                                "Директор1",
                                1920,
                                "Жанр1",
                                120
                        )
                ))
                .build();
        String expectedJson = new ObjectMapper().writeValueAsString(movies);

        doReturn(movies).when(movieFacade).getMovies();
        var t = mockMvc.perform(get("/api/v1/movies"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().json(expectedJson))
                .andExpect(status().isOk());

        verify(movieFacade, times(1)).getMovies();
    }
}