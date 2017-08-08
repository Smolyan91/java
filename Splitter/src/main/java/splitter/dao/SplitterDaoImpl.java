package splitter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import splitter.model.Splitter;
import splitter.model.TwitSplit;

import java.util.List;

/**
 * Created by igor on 08.08.17.
 */
@Repository
public class SplitterDaoImpl implements SplitterDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public SplitterDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession(){
        return  sessionFactory.getCurrentSession();
    }

    public void addSplitter(Splitter splitter) {
        currentSession().save(splitter);
    }

    public Splitter getSplitterById(long id) {
        return (Splitter) currentSession().get(Splitter.class, id);
    }

    public void saveSplitter(Splitter splitter) {
        currentSession().update(splitter);
    }

    public List<TwitSplit> getRecentTwitSplit() {
        return null;
    }

    public void saveTwitSplit(TwitSplit twitSplit) {
        currentSession().save(twitSplit);
    }

    public List<TwitSplit> getTwitSplitBySplitter(Splitter splitter) {
        return null;
    }

    public Splitter getSplitterByUsername(String username) {
        return null;
    }

    public void deleteTwitSplit(long id) {
        currentSession().delete(getTwitSplitById(id));
    }

    public TwitSplit getTwitSplitById(long id) {
        return (TwitSplit) currentSession().get(TwitSplit.class, id);
    }

    public List<Splitter> findAllSplitters() {
        return null;
    }
}
