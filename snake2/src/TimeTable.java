

public class TimeTable {
	

	private float MPC;
	

	private long LastUp;

	private int CollapsedCycle;

	private float Ex_cycle;

	private boolean Pasue ;

	public TimeTable(float cyclesPerSecond) {
		setCyclesPerSecond(cyclesPerSecond);
		reset();
	}
	

	public void setCyclesPerSecond(float cyclesPerSecond) {
		this.MPC = (1.0f / cyclesPerSecond) * 1000;
	}

	public void reset() {
		this.CollapsedCycle = 0;
		this.Ex_cycle = 0.0f;
		this.LastUp = getCurrentTime();
		this.Pasue  = false;
	}
	
	public void update() {
		
		long currUpdate = getCurrentTime();
		float delta = (float)(currUpdate - LastUp) + Ex_cycle;
		

		if(!Pasue ) {
			this.CollapsedCycle += (int)Math.floor(delta / MPC);
			this.Ex_cycle = delta % MPC;
		}
		
		this.LastUp = currUpdate;
	}

	public void setPaused(boolean paused) {
		this.Pasue  = paused;
	}
	

	public boolean Pasue () {
		return Pasue ;
	}

	public boolean hasElapsedCycle() {
		if(CollapsedCycle > 0) {
			this.CollapsedCycle--;
			return true;
		}
		return false;
	}
	

	public boolean peekElapsedCycle() {
		return (CollapsedCycle > 0);
	}
	

	private static final long getCurrentTime() {
		return (System.nanoTime() / 1000000L);
	}

}
