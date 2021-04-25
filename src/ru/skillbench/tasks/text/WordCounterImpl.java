package ru.skillbench.tasks.text;

import java.io.PrintStream;
import java.util.*;

public class WordCounterImpl implements WordCounter{
    String text;

    public WordCounterImpl(){
        text = null;
    }
    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Map<String, Long> getWordCounts() {
        if(text == null)
            throw new IllegalStateException();

        Map<String, Long> res = new HashMap<>();

        String[] words = text.trim().toLowerCase().split("\\s+");

        for(String i: words){
            if(i.matches("<.*>") || i.length() == 0)
                continue;
            if(res.containsKey(i))
                res.put(i, res.get(i) + 1L);
            else  res.put(i, 1L);
        }

        return res;
    }

    @Override
    public List<Map.Entry<String, Long>> getWordCountsSorted() {
        Comparator<Map.Entry<String, Long>> comp = new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                if((o1.getValue()).compareTo(o2.getValue()) == 0)
                    return o1.getKey().compareTo(o2.getKey());
                return o1.getValue().compareTo(o2.getValue());
            }
        };
        return sort(getWordCounts(), comp);
    }

    private  <K extends Comparable<K>, V extends Comparable<V>> Map.Entry<K, V> popMin(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator){
        Map.Entry<K, V> res = null;
        for(Map.Entry<K, V> i: map.entrySet()){
            if (res == null)
                res = i;
            else if(comparator.compare(i, res) > 0)
                res = i;
        }
        assert res != null;
        map.remove(res.getKey());
        return res;
    }

    @Override
    public <K extends Comparable<K>, V extends Comparable<V>> List<Map.Entry<K, V>> sort(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
        List<Map.Entry<K, V>> res = new ArrayList<>();

        while (!map.isEmpty())
            res.add(popMin(map, comparator));

        return res;
    }

    @Override
    public <K, V> void print(List<Map.Entry<K, V>> entries, PrintStream ps) {
        for(Map.Entry<K, V> i: entries)
            ps.println(i.getKey() + " " + i.getValue());
    }
}
