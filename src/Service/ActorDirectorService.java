package Service;

import Dao.ActorDirectorDao;
import Dao.FilmDao;
import Dao.UserDao;
import Entity.ActorDirector;
import Entity.Film;
import Entity.Role;

import java.util.List;
import java.util.Optional;

/**
 * Created by User on 18.04.2017.
 */
public class ActorDirectorService {
    private static final Object LOCK = new Object();
    private static ActorDirectorService INSTANCE = null;

    public static ActorDirectorService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ActorDirectorService();
                }
            }
        }
        return INSTANCE;
    }
    public ActorDirector addActorDirector (ActorDirector actorDirector){
        ActorDirectorDao.getInstance().save(actorDirector);
        return actorDirector;
    }

    public List<ActorDirector> fullActorDirector(){
        return ActorDirectorDao.getInstance().getActDir();
    }

    public List<Role> allRole() {
        return UserDao.getInstance().findAllRole();
    }

    public Optional<Film> filmActDir (Film film,long actDirId, long roleId){
        return FilmDao.getInstance().addFilmActorDirector(film,actDirId,roleId);

    }
}
