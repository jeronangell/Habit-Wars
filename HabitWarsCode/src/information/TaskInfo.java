package information;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
/* i need to make it so each day i login all tasks are set to be unchecked
 * any due tasks subtract health.
 * 
 */
public class TaskInfo {
	//creates the TaskInfo data type.
	private String name="";
	private LocalDate startDate=LocalDate.now();
	private int timeType=0;
	private int dificulty=0;
	private int repeatEvery=0;
	private int id=0;
	private boolean checked=false;
	private boolean[] dayOfWeek=new boolean[7];
	private boolean taskDue=false;
	
	public TaskInfo(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDificulty() {
		return dificulty;
	}
	public void setDificulty(int dificulty) {
		this.dificulty = dificulty;
	}
	
	public boolean[] getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(boolean[] dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public int getRepeatEvery() {
		return repeatEvery;
	}
	public void setRepeatEvery(int repeatEvery) {
		this.repeatEvery = repeatEvery;
	}
	public int getTimeType() {
		return timeType;
	}
	public void setTimeType(int timeType) {
		this.timeType = timeType;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate objectProperty) {
		this.startDate = objectProperty;
	}
	@Override
	 public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + id;
	        result = prime * result + ((name == null) ? 0 : name.hashCode());
	        return result;
	    }
	 @Override
     public boolean equals(Object obj) {
		 if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
		 TaskInfo task=(TaskInfo)obj;
		 if(task.getId()==id){
	    	   return true;
	       }else{
	    	   return false;
	       }
     }
	 
	public int getId() {
		return id;
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}  
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

		
		return "Task Name ("+this.name+") id ("+id+") is checked ("+isChecked()+") difficulty ("+this.dificulty+
				") startDate ("+this.startDate.format(formatter).toString()+")";
	}
	
	public void readString(String taskString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		if(taskString.length()>10){
			String[] arr = taskString.split("[\\(\\)]");
			name=arr[1];
			id=Integer.parseInt(arr[3]);
			setChecked(Boolean.parseBoolean(arr[5]));
			setDificulty(Integer.parseInt(arr[7]));
			startDate=LocalDate.parse(arr[9], formatter);
			if(startDate.toEpochDay()<LocalDate.now().toEpochDay()){
				setTaskDue(true);
			}
		}
	}
	public boolean isTaskDue() {
		if(startDate.toEpochDay()<LocalDate.now().toEpochDay()){
			setTaskDue(true);
			System.out.println("task is due");
		}
		return taskDue;
	}
	public void setTaskDue(boolean taskDue) {
		this.taskDue = taskDue;
	}
}
