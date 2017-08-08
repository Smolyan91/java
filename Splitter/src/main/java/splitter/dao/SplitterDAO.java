package splitter.dao;

import splitter.model.TwitSplit;
import splitter.model.Splitter;

import java.util.List;

/**
 * Created by igor on 08.08.17.
 */
public interface SplitterDAO {

    void addSplitter(Splitter splitter);
    Splitter getSplitterById(long id);
    void saveSplitter(Splitter splitter);
    List<TwitSplit> getRecentTwitSplit();
    void saveTwitSplit(TwitSplit twitSplit);
    List<TwitSplit> getTwitSplitBySplitter(Splitter splitter);
    Splitter getSplitterByUsername(String username);
    void deleteTwitSplit(long id);
    TwitSplit getTwitSplitById(long id);
    List<Splitter> findAllSplitters();
}
