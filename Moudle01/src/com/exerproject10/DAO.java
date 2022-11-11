package com.exerproject10;

import java.util.*;

/**
 * @author zzl
 * @Description
 * @date 2021/10/11 - 15:34
 */
public class DAO<T>{
    private Map<String,T> map = new HashMap<>();

    public void save(String id,T entity){
        map.put(id, entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id,T entity){
        if(map.containsKey(id)){
            map.put(id,entity);
        }else
            throw  new RuntimeException("hhh");
    }

    public void delete(String id){

            map.remove(id);
    }
    public List<T> list(){
        Collection<T> coll = map.values();
        List<T> list = new ArrayList<>();
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }

    public Map<String, T> getMap() {
        return map;
    }

    public void setMap(Map<String, T> map) {
        this.map = map;
    }
}
