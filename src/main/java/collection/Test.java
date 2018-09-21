package collection;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSequentialList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;

/**
 * 集合Collection
 * 
 * 集合特征： 1 元素
 * 		   2  元素之间关系
 * 
 * List:一系列元素的集合，元素之间具有线性顺序关系。
 * Set：一系列不相同元素的集合。
 * Map：映射块集合
 * 
 * @author Administrator
 *
 */

public class Test {
	public static void main(String[] args) {
		Collection<String> collection = null;
		Map<String, String> map = null;
		
		Set<String> set = null; 
		List<String> list = null;
		
		AbstractCollection<String> abstractCollection = null;
		AbstractMap<String, String> abstractMap = null;
		AbstractList<String> abstractList = null;
		AbstractSet<String> abstractSet = null;
		
		SortedSet<String> sortedSet = null;
		
		ArrayList<String> arrayList = null;
		AbstractSequentialList<String> abstractSequentialList = null;
		LinkedList<String> linkedList = null;
		HashSet<String> hashSet = null;
		TreeSet<String> treeSet = null;
		@Deprecated
		Vector<String> verctor = null;
		@Deprecated
		Stack<String> stack = null;
		
		SortedMap<String,String> sortedMap = null;
		
		HashMap<String,String> hashMap = null;
		TreeMap<String,String> treeMap = null;
		WeakHashMap<String,String> weakHashMap = null;
		@Deprecated
		Hashtable<String,String> hashTable = null;
		
		Iterator<String> iterator = null;
		ListIterator<String> listIterator = null;
		
		Comparable comparable = null;
		Comparator<String> comparator = null;
		
		Collections collections = null;
		Arrays arrays = null;
	}
	
	
	private void collection(){
		Collection<String> collection = null;
		
		collection.add("e");
		collection.addAll(collection);
		
		collection.remove("e");
		collection.removeAll(collection);
		collection.clear();
		collection.retainAll(collection);
		
		collection.size();
		collection.isEmpty();
		collection.contains("e");
		collection.containsAll(collection);
		
		collection.iterator();
		
		collection.toArray();
		collection.toArray(null);
		collection.equals(collection);
		collection.hashCode();
	}
	
	private void list(){
		List<String> list = null;
		
		//添加
		list.add(0, "e");
		list.addAll(0, list);
		list.set(0, "e");
		
		//移除
		list.remove(0);
		
		//检索
		list.get(0);
		
		//判断
		list.indexOf("e");
		list.lastIndexOf("e");
		
		list.listIterator();
		list.listIterator(0);
		list.subList(0, 10);
		
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return 0;
			}
		});
	}
	
	/**
	 * Queue implements Collection
	 */
	private void queue(){
		Queue<String> queue = null;
		//添加元素，如果添加失败返回false
		queue.offer("e");
		//获取并删除，失败返回null
		queue.poll();
		//获取，失败返回null
		queue.peek();
		//获取，失败报异常
		queue.element();
	}
	
	/**
	 * Deque implements Queue
	 */
	private void deque(){
		Deque<String> deque = null;
		
		deque.addFirst("e");
		deque.addLast("e");
		deque.offerFirst("e");
		deque.offerLast("e");
		deque.removeFirst();
		deque.removeLast();
		deque.remove();
		deque.removeFirstOccurrence("e");
		deque.removeLastOccurrence("e");
		deque.push("e");
		deque.pop();
		deque.peekFirst();
		deque.peekLast();
		deque.pollFirst();
		deque.pollLast();
		deque.element();
		deque.getFirst();
		deque.getLast();
		deque.descendingIterator();
	}
	
	

	/**
	 * LinkedList extends AbstractSequentialList implements List,Deque,Cloneable,Serializeable
	 */
	private void linkedList(){
		LinkedList<String> list = null;
	}
	
	
	/**
	 * ArrayList extends AbstractList implements List,RandomAccess,Cloneable,Serializable
	 */
	private void arrayList(){
		ArrayList list = null;
		
		list.clone();
		list.trimToSize();
		list.ensureCapacity(10);
	}
	
	private void set(){
		
	}
	
	/**
	 * SortedSet implements Set
	 */
	private void sortSet(){
		SortedSet<String> set = null;
		
		set.comparator();
		set.first();
		set.last();
		set.headSet("e");
		set.tailSet("e");
		set.subSet("from", "to");
	}
	
	/**
	 * NavigableSet implements SortedSet
	 */
	private void navigableSet(){
		NavigableSet<String> navigableSet = null;
		
		navigableSet.pollFirst();
		navigableSet.pollLast();
		
		navigableSet.lower("e");
		navigableSet.higher("e");
		navigableSet.ceiling("e");
		navigableSet.floor("e");
		navigableSet.headSet("e", true);
		navigableSet.tailSet("e", true);
		navigableSet.subSet("from",true, "to", true);
		
		navigableSet.descendingIterator();
		navigableSet.descendingSet();
	}
	
	/**
	 * HashSet extends AbstractSet implements Set,Cloneable,Serializable
	 */
	private void hashSet(){
		HashSet hashSet = null;
	}
	
	
	/**
	 * TreeSet extends AbstractSet implements NavigableSet,Cloneable,Serializeable
	 * Backup NavigableMap
	 */
	private void treeSet(){
		TreeSet treeSet = null;
	}
	
	
	private void map(){
		Map<String,String>  map = null;
		
		map.put("key", "value");
		map.putAll(map);
		map.putIfAbsent("key","value");
		map.remove("key");
		map.remove("key", "value");
		map.replace("key", "value");
		map.replace("key", "oldValue", "newValue");
		
		map.get("key");
		map.containsValue("value");
		map.clear();
		map.size();
		map.isEmpty();
		
		map.entrySet();
		map.keySet();
		map.values();
		
		map.equals(map);
		map.hashCode();
		map.getOrDefault("key", "defaultValue");
	}
	
	/**
	 * SortedMap implements Map
	 */
	private void sortedMap(){
		SortedMap<String, String> sortedMap = null;
		
		sortedMap.comparator();
		sortedMap.firstKey();
		sortedMap.lastKey();
		sortedMap.subMap("from", "to");
		sortedMap.headMap("to");
		sortedMap.tailMap("from");
	}
	
	/**
	 * NavigableMap implements SortedMap
	 */
	private void navigableMap(){
		NavigableMap<String, String> navigableMap = null;
		
		navigableMap.lowerEntry("key");
		navigableMap.lowerKey("key");
		navigableMap.higherEntry("key");
		navigableMap.higherKey("key");
		navigableMap.ceilingEntry("key");
		navigableMap.ceilingKey("key");
		navigableMap.headMap("toKey", true);
		navigableMap.tailMap("fromKey", true);
		navigableMap.subMap("fromKey",true, "toKey",true);
		
		navigableMap.descendingKeySet();
		navigableMap.descendingMap();
	}
	
	
	/**
	 * TreeMap extends AbstractMap implements NavigableMap,Cloneable,Serializable
	 */
	private void treeMap(){
		TreeMap treeMap = null;
		
	}
	
	
	/**
	 * HashMap extends AbstractMap implements Map,Cloneable,Serializable
	 */
	private void hasMap(){
		HashMap map = null;
	}
	
	
	/**
	 * WeakHashMap extends AbstractMap implements Map
	 */
	private void weakHashMap(){
		WeakHashMap<String,String> weakHashMap = null;
		
	}
	
}
