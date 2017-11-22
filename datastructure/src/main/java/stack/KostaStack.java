package stack;

public interface KostaStack {

	/**
	 * 파라미터로 전달된 데이터를 스택에 삽입한다.
	 * @param value
	 */
	public abstract void push(int value);
	
	/**
	 * 스택에 저장된 데이터 중 가장 마지막에 삽입된 데이터를 반환환다.
	 * @return
	 */
	public abstract int pop();
	
	/**
	 * 제일 마지막에 삽입된 데이터를 반환하고 데이터를 삭제한다.
	 * @return
	 */
	public abstract int peek();
	
	/**
	 * 스택이 가득찼는지 여부를 반환한다.
	 * @return
	 */
	public abstract boolean isFull();
	
	/**
	 * 스택이 비어있는지 여부를 반환한다.
	 * @return
	 */
	public abstract boolean isEmpty();
	
}
