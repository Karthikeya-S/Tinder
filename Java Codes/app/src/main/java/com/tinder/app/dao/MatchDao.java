package com.tinder.app.dao;
import com.tinder.app.model.Match;
import com.tinder.app.model.User;
import java.util.List;

public interface MatchDao {
    void addMatch(Match match);
    void deleteMatch(int matchId);
    List<User> getMatches(User user);
    List<User> getLikedUsers(User user);
}
