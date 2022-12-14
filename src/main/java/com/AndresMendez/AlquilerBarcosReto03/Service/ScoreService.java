package com.AndresMendez.AlquilerBarcosReto03.Service;

import com.AndresMendez.AlquilerBarcosReto03.Modelo.Score;
import com.AndresMendez.AlquilerBarcosReto03.Repository.ScoreRepository;
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
            Optional<Score> auxS = scoreRepository.getScore(score.getIdScore());
            if (auxS.isPresent()) {
                return score;
            } else {
                return scoreRepository.save(score);
            }
        }
    }

    public Score update(Score score) {
        if (score.getIdScore() != null) {
            Optional<Score> q = scoreRepository.getScore(score.getIdScore());
            if (q.isPresent()) {
                if (score.getMessageText() != null) {
                    q.get().setMessageText(score.getMessageText());
                }
                if (score.getStars() != null) {
                    q.get().setStars(score.getStars());
                }
                scoreRepository.save(q.get());
                return q.get();
            } else {
                return score;
            }
        } else {
            return score;
        }
    }

    public boolean delete(int idScore) {
        boolean flag = false;
        Optional<Score> score = scoreRepository.getScore(idScore);
        if (score.isPresent()) {
            scoreRepository.delete(score.get());
            flag = true;
        }
        return flag;
    }
}
