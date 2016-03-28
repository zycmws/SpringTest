package mybatis.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: PageMap.class
 * @Description:对分页的基本数据进行一个简单的封装

 */
@SuppressWarnings("rawtypes")
public class PageMap<T> implements Map {

	private int startNum= 0;//开始页数，默认是0开始
	private int pageSize = 10;// 每页显示的记录数，默认是10
	private int totalRecord=-1;// 总记录数
	private int totalPage;// 总页数
	private Map params = new HashMap();// 其他的参数我们把它分装成一个Map对象
	private List<T> result = new ArrayList<T>();
	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		// 在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
		int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
		this.setTotalPage(totalPage);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Page [startNum=").append(startNum).append(", pageSize=").append(pageSize).append(", results=").append(result.toString()).append(", totalPage=").append(totalPage).append(", totalRecord=").append(totalRecord).append("]");
		return builder.toString();
	}

	@Override
	public int size() {
		return params.size();
	}

	@Override
	public boolean isEmpty() {
		return params.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return params.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return params.containsKey(value);
	}

	@Override
	public Object get(Object key) {
		return params.get(key);
	}

	@Override
	public Object put(Object key, Object value) {
		return params.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		return params.remove(key);
	}

	@Override
	public void putAll(Map m) {
		params.putAll(m);
	}

	@Override
	public void clear() {
		params.clear();
	}

	@Override
	public Set keySet() {
		return params.keySet();
	}

	@Override
	public Collection values() {
		return params.values();
	}

	@Override
	public Set entrySet() {
		return params.entrySet();
	}
}
