package web.com.ibm.bean;

public class Train {
	int trainNo;
	String trainName;
	String source;
	String destination;
	double ticketPrice;
	
	
	public Train()
	{
		
	}
	
	public Train(int trainNo, String trainName, String source, String destination, double ticketPrice) {
		//super();
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.ticketPrice = ticketPrice;
	}
	public int getTrainNo() {
		//System.out.println(trainNo);
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getTicketPrice() {
		return ticketPrice;
		
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String toString(Train t)
	{
		return t.getTrainNo()+" "+t.getTrainName()+" "+t.getSource()+" "+t.getDestination()+" "+t.getTicketPrice();
	}
}
