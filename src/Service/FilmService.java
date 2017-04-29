package Service;

import Dao.FilmDao;
import Entity.ActorDirector;
import Entity.Film;
import Entity.Ganre;
import Entity.Role;

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

    public Film addFilm (Film film, long genreId, long actDirId, long roleId){
        FilmDao.getInstance().save(film,genreId, actDirId,roleId);
        return film;
    }

    public Film yearFilm (Film film){
        FilmDao.getInstance().getByYear(film.getReleaseDay());
        return film;
    }

    public Film idFilm (Film film){
        FilmDao.getInstance().getById(film.getId());
        return film;
    }

    public Film nameFilm (Film film) {
        FilmDao.getInstance().getByName(film.getName());
        return film;
    }

    public List<Ganre> fullGenres() {
        return FilmDao.getInstance().findAllGenre();
    }

    public List<Film> fullInfoFilm(){
        return FilmDao.getInstance().fullInfo();
    }

    public Film filmActDir (Film film, ActorDirector actorDirector, Role role){
        FilmDao.getInstance().addFilmActorDirector(film,actorDirector,role);
        return film;
    }

}
