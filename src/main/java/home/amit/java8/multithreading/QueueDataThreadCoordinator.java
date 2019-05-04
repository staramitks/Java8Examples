package home.amit.java8.multithreading;

public class QueueDataThreadCoordinator {
	
	private DataObjectDTO dataObjectDTO;
	
	public QueueDataThreadCoordinator( DataObjectDTO dataObjectDTO)
	{
		this.dataObjectDTO=dataObjectDTO;
	}
	
	public synchronized void  addElement(String input)
	{
		
	 if (dataObjectDTO.getDataQueue().isEmpty())
	 {
		 System.out.println("Element added by "+Thread.currentThread().getName());
		 dataObjectDTO.getDataQueue().add(input);
		 dataObjectDTO.setReverseFlag(false);
		 notifyAll();
	 }
	 else
	 {
		 try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
	}
	
	public synchronized void  reverseElement()
	{
		if (!dataObjectDTO.getDataQueue().isEmpty()&& !dataObjectDTO.isReverseFlag())
		 {
				String inputString=dataObjectDTO.getDataQueue().element();
				char[] charArray = inputString.toCharArray();
				char[] revCharArray = inputString.toCharArray();
				for (int pointer=charArray.length-1, revCounter=0;pointer>=0;pointer--,revCounter++)
				{
					revCharArray[revCounter]=charArray[pointer];
				}
				String reversedString=String.valueOf(revCharArray);
				dataObjectDTO.getDataQueue().remove();
				dataObjectDTO.getDataQueue().add(reversedString);
				dataObjectDTO.setReverseFlag(true);	
				System.out.println("Mutated String  "+Thread.currentThread().getName() + " " +dataObjectDTO.getDataQueue().peek().toString());
				notifyAll();
		 }
		 else
		 {
			 try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	}
	
	public synchronized void  displayElement()
	{
		if (!dataObjectDTO.getDataQueue().isEmpty()&& dataObjectDTO.isReverseFlag())
		 {
			System.out.println(Thread.currentThread().getName() +   " " +dataObjectDTO.getDataQueue().poll().toString());
			notifyAll();
		 }
		 else
		 {
			 try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		
	}

	/**
	 * @return the dataObjectDTO
	 */
	public DataObjectDTO getDataObjectDTO() {
		return dataObjectDTO;
	}

	/**
	 * @param dataObjectDTO the dataObjectDTO to set
	 */
	public void setDataObjectDTO(DataObjectDTO dataObjectDTO) {
		this.dataObjectDTO = dataObjectDTO;
	}
}
