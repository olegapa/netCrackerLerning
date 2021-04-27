package learntaskfour.analize;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analise {
    private String str1, str2;

    public Analise(String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
    }

    //частотный анализ символов из 1 строки
    public Map<Character, Integer> charFreqAnalise(){
        Map<Character, Integer> res = new HashMap<>();
        for(int i = 0; i < str1.length(); i++){
            char c = str1.charAt(i);

            if(res.containsKey(c))
                res.put(c, res.get(c) + 1);
            else
                res.put(c, 1);
        }
        return res;
    }

    //Частотный анализ слов из 1 строки
    public Map<String, Integer> wordFreqAnalise(){
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(str1.toLowerCase());

        Map<String, Integer> res = new HashMap<>();

        while (matcher.find()){
            String s = matcher.group();

            if(res.containsKey(s))
                res.put(s, res.get(s) + 1);
            else
                res.put(s, 1);
        }

        return res;
    }

    //печатает результат частотного анализа слов
    public void printWordFreqAnalise(){
        for(Map.Entry entry: wordFreqAnalise().entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    //Печатает результат частотного анализа символов
    public void printCharFreqAnalise(){
        for(Map.Entry entry: charFreqAnalise().entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    //возращает множество символов из строки
    private Set<Character> getCharSet(String str){
        Set<Character> res = new HashSet<>();
        for(int i = 0; i < str.length(); i++)
            res.add(str.charAt(i));

        return res;
    }

    //Возвращает множество символов, содержащихся только в обоих строках
    public Set<Character> charsInBoth(){

        Set<Character> res = new HashSet<>(getCharSet(str1));

        res.retainAll(getCharSet(str2));
        return res;
    }
    //Возвращает множество символов, содержащихся хотя бы в одной строке
    public Set<Character> charsSum(){
        Set<Character> res = new HashSet<>(getCharSet(str1));

        res.addAll(getCharSet(str2));
        return res;
    }

    //Возвращает множество символов, содержащихся только в 1 строке
    public Set<Character> charsInFirstOnly(){
        Set<Character> res = new HashSet<>(getCharSet(str1));

        res.removeAll(getCharSet(str2));
        return res;
    }

    //вывод символов в обычном порядке
    public void simpleOutput(Set<Character> set){
        for(Character i: set)
            System.out.print(i);
        System.out.println();
    }

    //вывод символов в обратном порядке порядке
    public void reversedOutput(Set<Character> set){
        List<Character> list = new ArrayList<>(set);

        for(int i = list.size()-1; i >= 0; i--)
            System.out.print(list.get(i));

        System.out.println();
    }

    //вывод символов в порядке, зависящем от hash-кода символа
    public void specialOutput(Set<Character> set, int n){
        List<Character> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(o -> o.hashCode() << n));

        for(Character i: list)
            System.out.print(i);
        System.out.println();
    }
}
