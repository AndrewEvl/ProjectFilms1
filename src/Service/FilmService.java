package Service;

import Dao.FilmDao;
import Entity.Film;
import Entity.Genre;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 18.04.2017.
 */
public class FilmService {
    private static final Object LOCK = new Object();
    private static FilmService INSTANCE = null;

    public static FilmService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new FilmService();
                }
            }
        }
        return INSTANCE;
    }

    public Film addFilm(Film film, long genreId, long actDirId, long roleId) {
        FilmDao.getInstance().save(film, genreId, actDirId, roleId);
        return film;
    }

    public List<Film> yearFilm (LocalDate releaseDay) {
       return FilmDao.getInstance().getByYear(releaseDay);
    }

    public List<Genre> fullGenres() {
        return FilmDao.getInstance().findAllGenre();
    }

    public List<Film> allFilms() {
        return FilmDao.getInstance().allFilms();
    }

    public Optional<Film> fullFilmInfo(long id) {
        return FilmDao.getInstance().listFilms(id);
    }

    public List<Film> downlodFile (){
        return FilmDao.getInstance().downlonFileFilm();
    }
}
