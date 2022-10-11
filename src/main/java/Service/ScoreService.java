package Service;

import Modelo.Score;
import Repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres Mendez
 */
@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score score) {
        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> aux = scoreRepository.getScore(score.getIdScore());
            if (aux.isPresent()) {
                return score;
            } else {
                return scoreRepository.save(score);
            }
        }
    }

    public Score update(Score score) {
        if (score.getIdScore() != null) {
            Optional<Score> c = scoreRepository.getScore(score.getIdScore());
            if (c.isPresent()) {
                if (score.getIdScore() != null) {
                    c.get().setIdScore(score.getIdScore());
                }
                if (score.getMessageTex() != null) {
                    c.get().setMessageTex(score.getMessageTex());
                }
                if (score.getStarts() != null) {
                    c.get().setStarts(score.getStarts());
                }
                if(score.getReservation() != null){
                    c.get().setReservation(score.getReservation());
                }
                scoreRepository.save(c.get());
                return c.get();
            } else {
                return score;
            }
        } else {
            return score;
        }
    }
    
    public boolean delete (int id){
        boolean flag = false;
        Optional<Score> c = scoreRepository.getScore(id);
        if (c.isPresent()){
            scoreRepository.delete(c.get());
        }
        return flag;
    }
}
