package queue;

public interface KostaQueue {

	/**
	 * 파라미터로 전달된 데이터를 큐에 삽입한다.
	 * @param value
	 * @return
	 */
	public abstract boolean offer(int value);
	
	/**
	 * 제일 먼저 삽입된 데이터를 반환하고 데이터를 삭제한다.
	 * @return
	 */
	public abstract int peek();
	
	/**
	 * 제일 먼저 삽입된 데이터를 반환한다.
	 * 데이터를 삭제하지 않고 유지한다.
	 * @return
	 */
	public abstract int poll();
	
	/**
	 * 큐의 길이를 반환한다.
	 * @return
	 */
	public abstract int size();
	
	/**
	 * 큐가 비어있는지 여부를 반환한다.
	 * @return
	 */
	public abstract boolean empty(); 
}
